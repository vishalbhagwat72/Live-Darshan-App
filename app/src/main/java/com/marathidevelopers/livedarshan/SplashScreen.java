package com.marathidevelopers.livedarshan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim;
    Animation bottomAnim;
    ImageView image;
    TextView text;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        image = findViewById(R.id.image22);
        text = findViewById(R.id.textlive);
        text2 = findViewById(R.id.textlive2);

        image.setAnimation(topAnim);
        text.setAnimation(bottomAnim);
        text2.setAnimation(bottomAnim);

        Thread td = new Thread(){
            public  void run(){
                try {
                    sleep(3000);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(SplashScreen.this ,MainActivity.class );
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();

    }
}