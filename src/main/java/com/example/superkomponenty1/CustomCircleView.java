package com.example.superkomponenty1;

import static java.lang.Character.getName;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class CustomCircleView  extends View {



    public float getCy() {
        return cy;
    }

    public float getCx() {
        return cx;
    }

    public float getRadius() {
        return radius;
    }

    public void setCy(float cy) {
        this.cy = cy;
        invalidate();
    }

    public void setCx(float cx) {
        this.cx = cx;
        invalidate();
    }

    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }

    private float cy;
    private float cx;
    private float radius;




    public CustomCircleView(Context context) {
        super(context);
        ValuesInnit(500,500,100);

    }
    public void  ValuesInnit(int cy, int cx, int radius ){
        this.cy = cy;
        this.cx = cx;
        this.radius = radius;


    }
    public CustomCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ValuesInnit(500, 500, 100);
    }



    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        float cx = getCx();
        float cy = getCy();
        float radius = getRadius();
        Paint paint = new Paint();
        Random rnd = new Random();
        paint.setARGB(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
        canvas.drawCircle(cx, cy, radius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            Random rnd = new Random();
            Paint paint = new Paint();
            setCx(rnd.nextInt(500));
            setCy(rnd.nextInt(500));

            setRadius(rnd.nextInt(200));
            paint.setARGB(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256));
            ObjectAnimator moveY = ObjectAnimator.ofFloat(this,"cy",getCy(),event.getY()).setDuration(1000);
            setCx(event.getX());
            setCy(event.getY());
            ObjectAnimator moveX = ObjectAnimator.ofFloat(this,"cx",getCx(),event.getX()).setDuration(1000);

            moveY.start();
            moveX.start();
            return true;
        }

        return super.onTouchEvent(event);
    }




}
