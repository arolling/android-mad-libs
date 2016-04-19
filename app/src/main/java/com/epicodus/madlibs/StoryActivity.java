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
        String noun2 = intent.getStringExtra("noun2"); //capitalize me!!!
        String noun3 = intent.getStringExtra("noun3");
        String pluralNoun1 = intent.getStringExtra("pluralNoun1");
        String pluralNoun2 = intent.getStringExtra("pluralNoun2");
        String pluralNoun3 = intent.getStringExtra("pluralNoun3");
        String pluralNoun4 = intent.getStringExtra("pluralNoun4");
        String pluralProf = intent.getStringExtra("pluralProf");
        String story = "Albert Einstein, the son of " + malCeleb + " and " + femCeleb +
                ", was born in Ulm, Germany, in 1879. In 1902, he had a job " +
                "as assistant " + noun3 + " in the Swiss patent office and attended " +
                "the University of Zurich. There he began studying atoms, molecules, and " + pluralNoun1 +
                ". He developed the theory of " + adjective1 +
                " relativity, which expanded the phenomena of sub-atomic " + pluralNoun3 +
                " and " + adjective2 + " magnetism. In 1921, " +
                "he won the Nobel prize for " + pluralNoun4 + " and was director of " +
                "theoretical physics at the Kaiser Wilhelm " + noun2 + " in Berlin. " +
                "In 1933, when Hitler became Chancellor of " + place + ", " +
                "Einstein came to America to take a post at Princeton Institute for " +
                pluralNoun2 + ", where his theories helped America devise the first" +
                "atomic " + noun1 + ". There is no question about it: Einstein was " +
                "one of the most brilliant " + pluralProf + "of our time.";
        mStoryHolder.setText("" + story);

    }
}
