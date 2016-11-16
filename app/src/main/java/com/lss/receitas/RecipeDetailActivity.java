package com.lss.receitas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lss.receitas.model.network.RetrofitManager;
import com.lss.receitas.model.network.response.RecipeDetail;

public class RecipeDetailActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe_detail);

//		String endpoint = getIntent().getExtras().getString("endpoint");
//		RetrofitManager.requestRecipeDetail(this, endpoint);
		int id = getIntent().getExtras().getInt("id");
		RetrofitManager.requestRecipeDetail(this, id);
	}

	public void updateUI(RecipeDetail recipe) {

		Glide.with(this)
				.load(recipe.getUrlImage())
				.diskCacheStrategy(DiskCacheStrategy.RESULT)
				.into((ImageView) findViewById(R.id.detail_main_image));

		TextView name = (TextView) findViewById(R.id.detail_name);
		name.setText(recipe.getName());

		TextView info = (TextView) findViewById(R.id.detail_info);
		info.setText(recipe.getPrepTime() + " - " + recipe.getServings());

		TextView ingredients = (TextView) findViewById(R.id.detail_ingredients);
		ingredients.setText(recipe.getIngredientString());

		TextView steps = (TextView) findViewById(R.id.detail_steps);
		steps.setText(recipe.getPreparationStepsString());

	}
}
