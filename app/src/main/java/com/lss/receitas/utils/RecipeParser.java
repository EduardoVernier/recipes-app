package com.lss.receitas.utils;

import com.lss.receitas.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecipeParser {

	private RecipeParser() {}

	static public ArrayList<Recipe> parseRecipes(String response) throws JSONException {

		ArrayList<Recipe> returnList = new ArrayList<Recipe>();
		JSONArray recipes = new JSONObject(response).getJSONArray("receitas");

		for (int i = 0; i < recipes.length(); i++) {

			Recipe newRecipe = new Recipe();

			JSONObject recipe = recipes.getJSONObject(i);
			newRecipe.setTitle(recipe.getString("nome"));
			newRecipe.setPrepTime(recipe.getString("tempoPreparo"));
			newRecipe.setServings(recipe.getString("rendimento"));
			newRecipe.setUrlImage(recipe.getString("urlImagem"));

			JSONArray ingredients = recipe.getJSONArray("igredientes");
			for (int j = 0; j < ingredients.length(); j++) {
				newRecipe.addIngredient(ingredients.getString(j));
			}

			returnList.add(newRecipe);
		}

		return returnList;
	}
}


