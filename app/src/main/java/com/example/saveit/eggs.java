package com.example.saveit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.Toast;

import java.util.ArrayList;

public class eggs {
    Game game;
    Bitmap egg,chick;
    Canvas canvas;
    int change=0,vertical=1,change2=0,horizontal=300,level=1;
    Context context;
    ArrayList<Point>level1=new ArrayList<Point>();

    ArrayList <Rect> rect1=new ArrayList<>();
    ArrayList<Integer>bool=new ArrayList<>();
    Paint paint=new Paint();

    public eggs(Context context,Game game){
        this.game=game;
        this.context=context;
        egg= BitmapFactory.decodeResource(context.getResources(),R.drawable.egg);
        chick=BitmapFactory.decodeResource(context.getResources(),R.drawable.chick);
    }


    public void initialize1(){
        for(int i=0;i<5;i++){
        level1.add(new Point(horizontal+change2,vertical+change));
        rect1.add(new Rect(horizontal+change2,vertical+change,horizontal+change2+egg.getWidth(),vertical+change+egg.getHeight()));
        bool.add(0);
        change2=change2+100;
        change=change-70;
        }
        for(int i=5;i<10;i++){
            level1.add(new Point(horizontal+change2,vertical+change));
            rect1.add(new Rect(horizontal+change2,vertical+change,horizontal+change2+egg.getWidth(),vertical+change+egg.getHeight()));
            bool.add(0);
            change2=change2-100;
            change=change-70;
        }

        for(int i=10;i<15;i++){
            level1.add(new Point(800,vertical+change));
           rect1.add(new Rect(800,vertical+change,800+egg.getWidth(),vertical+change+egg.getHeight()));
            bool.add(0);
            change=change-150;


        }
        for(int i=15;i<20;i++){
            level1.add(new Point(50,vertical+change));
            rect1.add(new Rect(50,vertical+change,50+egg.getWidth(),vertical+change+egg.getHeight()));
            bool.add(0);
            change=change-150;
        }



        for(int i=20;i<26;i++){

            level1.add(new Point(horizontal+change2,vertical+change));
            rect1.add(new Rect(horizontal+change2,vertical+change,horizontal+change2+egg.getWidth(),vertical+change+egg.getHeight()));
            bool.add(0);
            change2=change2+100;
            change=change-100;


        }
        for(int i=26;i<35;i++){

            level1.add(new Point(horizontal+change2,vertical+change));
            rect1.add(new Rect(horizontal+change2,vertical+change,horizontal+change2+egg.getWidth(),vertical+change+egg.getHeight()));
            bool.add(0);
            change2=change2-100;
            change=change-100;



        }

        change=change-2000;
        for(int i=35;i<45;i++){
            level1.add(new Point(500,vertical+change));
            rect1.add(new Rect(500,vertical+change,500+egg.getWidth(),vertical+change+egg.getHeight()));
            bool.add(0);
            change=change-150;

        }

        for(int i =45;i<55;i++){
            level1.add(new Point(100,vertical+change));
            rect1.add(new Rect(100,vertical+change,100+egg.getWidth(),vertical+change+egg.getHeight()));
            bool.add(0);
            change=change-150;
        }


        
    }


    public void draw(Canvas canvas) {

        for (int i = 0; i < 55; i++) {
            if(Rect.intersects(game.basketrect,rect1.get(i))){
                bool.set(i,1);
                game.score++;}
            if (!Rect.intersects(game.basketrect, rect1.get(i)) && bool.get(i)==0) {//level1.get(i).y+vertical<1400){
                // level1.set(i,new Point(level1.get(i).x,level1.get(i).y+vertical));
                rect1.set(i, new Rect(level1.get(i).x, level1.get(i).y + vertical, level1.get(i).x + egg.getWidth(), level1.get(i).y + egg.getHeight() + vertical));
                canvas.drawBitmap(egg, level1.get(i).x, level1.get(i).y + vertical, null);
                //canvas.drawRect(rect1.get(i),paint);}
                if(level1.get(i).y+vertical>canvas.getHeight() && bool.get(i)!=1){
                    game.penalty++;
                    bool.set(i,1);
                    System.out.println("penalty"+ game.penalty);
                }
            }

            System.out.println(level1.get(35).y);

            if(level1.get(35).y+vertical>=0){
                System.out.println("here");
                level=2;
            }
        }
        //canvas.drawBitmap(chick,200,1000+vertical,null);

    }
    public void update(){

        //if(vertical<canvas.getHeight()){
        if(level==1){
        vertical=vertical+30;}
        else if(level==2){
            vertical=vertical+40;
        }

        //}



    }

    public void showmessage(){

        Toast.makeText(context,"You mus enter a username and password", Toast.LENGTH_SHORT).show();
    }


}
