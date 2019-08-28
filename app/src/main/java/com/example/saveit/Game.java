package com.example.saveit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements SurfaceHolder.Callback {
    GameThread thread;
    Bitmap wallpaper,basket,resizedbasket,scoreboard;
    float xcoord,ycoord;
    int variablex=500,score=0,penalty=0;
    eggs egg;
    Obstacles obstacles;
    Rect basketrect;
    Paint paint;
    public Game(Context context) {

        super(context);
        getHolder().addCallback(this);
        thread=new GameThread(this);
        wallpaper= BitmapFactory.decodeResource(getResources(),R.drawable.background);
        scoreboard=BitmapFactory.decodeResource(getResources(),R.drawable.frame);

        basket=BitmapFactory.decodeResource(getResources(),R.drawable.basket);
        resizedbasket=Bitmap.createScaledBitmap(basket,200,200,false);
        basketrect=new Rect(200,200,200+resizedbasket.getWidth(),200+resizedbasket.getHeight());
        egg=new eggs(context,this);
        obstacles=new Obstacles(context,this);
        egg.initialize1();
        obstacles.initobst();
        paint=new Paint();

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new GameThread( this);

        thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        thread.interrupt();

    }

    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
        canvas.drawBitmap(wallpaper,-20,-50,null);
        canvas.drawBitmap(resizedbasket,variablex,1500,null);
        canvas.drawBitmap(scoreboard,600,100,null);
        basketrect.set(new Rect(variablex,1500,variablex+resizedbasket.getWidth(),1500+resizedbasket.getHeight()));
        //canvas.drawRect(basketrect,paint);
        egg.draw(canvas);

        obstacles.draw(canvas);



    }


    public void update(){
        egg.update();
        obstacles.update();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        xcoord=event.getX();
        ycoord=event.getY();

        switch(event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                variablex=(int) xcoord;
        }



        return true;
    }
    }

