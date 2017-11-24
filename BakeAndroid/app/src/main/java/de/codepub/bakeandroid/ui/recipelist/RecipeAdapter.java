package de.codepub.bakeandroid.ui.recipelist;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.codepub.bakeandroid.R;
import de.codepub.bakeandroid.databinding.RecipeItemBinding;
import de.codepub.bakeandroid.items.Recipe;

//todo read more about RecyclerView and Adapter https://developer.android.com/training/material/lists-cards.html

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    public interface RecipeClickCallback {

        void onClick(Recipe recipe);
    }

    final private RecipeClickCallback callback;

    List<Recipe> recipes = new ArrayList<>();

    public RecipeAdapter(RecipeClickCallback callback) {
        this.callback = callback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final RecipeItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.recipe_item, parent, false);
        binding.tvRecipeTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onClick(binding.getRecipe());
            }
        });
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void update(List<Recipe> items) {
        if (items == null) return;
        recipes.clear();
        recipes.addAll(items);
        notifyDataSetChanged();
    }

    //todo read more about DataBinding and ViewHolder https://medium.com/google-developers/android-data-binding-recyclerview-db7c40d9f0e4
    class ViewHolder extends RecyclerView.ViewHolder {

        private final RecipeItemBinding binding;

        public ViewHolder(RecipeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Recipe recipe) {
            binding.setRecipe(recipe);
        }
    }
}
