package ru.geekbrains.homework.myweatherapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.effect.Effect;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Map;
import java.util.Set;

import static ru.geekbrains.homework.myweatherapp.R.string.list_of_cities;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner spinner_of_cities;
    private TextView textView;
    private Cities cities = new Cities();
    int spinnerPosition = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            spinner_of_cities.setSelection(spinnerPosition);
        }
        spinner_of_cities = (Spinner) findViewById(R.id.spinner_of_cities);
        textView = (TextView) findViewById(R.id.weather_result);
        button = (Button) findViewById(R.id.choose_weather);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sendMessage();
            }
        });


    }

    private void sendMessage() {
        String list_of_cities = String.valueOf(spinner_of_cities.getSelectedItem());
        String result = cities.getWeather(getBaseContext(), list_of_cities);
        Intent intent = new Intent(this, ReceiveWeather.class);
        intent.putExtra(ReceiveWeather.RECEIVE_ACTIVITY_STRING, result);
        startActivity(intent);
    }

    protected void onPause() {
        super.onPause();
        SharedPreferences sPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        int spinnerPosition = spinner_of_cities.getSelectedItemPosition();
        editor.putInt("spinnerChoice",spinnerPosition);//Не могу понять как указать значение города для схранения в префы
        editor.apply();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int spinnerPosition = spinner_of_cities.getSelectedItemPosition();
        outState.putInt("spinnerIndex", spinnerPosition);
        Log.d("SpinnerState", "Spinner at position " + spinnerPosition + " was saved");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        spinnerPosition = savedInstanceState.getInt("spinnerIndex");
        Log.d("SpinnerState", "Spinner at position " + spinnerPosition + " was restored");}//не пойму как привильно восстановить значение, по логам нет ничего
}
