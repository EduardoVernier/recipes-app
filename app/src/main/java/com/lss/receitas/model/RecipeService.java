package com.lss.receitas.model;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lss.receitas.utils.RecipeParser;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class RecipeService extends java.util.Observable{

	private static RecipeService instance = null;
	private List<Recipe> recipeList;
	private RequestQueue queue;
	private Context context;

	private RecipeService() {}

	public static RecipeService getInstance() {

		if (instance == null) {
			instance = new RecipeService();
		}
		return instance;
	}

	public void init(List<Recipe> recipeList, Context context)
	{
		this.recipeList = recipeList;
		this.context = context;
		queue = Volley.newRequestQueue(context);
	}


	public void fetchRecipes()
	{
		String url = "http://www.mocky.io/v2/57feacd4130000aa13dee363";

		StringRequest recipeRequest = new StringRequest(Request.Method.GET, url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						try {
							ArrayList<Recipe> recipes = RecipeParser.parseRecipes(response);
							recipeList.clear();
							recipeList.addAll(recipes);

							setChanged();
							notifyObservers();


						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(context, "Error.", Toast.LENGTH_SHORT).show();
			}
		});

		queue.add(recipeRequest);

	}


}
