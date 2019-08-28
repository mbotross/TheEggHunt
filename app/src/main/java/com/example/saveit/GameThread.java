package com.example.saveit;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

    public class GameThread extends Thread {
        // public static Canvas board;
        private Game game;
        private SurfaceHolder surfaceholder;



        public GameThread( Game game) {


            this.game = game;
        }

        @Override
        public void run(){
            surfaceholder=game.getHolder();
            while( !Thread.interrupted() ) {
                //You might want to do game specific processing in a method you call here
                Canvas c = this.surfaceholder.lockCanvas(null);
                try { synchronized(surfaceholder)
                {  //this.game.update();
                    this.game.draw(c);
                   this.game.update();
                }
                } catch (Exception e) { }
                finally { if ( c != null )
                { surfaceholder.unlockCanvasAndPost(c); } }
                // Set the frame rate by setting this delay
                try
                { Thread.sleep(10); } catch (InterruptedException e)
                { // Thread was interrupted while sleeping.
                    return; } }
        }


    }

