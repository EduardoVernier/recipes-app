package com.lss.receitas.model.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
	@SerializedName("nome")
	public String name;
	@SerializedName("tempoPreparo")
	public String prepTime;
	@SerializedName("rendimento")
	public String servings;
	@SerializedName("ingredientes")
	public List<String> ingredientList = new ArrayList<String>();
	@SerializedName("urlImagem")
	public String urlImage;
	@SerializedName("detalhe")
	public String detailUrl;

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
