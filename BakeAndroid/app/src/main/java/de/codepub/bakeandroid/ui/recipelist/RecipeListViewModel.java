package de.codepub.bakeandroid.ui.recipelist;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import java.util.List;

import de.codepub.bakeandroid.data.RecipeTask;
import de.codepub.bakeandroid.items.Recipe;

public class RecipeListViewModel {

    public ObservableBoolean isLoading = new ObservableBoolean(true);
    private final RecipeTask task;
    public ObservableField<List<Recipe>> recipeList = new ObservableField<>();
    private RecipeTask.Callback callback;

    public RecipeListViewModel(RecipeTask task) {
        this.task = task;
        task.fetchRecipes(getRecipesCallback());
    }

    private RecipeTask.Callback getRecipesCallback() {
        if (callback == null) {
            callback = new RecipeTask.Callback() {
                @Override
                public void onRecipesFetched(List<Recipe> recipeList) {
                    isLoading.set(false);
                }

                @Override
                public void onFailure() {
                    isLoading.set(false);
                }
            };
        }
        return callback;
    }
}
