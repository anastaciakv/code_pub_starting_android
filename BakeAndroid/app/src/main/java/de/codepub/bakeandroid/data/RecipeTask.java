package de.codepub.bakeandroid.data;


import java.util.List;

import de.codepub.bakeandroid.items.Recipe;

public interface RecipeTask {
    void fetchRecipes(Callback callback);

    interface Callback {
        void onRecipesFetched(List<Recipe> recipeList);

        void onFailure();
    }
}
