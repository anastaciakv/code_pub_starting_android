package de.codepub.bakeandroid.ui.recipelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import de.codepub.bakeandroid.R;
import de.codepub.bakeandroid.di.Injectable;

public class RecipeListActivity extends AppCompatActivity implements Injectable {
    @Inject
    private RecipeListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
    }
}
