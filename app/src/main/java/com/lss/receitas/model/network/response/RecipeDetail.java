package com.lss.receitas.model.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetail {
	@SerializedName("name")
	public String name;
	@SerializedName("prepTime")
	public String prepTime;
	@SerializedName("servings")
	public String servings;
	@SerializedName("ingredients")
	public List<String> ingredientList = new ArrayList<String>();
	@SerializedName("urlImage")
	public String urlImage;
	@SerializedName("preparationSteps")
	public List<String> preparationSteps = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public String getServings() {
		return servings;
	}

	public List<String> getIngredientList() {
		return ingredientList;
	}

	public String getIngredientString() {
		String concat = "";
		for (String ingredient : ingredientList)
		{
			concat += "- " + ingredient + '\n';
		}
		return concat;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public List<String> getPreparationSteps() {
		return preparationSteps;
	}

	public String getPreparationStepsString() {
		String concat = "";
		for (int i = 1; i <= preparationSteps.size(); ++i)
		{
			concat += i + ". " + preparationSteps.get(i-1) + '\n';
		}
		return concat;
	}
}
