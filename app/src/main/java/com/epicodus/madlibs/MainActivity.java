package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
                Intent intent = new Intent(MainActivity.this, StoryActivity.class);
                intent.putExtra("place", place);
                intent.putExtra("adjective1", adjective1);
                intent.putExtra("adjective2", adjective2);
                intent.putExtra("femCeleb", femCeleb);
                intent.putExtra("malCeleb", malCeleb);
                intent.putExtra("noun1", noun1);
                intent.putExtra("noun2", noun2);
                startActivity(intent);
            }
        });
    }
}
