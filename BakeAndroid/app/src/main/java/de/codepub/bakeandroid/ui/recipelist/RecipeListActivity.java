package de.codepub.bakeandroid.ui.recipelist;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import de.codepub.bakeandroid.R;
import de.codepub.bakeandroid.databinding.ActivityRecipeListBinding;
import de.codepub.bakeandroid.di.Injectable;
import de.codepub.bakeandroid.items.Recipe;
import de.codepub.bakeandroid.ui.recipedetail.RecipeDetailActivity;

public class RecipeListActivity extends AppCompatActivity implements Injectable, RecipeAdapter.RecipeClickCallback {
    @Inject
    public RecipeListViewModel viewModel;

    private ActivityRecipeListBinding binding;
    private RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_list);
        binding.setViewModel(viewModel);
        setupList();
        viewModel.recipeList.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                updateRecipeList();
            }
        });
    }

    //todo read more about Activity Lifecycle
    @Override
    protected void onResume() {
        super.onResume();
        updateRecipeList();
    }

    private void setupList() {
        adapter = new RecipeAdapter(this);
        binding.rvRecipeList.setHasFixedSize(true);
        binding.rvRecipeList.setAdapter(adapter);
    }

    private void updateRecipeList() {
        adapter.update(viewModel.recipeList.get());
    }

    @Override
    public void onClick(Recipe recipe) {
        //done implement clicking on a recipe in the list
        RecipeDetailActivity.start(this, recipe);
    }
}
