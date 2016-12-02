package com.lss.receitas.model.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecipeDetail {

	@SerializedName("id")
	public String id;
	@SerializedName("name")
	public String name;
	@SerializedName("prepTime")
	public String prepTime;
	@SerializedName("servings")
	public String servings;
	@SerializedName("urlImage")
	public String urlImage;
	@SerializedName("ingredients")
	public List<Ingredient> ingredientList = new ArrayList<Ingredient>();
	@SerializedName("preparationSteps")
	public List<PreparationStep> preparationSteps = new ArrayList<PreparationStep>();


	public String getName() {
		return name;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public String getServings() {
		return servings;
	}

	public String getIngredientString() {
		String concat = "";
		for (Ingredient ingredient : ingredientList)
		{
			concat += "- " + ingredient.ingredient + '\n';
		}
		return concat;
	}

	public String getUrlImage() {
		return urlImage;
	}


	public String getPreparationStepsString() {
		String concat = "";
		for (int i = 1; i <= preparationSteps.size(); ++i)
		{
			concat += i + ". " + preparationSteps.get(i-1).step + '\n';
		}
		return concat;
	}

	public class Ingredient {
		@SerializedName("ingredient")
		public String ingredient;
	}

	public class PreparationStep {
		@SerializedName("step")
		public String step;
	}
}


