package com.example.pr11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e) {}
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public boolean Started = false;
    public boolean Finished = false;
    public void Start(View view) {
        Button button = (Button)findViewById(R.id.bStart);
        if(!Finished) {
            if(!Started) {
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }
            else if(Started) {
                button.setBackgroundColor(Color.GREEN);
                button.setText("Старт");
                Started = false;
            }
        }
        else {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }
    }
    public void Drive1(View view) {
        Button button = (Button)findViewById(R.id.bStart);
        View Car = (View)findViewById(R.id.Car1);
        TextView result = (TextView)findViewById(R.id.tvResult);
        if(Started && !Finished) {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin += 40;
            margin.rightMargin -= 40;
            Car.requestLayout();
            if(margin.rightMargin <= -1000){
                result.setText("Победа 1 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
    public void Drive2(View view) {
        Button button = (Button)findViewById(R.id.bStart);
        View Car = (View)findViewById(R.id.Car2);
        TextView result = (TextView)findViewById(R.id.tvResult);
        if(Started && !Finished) {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car.getLayoutParams();
            margin.leftMargin += 40;
            margin.rightMargin -= 40;
            Car.requestLayout();
            if(margin.rightMargin <= -1000){
                result.setText("Победа 2 игрока");
                button.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
}