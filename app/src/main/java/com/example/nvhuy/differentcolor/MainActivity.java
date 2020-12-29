package com.example.nvhuy.differentcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Define define = new Define();
    ArrayList<item> listItems = new ArrayList<>();
    GridView gridView;
    Adapter adapter;
    TextView level, time;
    CountDownTimer countDownTimer;
    ImageView img;
    int iconImg = R.mipmap.cat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        AnhXa();
        setup();
        setClick();
    }

    private void setClick() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                check(listItems.get(position));
            }
        });
    }
    private void createColor(){
        define.setLevel();
        define.selectColor();
        listItems.clear();
        while (listItems.size() < define.total){
            listItems.add(new item(define.Color1));
        }
        Random random = new Random();
        listItems.get(random.nextInt(listItems.size())).color = define.Color2;
        
    }
    private void update(){
        define.setLevel();
        level.setText(""+define.level);
        gridView.setNumColumns(define.numCol);
        adapter.update(listItems);      
    }

    private void check(item item){
        if(item.color.equals(define.Color2)){
            define.level++;
            createColor();
            update();
            define.miniTime = define.miniTime+1000;
            countDownTimer.cancel();
            updateTime();
        }
    }

    private void init() {
        createColor();
        adapter = new Adapter(getApplicationContext(),0, listItems);
    }

    private void setup() {
        gridView.setNumColumns(define.numCol);
        gridView.setAdapter(adapter);
        level.setText(""+define.level);
        updateTime();
         
        new CountDownTimer(2000,200) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (iconImg == R.mipmap.cat2){
                    iconImg = R.mipmap.cat1;
                }else iconImg = R.mipmap.cat2;
                img.setImageResource(iconImg);
            }

            @Override
            public void onFinish() {
                if (!define.end) {
                    start();
                }
            }
        }.start();
    }

    private void AnhXa() {
        gridView = findViewById(R.id.gridView);
        level = findViewById(R.id.level);
        time = findViewById(R.id.time);
        img = findViewById(R.id.imgCat);

    }
    private void updateTime(){
       countDownTimer= new CountDownTimer(define.miniTime,1){

            @Override
            public void onTick(long millisUntilFinished) {
                define.miniTime = (int) millisUntilFinished;
                if(define.miniTime>0) {
                    int second = define.miniTime / 1000;
                    int miniSecond = define.miniTime % 1000 / 10;
                    String time_ = second + ":" + miniSecond;
                    time.setText(time_);
                }
            }

            @Override
            public void onFinish() {
                time.setText("00:00");
                define.end= true;
                gridView.setOnItemClickListener(null);
            }
        }.start();
    }

}
