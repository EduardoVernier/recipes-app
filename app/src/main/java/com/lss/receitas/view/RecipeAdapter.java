package com.lss.receitas.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lss.receitas.R;
import com.lss.receitas.model.network.response.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

	private final List<Recipe> recipeList;
	private final OnListFragmentInteractionListener listener;
	private Context context;

	public RecipeAdapter(List<Recipe> recipeList, OnListFragmentInteractionListener listener, Context context) {
		this.recipeList = recipeList;
		this.listener = listener;
		this.context = context;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.fragment_recipe, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(final ViewHolder holder, int position) {
		holder.item = recipeList.get(position);
		holder.recipeTitle.setText(holder.item.getName());
		holder.prepInfo.setText(holder.item.getPrepTime() + " - "
				+ holder.item.getServings() + " porções");

		holder.availableIngredients.setText(holder.item.getIngredientsString());
		holder.unavailableIngredients.setText(holder.item.getIngredientsString());


		Glide.with(context)
			.load(holder.item.getUrlImage())
			.diskCacheStrategy(DiskCacheStrategy.RESULT)
			.into(holder.recipeThumbnail);

		holder.view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				listener.onListFragmentInteraction(holder.item);
			}
		});
	}

	@Override
	public int getItemCount() {
		return recipeList.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public final View view;
		public final TextView recipeTitle;
		public final TextView prepInfo;
		private final TextView availableIngredients;
		private final TextView unavailableIngredients;
		private final ImageView recipeThumbnail;
		public Recipe item;

		public ViewHolder(View view) {
			super(view);
			this.view = view;
			recipeTitle = (TextView) view.findViewById(R.id.recipe_title);
			prepInfo = (TextView) view.findViewById(R.id.prep_info);
			availableIngredients = (TextView) view.findViewById(R.id.available_ingredients);
			unavailableIngredients = (TextView) view.findViewById(R.id.unavailable_ingredients);
			recipeThumbnail = (ImageView) view.findViewById(R.id.recipe_thumbnail);
		}

		@Override
		public String toString() {
			return super.toString() + " '" + prepInfo.getText() + "'";
		}
	}

	public interface OnListFragmentInteractionListener {
		void onListFragmentInteraction(Recipe recipe);
	}
}
