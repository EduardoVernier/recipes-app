
public class Recipe {
	public String name;
	public String[] ingredients;
	public int yield;
	public String time;
	
	public Recipe(String startName, String[] ingredients2, int startYield, String startTime)
	{
		name = startName;
		ingredients = ingredients2;
		yield = startYield;
		time = startTime;
	}
}
