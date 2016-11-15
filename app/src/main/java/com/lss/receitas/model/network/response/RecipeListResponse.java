package com.lss.receitas.model.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecipeListResponse {
	@SerializedName("receitas")
	public List<Recipe> recipeList = new ArrayList<Recipe>();
}
