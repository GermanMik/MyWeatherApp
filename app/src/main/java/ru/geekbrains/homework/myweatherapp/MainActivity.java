package ru.geekbrains.homework.myweatherapp;


import android.media.effect.Effect;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button choose_weather;
    private TextView effect;
    private Spinner spinner;
    private Spinner spinner_of_cities;
    private ColourEffect colourEffect = new ColourEffect();
    private Cities cities = new Cities();
    private TextView weather_strings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        effect = (TextView) findViewById(R.id.effect);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner_of_cities = (Spinner) findViewById(R.id.spinner_of_cities);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String colour = String.valueOf(spinner.getSelectedItem());
                String result = colourEffect.getEffect(colour);
                effect.setText(result);
            }
        });
        choose_weather = (Button) findViewById(R.id.choose_weather);
        choose_weather.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String list_of_cities = String.valueOf(spinner_of_cities.getSelectedItem());
                String result = cities.getWeather(list_of_cities);
                effect.setText(result);
            }
        });


    }

}
