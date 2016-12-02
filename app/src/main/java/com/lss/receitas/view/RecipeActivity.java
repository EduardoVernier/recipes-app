package com.lss.receitas.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.lss.receitas.R;
import com.lss.receitas.model.network.request.IngredientListRequest;

public class RecipeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		Fragment recipeListFragment = new RecipeListFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelable("ingredientList", ((IngredientListRequest) getIntent().getParcelableExtra("ingredientList")));
		recipeListFragment.setArguments(bundle);

		setContentView(R.layout.activity_recipe);
		getSupportFragmentManager().beginTransaction()
				.add(R.id.activity_recipe, recipeListFragment)
				.commitAllowingStateLoss();
	}
}
