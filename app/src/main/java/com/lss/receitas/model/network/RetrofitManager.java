package com.lss.receitas.model.network;

import android.content.Context;

import com.lss.receitas.R;
import com.lss.receitas.model.network.request.IngredientListRequest;
import com.lss.receitas.model.network.response.RecipeDetail;
import com.lss.receitas.model.network.response.RecipeListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
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
				.baseUrl(context.getString(R.string.WSUrl))
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		service = retrofit.create(Service.class);
	}

	public static void requestRecipeList(List<String> ingredientList, Callback<RecipeListResponse> searchResponse) {
//		List<String> lstIngr = new ArrayList<String>();
//		lstIngr.add("linguiça");
//		lstIngr.add("maçã");

//		Call<RecipeListResponse> call = service.getRecipeList_Old();
		Call<RecipeListResponse> call = service.getRecipeList(new IngredientListRequest(ingredientList));
		call.enqueue(searchResponse);
	}

//	public static void requestRecipeDetail(final RecipeDetailActivity recipeDetailActivity, String detailUrl) {
	public static void requestRecipeDetail(int id, Callback<RecipeDetail> recipeDetailCallback) {

//		Call<RecipeDetail> call = service.getRecipeDetail_Old(detailUrl);
		Call<RecipeDetail> call = service.getRecipeDetail(id);
		call.enqueue(recipeDetailCallback);
	}
}
