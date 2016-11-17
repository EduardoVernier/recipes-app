package com.lss.receitas.model.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	@SerializedName("id")
	public  int id;
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
	@SerializedName("detalhe")
	public String detailUrl;

	public int getId() { return id; }

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

	public String getUrlImage() {
		return urlImage;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public String getIngredientsString() {
		String concat = "";
		for (String ingredient : ingredientList)
		{
			concat += ingredient + " ";
		}
		return concat;
	}
}
