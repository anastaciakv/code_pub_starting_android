package de.codepub.bakeandroid.binding;


import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingAdapters {

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("imageUrl")
    public static void bindImage(ImageView imageView, String url) {
        if (url == null || url.isEmpty()) return;
        Picasso.with(imageView.getContext())
                .load(url)
                .error(android.R.drawable.stat_notify_error)
                .into(imageView);
    }
}
