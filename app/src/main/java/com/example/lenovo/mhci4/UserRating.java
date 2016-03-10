package com.example.lenovo.mhci4;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UserRating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_rating);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String rate = intent.getStringExtra(MainActivity.RATING);

        TextView textView1 = (TextView)findViewById(R.id.commenttxt);
        textView1.setTextSize(12);
        textView1.setText(message);

        TextView textView2 = (TextView)findViewById(R.id.ratingtxt);
        textView2.setTextSize(12);
        textView2.setText(rate);


    }

    public void returnHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
    }


}
