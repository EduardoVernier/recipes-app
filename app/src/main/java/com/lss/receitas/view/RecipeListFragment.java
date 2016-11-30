package com.lss.receitas.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lss.receitas.R;
import com.lss.receitas.model.network.RetrofitManager;
import com.lss.receitas.model.network.response.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeListFragment extends Fragment
		implements RecipeAdapter.OnListFragmentInteractionListener{

	private RecipeAdapter recipeAdapter;
	private List<Recipe> recipeList;

	public RecipeListFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		recipeList = new ArrayList<Recipe>();
		recipeAdapter = new RecipeAdapter(recipeList, this, this.getContext());

		RetrofitManager.requestRecipeList(this);
	}

	public void updateRecipeList(List<Recipe> recipeList) {

		this.recipeList.clear();
		this.recipeList.addAll(recipeList);
		recipeAdapter.notifyDataSetChanged();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		RecyclerView recyclerView = (RecyclerView)
				inflater.inflate(R.layout.fragment_recipe_list, container, false);

		recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
		recyclerView.setAdapter(recipeAdapter);
		return recyclerView;
	}


	@Override
	public void onListFragmentInteraction(Recipe recipe) {
		int id = recipe.getId();
//		String endpoint = recipe.detailUrl.substring(recipe.detailUrl.lastIndexOf('/')+1);
//
		Intent intent = new Intent(RecipeListFragment.this.getContext(), RecipeDetailActivity.class);
//		intent.putExtra("endpoint", endpoint);
		intent.putExtra("id", id);
		startActivity(intent);
	}
}
