package com.lss.receitas.model.network;

import android.content.Context;

import com.lss.receitas.RecipeDetailActivity;
import com.lss.receitas.model.network.response.RecipeDetail;
import com.lss.receitas.model.network.response.RecipeListResponse;
import com.lss.receitas.view.RecipeListFragment;

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
				.baseUrl("http://www.mocky.io/v2/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		service = retrofit.create(Service.class);
	}

	public static void requestRecipeList(final RecipeListFragment recipeListFragment) {

		Call<RecipeListResponse> call = service.getRecipeList();
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

	public static void requestRecipeDetail(final RecipeDetailActivity recipeDetailActivity, String detailUrl) {

		Call<RecipeDetail> call = service.getRecipeDetail(detailUrl);
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
