package com.lss.receitas.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lss.receitas.R;

public class RecipeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);
		getSupportFragmentManager().beginTransaction()
				.add(R.id.activity_recipe, new RecipeListFragment())
				.commitAllowingStateLoss();
	}
}
