package de.codepub.bakeandroid.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import de.codepub.bakeandroid.ui.recipedetail.RecipeDetailActivity;
import de.codepub.bakeandroid.ui.recipelist.RecipeListActivity;


@Module
public abstract class ScreenModule {

    //todo declare each screen in this module
    @ContributesAndroidInjector
    abstract RecipeListActivity contributeRecipeListActivity();

    @ContributesAndroidInjector
    abstract RecipeDetailActivity contributeRecipeDetailActivity();
}
