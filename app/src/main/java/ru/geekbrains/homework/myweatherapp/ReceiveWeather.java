package ru.geekbrains.homework.myweatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveWeather extends AppCompatActivity {
    public final static String RECEIVE_ACTIVITY_STRING = "intent";
    private String temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_weather);
        if (savedInstanceState!=null){
            temperature=savedInstanceState.getString("temperature");
        }
        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra(RECEIVE_ACTIVITY_STRING);
            TextView textView = (TextView) findViewById(R.id.textview_receiver);
            textView.setText(message);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Intent intent = getIntent();
        if (intent != null) {
            String temperature = intent.getStringExtra(RECEIVE_ACTIVITY_STRING);
            outState.putString("temperature",temperature);
        }
    }
}
