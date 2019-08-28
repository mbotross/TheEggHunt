package com.example.saveit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

public class Obstacles extends eggs {
    Bitmap chick, icecream;
    int draw;
    ArrayList<Point>obstacles=new ArrayList<Point>();
    ArrayList<Rect>obstrect=new ArrayList<Rect>();
    ArrayList<Bitmap>type=new ArrayList<>();
    ArrayList<Integer>obstbool=new ArrayList<>();

    public Obstacles(Context context, Game game){
        super(context,game);
        chick= BitmapFactory.decodeResource(context.getResources(),R.drawable.chick);
        icecream=BitmapFactory.decodeResource(context.getResources(),R.drawable.icecream);
    }


    public void initobst(){
        obstacles.add(new Point(200,-300));
        obstacles.add(new Point(500,-1000));
        obstacles.add(new Point(200,-1500));
        obstacles.add(new Point(400,-3000));
        //obstacles.add(new Point(300,-5500));

        obstrect.add(new Rect(200,-300,200+chick.getWidth(),-300+chick.getHeight()));
        obstrect.add(new Rect(500,-1000,500+chick.getWidth(),-1000+chick.getHeight()));
        obstrect.add(new Rect(200,-1500,200+chick.getWidth(),-1500+chick.getHeight()));
        obstrect.add(new Rect(500,-3000,500+chick.getWidth(),-3000+chick.getHeight()));
        change=-5730;
        for(int i=0;i<4;i++){
            type.add(chick);
        }
        for(int i=4;i<13;i++){
        obstacles.add(new Point(300,change));
        obstrect.add(new Rect(300,change,300+icecream.getWidth(),change+icecream.getHeight()));
        change=change-150;
        type.add(icecream);
        }

        for(int i=0;i<obstacles.size();i++){
            obstbool.add(0);
        }




    }

    public void draw(Canvas canvas){
        intersect();
        for(int i=0;i<obstacles.size();i++){
        if(obstbool.get(i)==0){
        canvas.drawBitmap(type.get(i),obstacles.get(i).x,obstacles.get(i).y+vertical,null);
        //canvas.drawRect(obstrect.get(i),paint);
         }

        if(obstacles.get(4).y+vertical>=0){
            level=2;

        }


        }



    }

    public void intersect(){


        for(int i=0;i<obstacles.size();i++) {
            if (Rect.intersects(obstrect.get(i), game.basketrect)) {
                obstbool.set(i,1);

            }
            if(!Rect.intersects(obstrect.get(i),game.basketrect) && obstbool.get(i)==0){
                obstrect.set(i,new Rect(obstacles.get(i).x,obstacles.get(i).y+vertical,obstacles.get(i).x+type.get(i).getWidth(),obstacles.get(i).y+type.get(i).getHeight()+vertical));


            }
        }
    }





}
