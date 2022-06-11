package com.example.psychometrictesting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_test;
    private TextView tv_test;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        btn_test = findViewById(R.id.btn_test);
        tv_test = findViewById(R.id.tv_test);
        btn_test.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1){
            total = data.getIntExtra("total", 0);
            if (total == 0){
                tv_test.setText("自由职业\n生命诚可贵，爱情价更高；\n若为自由故，两者皆可抛。\n");
            } else if (total == 1 || total == 2){
                tv_test.setText("大众职业\n平平淡淡不是随波逐流，\n而是为了握住这人间烟火气。");
            } else {
                tv_test.setText("高强度职业\n热爱工作胜过生活中的一切，\n享受工作带来的满足感和胜利感，但是应该在工作的同时兼顾生活。");
            }
        }
    }
}
