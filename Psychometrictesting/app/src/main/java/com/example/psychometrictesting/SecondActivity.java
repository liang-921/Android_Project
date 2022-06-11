package com.example.psychometrictesting;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_exit;
    private int total = 0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
    }
    private void init(){
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_exit = findViewById(R.id.btn_exit);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_one:
                info(btn_one);
                add();
                break;
            case R.id.btn_two:
                info(btn_two);
                break;
            case R.id.btn_three:
                info(btn_three);
                add();
                break;
            case R.id.btn_four:
                info(btn_four);
                break;
            case R.id.btn_five:
                info(btn_five);
                add();
                break;
            case R.id.btn_six:
                info(btn_six);
                break;
            case R.id.btn_exit:
                returnDate();
                break;
        }
    }

    private void info(Button btn){
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(0xff669900);
        gd.setCornerRadius(100);
        gd.setStroke(1, 0xffaaaaaa);
        btn.setBackground(gd);
    }

    private void add(){
        total++;
    }

    private void returnDate(){
        Intent intent = new Intent();
        intent.putExtra("total", total);
        setResult(1, intent);
        SecondActivity.this.finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
            returnDate();
        }
        return false;
    }
}