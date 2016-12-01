package com.lss.receitas.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.lss.receitas.R;
import com.lss.receitas.model.network.request.IngredientListRequest;

public class IngredientListActivity extends AppCompatActivity {

	IngredientsAdapter adapter;
	RecyclerView recyclerView;
	EditText ingredientEditText;
	ImageButton addButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingredient_list);

		recyclerView = (RecyclerView) findViewById(R.id.ingredient_list);
		adapter = new IngredientsAdapter(this);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		ingredientEditText = (EditText) findViewById(R.id.ingredient_edit_text);
		ingredientEditText.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// If the event is a key-down event on the "enter" button
				if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
					addIngredient();
					return true;
				}
				return false;
			}
		});

		addButton = (ImageButton) findViewById(R.id.add_button);
		addButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				addIngredient();
			}
		});

		FloatingActionButton done = (FloatingActionButton) findViewById(R.id.done);
		done.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				IngredientListRequest ingredientList = new IngredientListRequest(adapter.getIngredientList());
				Intent intent = new Intent(IngredientListActivity.this, RecipeActivity.class);
				intent.putExtra("ingredientList", ingredientList); // using the (String name, Parcelable value) overload!
				startActivity(intent);
			}
		});
	}

	private void addIngredient() {

		String ingredient = String.valueOf(ingredientEditText.getText());
		adapter.addIngredient(ingredient);
		ingredientEditText.setText("");
	}


}

