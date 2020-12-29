package com.example.nvhuy.differentcolor;

import java.util.Random;

public class Define {
    public int numCol = 5;
    public int total ;
    public String Color1 ;
    public String Color2 ;
    public int miniTime = 10*1000;
    public boolean end = false;
    private String color1[]= new String[]{
            "#FFFF00",
            "#333366",
            "#33FF00",
            "#FFCC00",
            "#FF9966"

    };
    private String color2[] = new String[]{
            "#FFFF66",
            "#3333FF",
            "#00FF66",
            "#FFCC99",
            "#FF99CC"

    };


    public void selectColor(){
        Random random =new  Random();
        int position = random.nextInt(color1.length);
        Color1 = color1[position];
        Color2 = color2[position];
    }
    public int level =1;
    public void setLevel(){
        if (level < 10){
            numCol = 2;
        }else if(level < 20) {
            numCol = 3;
        }else if(level < 30) {
            numCol = 4;
        }else if(level < 40) {
            numCol = 5;
        }else if(level < 50) {
            numCol = 6;
        }else if(level < 60) {
            numCol = 7;
        }else if(level < 70) {
            numCol = 8;
        }else if(level < 80) {
            numCol = 9;
        }else {
            numCol = 10;
        }
        total = numCol * numCol;
    }
}
