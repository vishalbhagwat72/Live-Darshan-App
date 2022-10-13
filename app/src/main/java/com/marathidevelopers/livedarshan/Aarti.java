package com.marathidevelopers.livedarshan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

import HelperClasses.adapterphone;
import HelperClasses.phonehelper;

public class Aarti extends AppCompatActivity {

    CardView box1;
    CardView box2;
    CardView box3;
    CardView box4;
    CardView box5;
    CardView box6;
    CardView box7;
    CardView box8;
    CardView box9;
    CardView box10;
    CardView box11;
    CardView box12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aarti);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        box1 = findViewById(R.id.box1);
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_ganpati.class));
            }
        });

        box2 = findViewById(R.id.box2);
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_vitthal.class));
            }
        });

        box3 = findViewById(R.id.box3);
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_saibaba.class));
            }
        });

        box4 = findViewById(R.id.box4);
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_mahalakshmi.class));
            }
        });

        box5 = findViewById(R.id.box5);
        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_tuljapur.class));
            }
        });

        box6 = findViewById(R.id.box6);
        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_jyotiba.class));
            }
        });

        box7 = findViewById(R.id.box7);
        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_shanidev.class));
            }
        });

        box8 = findViewById(R.id.box8);
        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_krishna.class));
            }
        });

        box9 = findViewById(R.id.box9);
        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_ujjain.class));
            }
        });

        box10 = findViewById(R.id.box10);
        box10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_somnath.class));
            }
        });

        box11 = findViewById(R.id.box11);
        box11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_kashi.class));
            }
        });

        box12 = findViewById(R.id.box12);
        box12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Aarti.this,Aarti_saptshrungi.class));
            }
        });



    }
}