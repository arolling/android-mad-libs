package com.epicodus.madlibs;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.btnCreateStory) Button mBtnCreateStory;
    @Bind(R.id.tfPlace) EditText mTfPlace;
    @Bind(R.id.tfAdjective1) EditText mTfAdjective1;
    @Bind(R.id.tfAdjective2) EditText mTfAdjective2;
    @Bind(R.id.tfFemCeleb) EditText mTfFemCeleb;
    @Bind(R.id.tfMalCeleb) EditText mTfMalCeleb;
    @Bind(R.id.tfNoun1) EditText mTfNoun1;
    @Bind(R.id.tfNoun2) EditText mTfNoun2;
    @Bind(R.id.tfNoun3) EditText mTfNoun3;
    @Bind(R.id.tfPluralNoun1) EditText mTfPluralNoun1;
    @Bind(R.id.tfPluralNoun2) EditText mTfPluralNoun2;
    @Bind(R.id.tfPluralNoun3) EditText mTfPluralNoun3;
    @Bind(R.id.tfPluralNoun4) EditText mTfPluralNoun4;
    @Bind(R.id.tfPluralProf) EditText mTfPluralProf;
    @Bind(R.id.spinner) Spinner mStorySpinner;

    public static void hideSoftKeyboard(Activity activity){
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void setupUI(View view){
        if(!(view instanceof EditText)){
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(MainActivity.this);
                    return false;
                }
            });
        }

        if(view instanceof ViewGroup){
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++){
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI(findViewById(R.id.mainLayout));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.story_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStorySpinner.setAdapter(adapter);



        mBtnCreateStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String place = mTfPlace.getText().toString();
                String adjective1 = mTfAdjective1.getText().toString();
                String adjective2 = mTfAdjective2.getText().toString();
                String femCeleb = mTfFemCeleb.getText().toString();
                String malCeleb = mTfMalCeleb.getText().toString();
                String noun1 = mTfNoun1.getText().toString();
                String noun2 = mTfNoun2.getText().toString();
                String noun3 = mTfNoun3.getText().toString();
                String pluralNoun1 = mTfPluralNoun1.getText().toString();
                String pluralNoun2 = mTfPluralNoun2.getText().toString();
                String pluralNoun3 = mTfPluralNoun3.getText().toString();
                String pluralNoun4 = mTfPluralNoun4.getText().toString();
                String pluralProf = mTfPluralProf.getText().toString();
                String storyChoice = mStorySpinner.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("place", place);
                intent.putExtra("adjective1", adjective1);
                intent.putExtra("adjective2", adjective2);
                intent.putExtra("femCeleb", femCeleb);
                intent.putExtra("malCeleb", malCeleb);
                intent.putExtra("noun1", noun1);
                intent.putExtra("noun2", noun2);
                intent.putExtra("noun3", noun3);
                intent.putExtra("pluralNoun1", pluralNoun1);
                intent.putExtra("pluralNoun2", pluralNoun2);
                intent.putExtra("pluralNoun3", pluralNoun3);
                intent.putExtra("pluralNoun4", pluralNoun4);
                intent.putExtra("pluralProf", pluralProf);
                intent.putExtra("storyChoice", storyChoice);
                startActivity(intent);
            }
        });
    }
}
