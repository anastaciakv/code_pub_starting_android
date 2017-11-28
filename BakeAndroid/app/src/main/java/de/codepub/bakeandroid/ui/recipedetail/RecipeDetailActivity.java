package de.codepub.bakeandroid.ui.recipedetail;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.codepub.bakeandroid.R;
import de.codepub.bakeandroid.databinding.ActivityRecipeDetailBinding;
import de.codepub.bakeandroid.items.Recipe;

public class RecipeDetailActivity extends AppCompatActivity {
    private static final String KEY_RECIPE = "KEY_RECIPE";
    ActivityRecipeDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_detail);

        Recipe recipe = (Recipe) getIntent().getExtras().getSerializable(KEY_RECIPE);
        binding.setRecipe(recipe);

    }

    //todo read more https://developer.android.com/guide/components/activities/parcelables-and-bundles.html
    //todo read more https://developer.android.com/training/basics/firstapp/starting-activity.html
    public static void start(Context context, Recipe recipe) {
        Bundle extras = new Bundle();
        extras.putSerializable(KEY_RECIPE, recipe);
        Intent intent = new Intent(context, RecipeDetailActivity.class);
        intent.putExtras(extras);
        context.startActivity(intent);
    }

}
