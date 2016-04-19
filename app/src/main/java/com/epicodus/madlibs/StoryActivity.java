package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();
    @Bind(R.id.storyHolder) TextView mStoryHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String place = intent.getStringExtra("place");
        String adjective1 = intent.getStringExtra("adjective1");
        String adjective2 = intent.getStringExtra("adjective2");
        String femCeleb = intent.getStringExtra("femCeleb");
        String malCeleb = intent.getStringExtra("malCeleb");
        String noun1 = intent.getStringExtra("noun1");
        String noun2 = intent.getStringExtra("noun2");
        mStoryHolder.setText("Things entered: " + place + adjective1 + adjective2 + femCeleb + malCeleb + noun1 + noun2);

    }
}
