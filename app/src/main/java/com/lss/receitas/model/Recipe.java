package com.lss.receitas.model;

import java.util.ArrayList;
import java.util.List;


public class Recipe {

	private String title;
	private String prepTime;
	private String servings;
	private List<String> ingredients = new ArrayList<String>();
	private String urlImage;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getServings() {
		return servings;
	}

	public void setServings(String servings) {
		this.servings = servings;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public String getIngredientsString() {

		String output ="";
		for (String str: ingredients)
			output = output + " " + str;

		return output;
	}

	public void addIngredient(String ingredient) {
		this.ingredients.add(ingredient);
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}