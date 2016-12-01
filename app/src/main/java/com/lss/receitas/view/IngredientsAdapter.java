package com.lss.receitas.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lss.receitas.R;

import java.util.ArrayList;
import java.util.List;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.ViewHolder> {

	private Context context;
	private List<String> ingredientList;

	public IngredientsAdapter(Context context) {
		this.context = context;
		ingredientList = new ArrayList<>();
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		LayoutInflater inflater = LayoutInflater.from(context);
		View ingredientView = inflater.inflate(R.layout.fragment_ingredient, parent, false);
		ViewHolder viewHolder = new ViewHolder(ingredientView);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {
		String ingredient = ingredientList.get(position);

		holder.ingredient.setText(ingredient);
		holder.removeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ingredientList.remove(holder.getAdapterPosition());
				notifyDataSetChanged();
			}
		});
	}

	@Override
	public int getItemCount() {
		return ingredientList.size();
	}

	public List<String> getIngredientList() {
		return ingredientList;
	}

	public void addIngredient(String ingredient) {

		ingredientList.add(0,ingredient);
		notifyDataSetChanged();
	}

	public static class ViewHolder extends  RecyclerView.ViewHolder {

		public TextView ingredient;
		public ImageButton removeButton;

		public ViewHolder(View itemView) {
			super(itemView);

			ingredient = (TextView) itemView.findViewById(R.id.ingredient_edit_text);
			removeButton = (ImageButton) itemView.findViewById(R.id.remove_button);
		}
	}

}