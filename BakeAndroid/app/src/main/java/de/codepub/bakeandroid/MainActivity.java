package de.codepub.bakeandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.codepub.bakeandroid.di.Injectable;

public class MainActivity extends AppCompatActivity implements Injectable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
