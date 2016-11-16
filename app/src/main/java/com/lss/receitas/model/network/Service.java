package com.lss.receitas.model.network;

import com.lss.receitas.model.network.response.IngredientListRequest;
import com.lss.receitas.model.network.response.RecipeDetail;
import com.lss.receitas.model.network.response.RecipeListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Service {

	@GET("581bc5e81000007503ea7729")
	Call<RecipeListResponse> getRecipeList_Old();

	@GET("{detail}")
	Call<RecipeDetail> getRecipeDetail(@Path("detail") String detail);

	@POST("recipe/search")
	Call<RecipeListResponse> getRecipeList(@Body IngredientListRequest lstIngred);

}
