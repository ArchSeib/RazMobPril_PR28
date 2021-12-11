package com.example.razmobpril_pr28;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    Button btnleft;
    Button btnRight;
    float x1,x2,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnleft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnright);
        btnleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent leftintent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(leftintent);
                Toast.makeText(MainActivity.this, "Переход в лево", Toast.LENGTH_SHORT).show();
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rightintent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(rightintent);
                Toast.makeText(MainActivity.this, "Переход в право", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                if(x1<x2)
                {
                    Intent left = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(left);
                }
                if(x2<x1)
                {
                    Intent right = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(right);
                }
                break;
        }
        return false;
    }
}