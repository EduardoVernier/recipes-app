import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebScrapper {

   public static void main(String []args) throws IOException{
	   //collects all recipes' links
	   int page = 1;
	   String[] links = new String[100];
	   while(page <= 10)
	   {
		   String example = "http://tudogostoso.com.br/receitas-populares/"+page+"/";
		   Document doc = Jsoup.connect(example).userAgent("Chrome").timeout(5000).get();
		   Elements contents = (Elements) doc.getElementsByClass("box-hover");
		   int i = 0;
		   String href;
	
		   while(i < 10)
		   {
			   Elements tag = contents.get(i).getElementsByTag("a");
			   href = tag.get(0).attr("href");
			   links[i+(page-1)*10] = href;
			   i = i + 1;
		   }
		   //System.out.println(contents.size());
		   //Elements tag = contents.get(0).getElementsByTag("a");
		   //String link = tag.get(0).attr("href");
		   
		   page = page + 1;
	   }
	   
	   //collects data from each recipe
	   String mainLink = "http://tudogostoso.com.br";
	   Recipe[] recipesList = new Recipe[100];
	   int index = 0;
	   
	   for (String link : links)
	   { 
		   Document doc = Jsoup.connect(mainLink+link).userAgent("Chrome").timeout(5000).get();
		   
		   String temp = doc.getElementsByClass("recipe-title").get(0).text();
		   String name = temp.replaceAll("[\n0-9]+", "");
		   
		   String time = doc.getElementsByClass("dt-duration").get(0).text();
		   
		   temp = doc.getElementsByClass("p-yield num yield").get(0).val();
		   int yield = Integer.parseInt(temp);
		   
		   Elements ingredients_class = doc.getElementsByClass("p-ingredient");
		   String[] ingredients = new String[ingredients_class.size()];
		   int j = 0;
		   while(j < ingredients_class.size())
		   {
			   ingredients[j] = ingredients_class.get(j).text();
			   j = j + 1;
		   }
		   
		  // System.out.println(index+"-"+name);
		   Recipe newRecipe = new Recipe(name, ingredients, yield, time);
		   recipesList[index] = newRecipe;
		   index = index + 1;
	   }
	   
	   for (Recipe r : recipesList)
	   {
		   System.out.println(r.name);
	   }
   }
} 