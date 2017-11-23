package de.codepub.bakeandroid.data;


import java.util.List;

import de.codepub.bakeandroid.items.Recipe;
import retrofit2.Call;
import retrofit2.Response;

public class RecipeTaskRetrofit implements RecipeTask {
    ApiClient client;

    public RecipeTaskRetrofit(ApiClient client) {
        this.client = client;
    }

    @Override
    public void fetchRecipes(final Callback callback) {
        Call<List<Recipe>> call = client.getAllRecipes();
        call.enqueue(new retrofit2.Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                callback.onRecipesFetched(response.body());
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                callback.onFailure();
            }
        });
    }
}
