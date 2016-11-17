package com.lss.receitas.model.network;

import android.content.Context;

import com.lss.receitas.RecipeDetailActivity;
import com.lss.receitas.model.network.request.IngredientListRequest;
import com.lss.receitas.model.network.response.RecipeDetail;
import com.lss.receitas.model.network.response.RecipeListResponse;
import com.lss.receitas.view.RecipeListFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitManager {

	private static Retrofit retrofit;
	private static Service service;


	private RetrofitManager() {
	}

	public static void init(Context context) {

		retrofit = new Retrofit.Builder()
//				.baseUrl("http://www.mocky.io/v2/")
				.baseUrl("http://192.168.1.4:8080/recipes-web-service/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		service = retrofit.create(Service.class);
	}

	public static void requestRecipeList(final RecipeListFragment recipeListFragment) {
		List<String> lstIngr = new ArrayList<String>();
		lstIngr.add("linguiça");
		lstIngr.add("maçã");

//		Call<RecipeListResponse> call = service.getRecipeList_Old();
		Call<RecipeListResponse> call = service.getRecipeList(new IngredientListRequest(lstIngr));
		call.enqueue(new Callback<RecipeListResponse>() {
			@Override
			public void onResponse(Call<RecipeListResponse> call, Response<RecipeListResponse> response) {
				recipeListFragment.updateRecipeList(response.body().recipeList);
			}

			@Override
			public void onFailure(Call<RecipeListResponse> call, Throwable t) {

			}
		});
	}

//	public static void requestRecipeDetail(final RecipeDetailActivity recipeDetailActivity, String detailUrl) {
	public static void requestRecipeDetail(final RecipeDetailActivity recipeDetailActivity, int id) {

//		Call<RecipeDetail> call = service.getRecipeDetail_Old(detailUrl);
		Call<RecipeDetail> call = service.getRecipeDetail(id);
		call.enqueue(new Callback<RecipeDetail>() {
			@Override
			public void onResponse(Call<RecipeDetail> call, Response<RecipeDetail> response) {
				recipeDetailActivity.updateUI(response.body());
			}

			@Override
			public void onFailure(Call<RecipeDetail> call, Throwable t) {

			}
		});
	}
}
