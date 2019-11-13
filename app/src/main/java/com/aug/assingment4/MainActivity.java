package com.aug.assingment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout boss;
    ValueAnimator animator1,animator2,animator3,animator8,animator7;
    View view1,view2,view3,view4;
    TextView textView;
    RelativeLayout view5;
    Activity activity;
    int value,f=-1,f1=0;
    // f >>> is a flag to check orientation
    // f1 >>> is a flag to check clicks on screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declerations();
        checkOrientation();
        textView=findViewById(R.id.textView);
        boss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(f==0){
                if(f1==0){
                    moveHP();
                    moveVP();
                    moveC();
                    f1=1;
                }else if(f1==1){
                    animator1.pause();
                    animator2.pause();
                    animator3.pause();
                    f1=2;
                }else if(f1==2){
                    animator1.resume();
                    animator2.resume();
                    animator3.resume();
                }

            }else if(f==1){
                if(f1==0){
                    moveHL();
                    moveVL();
                    moveC();
                    f1=1;
                }else if(f1==1){
                    animator7.pause();
                    animator8.pause();
                    animator3.pause();
                    f1=2;
                }else if(f1==2){
                    animator7.resume();
                    animator8.resume();
                    animator3.resume();
                }



            }
            }
        });
    }
    public void moveHP(){
        animator1=(ValueAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animator);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int)animation.getAnimatedValue();
                ConstraintLayout.LayoutParams params= (ConstraintLayout.LayoutParams) view1.getLayoutParams();
                textView.setText(value+"");

                params.height=30;
                params.width=value;
                ConstraintLayout.LayoutParams params2= (ConstraintLayout.LayoutParams) view2.getLayoutParams();
                params2.height=30;
                params2.width=value;

            }
        });
        animator1.setTarget(view1);
        animator1.setTarget(view2);
        animator1.start();

    }
    public void moveVP(){
        animator2=(ValueAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animator2);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value1 = (int)animation.getAnimatedValue();
                ConstraintLayout.LayoutParams params3= (ConstraintLayout.LayoutParams) view3.getLayoutParams();
                textView.setText(value+"");
                params3.height=value1;
                params3.width=30;
                ConstraintLayout.LayoutParams params4= (ConstraintLayout.LayoutParams) view4.getLayoutParams();
                params4.height=value1;
                params4.width=30;

            }

        });
        animator2.setTarget(view3);
        animator2.setTarget(view4);

        animator2.start();



    }
    public void moveC(){
        animator3=(ValueAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animator3);
        animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int value3 = (int)animation.getAnimatedValue();
                ConstraintLayout.LayoutParams params= (ConstraintLayout.LayoutParams) view5.getLayoutParams();
                textView.setText(value+"");
                params.height=value3;
                params.width=value3;

            }
        });
        animator3.setTarget(view5);
        animator3.start();
    }
    public void moveHL(){
      animator8=(ValueAnimator)AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animator2);
        animator8.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value8=(int)animation.getAnimatedValue() ;
                ConstraintLayout.LayoutParams params8=(ConstraintLayout.LayoutParams) view1.getLayoutParams();
                textView.setText(value8+"");
                params8.height=30;
                params8.width=value8;
                ConstraintLayout.LayoutParams params2= (ConstraintLayout.LayoutParams) view2.getLayoutParams();
                params2.height=30;
                params2.width=value8;
            }
        });
        animator8.setTarget(view1);
        animator8.setTarget(view2);
        animator8.start();

    }
    public void moveVL(){
        animator7=(ValueAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animator);
        animator7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value1 = (int)animation.getAnimatedValue();
                ConstraintLayout.LayoutParams params3= (ConstraintLayout.LayoutParams) view3.getLayoutParams();
                textView.setText(value1+"");
                params3.height=value1;
                params3.width=30;
                ConstraintLayout.LayoutParams params4= (ConstraintLayout.LayoutParams) view4.getLayoutParams();
                params4.height=value1;
                params4.width=30;

            }

        });
        animator7.setTarget(view3);
        animator7.setTarget(view4);

        animator7.start();
    }
    public void declerations(){
        view1=findViewById(R.id.v2);
        view2=findViewById(R.id.v8);
        view3=findViewById(R.id.v5);
        view4=findViewById(R.id.v11);
        view5=findViewById(R.id.v13);
        boss=findViewById(R.id.boss);
        activity=MainActivity.this;

    }
    public void checkOrientation(){
        value = activity.getResources().getConfiguration().orientation;
        if(value== Configuration.ORIENTATION_PORTRAIT){
            f=0;
        }else if(value == Configuration.ORIENTATION_LANDSCAPE){
            f=1;
        }

    }
}
