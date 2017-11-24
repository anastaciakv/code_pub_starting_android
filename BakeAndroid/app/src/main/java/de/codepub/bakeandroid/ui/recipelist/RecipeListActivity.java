package de.codepub.bakeandroid.ui.recipelist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import de.codepub.bakeandroid.R;
import de.codepub.bakeandroid.databinding.ActivityRecipeListBinding;
import de.codepub.bakeandroid.di.Injectable;

public class RecipeListActivity extends AppCompatActivity implements Injectable {
    @Inject
    public RecipeListViewModel viewModel;

    private ActivityRecipeListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recipe_list);
        binding.setViewModel(viewModel);
        //todo 1 create recipe adapter and setup list
        //todo 3 add on property changed listener

    }

    //todo 2 create method for updating recipe list
}
