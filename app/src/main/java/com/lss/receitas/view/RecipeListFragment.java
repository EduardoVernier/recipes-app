package com.lss.receitas.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lss.receitas.R;
import com.lss.receitas.RecipeAdapter;
import com.lss.receitas.model.Recipe;
import com.lss.receitas.model.RecipeService;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class RecipeListFragment extends Fragment
		implements RecipeAdapter.OnListFragmentInteractionListener{

	private RecipeAdapter recipeAdapter;
	private ArrayList<Recipe> recipeList;
	private RecipeService recipeService;

	public RecipeListFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		recipeList = new ArrayList<Recipe>();
		recipeAdapter = new RecipeAdapter(recipeList, this, this.getContext());

		recipeService = RecipeService.getInstance();
		recipeService.init(recipeList, getContext());
		recipeService.addObserver(new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				RecipeListFragment.this.recipeAdapter.notifyDataSetChanged();
			}
		});
		recipeService.fetchRecipes();
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

	}
}
