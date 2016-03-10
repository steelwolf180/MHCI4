package com.example.lenovo.mhci4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.lenovo.mhci4.MESSAGE";
    public final static String RATING = "com.example.lenovo.mhci4.RATING";
    private static TextView text_v;
    private static Button btnSubmit;
    private static RatingBar rating_b;

    public void listenForRatingBar(){
        rating_b = (RatingBar)findViewById(R.id.ratingBar);
        text_v = (TextView)findViewById(R.id.ratingtext);

        rating_b.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                       text_v.setText(String.valueOf(rating)
                       );
                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listenForRatingBar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void sendReview(View view){

        Intent intent = new Intent(this,UserRating.class);
        RatingBar rating_b = (RatingBar)findViewById(R.id.ratingBar);
        EditText editText = (EditText)findViewById(R.id.comments);
        TextView txtview = (TextView)findViewById(R.id.ratingtext);
        String message = editText.getText().toString();
        String rate = txtview.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(RATING, rate);
        startActivity(intent);
    }
}
