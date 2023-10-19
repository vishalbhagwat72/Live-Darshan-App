package com.marathidevelopers.livedarshan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

import HelperClasses.adapterphone;
import HelperClasses.phonehelper;

public class MainActivity extends AppCompatActivity implements adapterphone.ListItemClickListener {
    RecyclerView Recycler1;
    RecyclerView.Adapter adapter;



    private AdView mAdView;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home, share, rate, other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        drawerLayout = findViewById(R.id.nav_view);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        share = findViewById(R.id.share);
        other = findViewById(R.id.other);
        rate = findViewById(R.id.rate);
        Recycler1 = findViewById(R.id.my_recycler);
        Recycler1();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.banner));
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);





        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MoreApps.class));
            }
        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.marathidevelopers.livedarshan");
                shareintent.setType("text/plain");
                startActivity(Intent.createChooser(shareintent, "Share Via"));
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + getPackageName())));
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                }
            }
        });
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer((GravityCompat.START));
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("EXIT");
            builder.setMessage("Are You Sure Want to Exit?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                        }
                    }).show();
        }
    }

    private void Recycler1() {


        Recycler1.setHasFixedSize(true);
        Recycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        phonelocations.add(new phonehelper(R.drawable.vithu));
        phonelocations.add(new phonehelper(R.drawable.saibaba));
        phonelocations.add(new phonehelper(R.drawable.siddhi));
        phonelocations.add(new phonehelper(R.drawable.mahalakshmi));
        phonelocations.add(new phonehelper(R.drawable.tuljapur));
        phonelocations.add(new phonehelper(R.drawable.jyotiba));
        phonelocations.add(new phonehelper(R.drawable.shani));
        phonelocations.add(new phonehelper(R.drawable.dagdu));
        phonelocations.add(new phonehelper(R.drawable.mahakal));
        phonelocations.add(new phonehelper(R.drawable.somnath));
        phonelocations.add(new phonehelper(R.drawable.kashi));
        phonelocations.add(new phonehelper(R.drawable.iscon));
        phonelocations.add(new phonehelper(R.drawable.jejuri));
        phonelocations.add(new phonehelper(R.drawable.pratishridi));
        phonelocations.add(new phonehelper(R.drawable.pashupati));
        phonelocations.add(new phonehelper(R.drawable.dwarka));
        phonelocations.add(new phonehelper(R.drawable.govind_devji));
        phonelocations.add(new phonehelper(R.drawable.ichapuran_balaji));
        phonelocations.add(new phonehelper(R.drawable.salasar_balaji));
        phonelocations.add(new phonehelper(R.drawable.kashtbhanjan));

        adapter = new adapterphone(phonelocations, this);
        Recycler1.setAdapter(adapter);

    }


    @Override
    public void onphoneListClick(int clickedItemIndex) {


        Intent mIntent;
        switch (clickedItemIndex) {

            case 0:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Vitthal.class));

                break;


            case 1:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, SaiBaba.class));

                break;


            case 2:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Siddhivinayak.class));

                break;


            case 3:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Mahalakshmi.class));

                break;


            case 4:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Tuljapur.class));
                break;


            case 5:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Jyotiba.class));

                break;


            case 6:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Shanidev.class));

                break;


            case 7:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Dagdusheth.class));

                break;


            case 8:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Ujjain.class));

                break;


            case 9:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Somnath.class));

                break;


            case 10:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Kashi.class));

                break;


            case 11:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Iscon.class));

                break;


            case 12:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Jejuri.class));
                break;

            case 13:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Pratishirdi.class));
                break;

            case 14:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Pashupati.class));
                break;

            case 15:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Dwarka.class));
                break;

            case 16:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Govind_Devji.class));
                break;

            case 17:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Ichapuran_Balaji.class));
                break;

            case 18:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Salasar_Balaji.class));
                break;

            case 19:
                loadInterstitialAd();
                startActivity(new Intent(MainActivity.this, Kashtabhanjan.class));
                break;
        }
    }


    public void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, getString(R.string.inter), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                        interstitialAd.show(MainActivity.this);
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    }
                });
    }
}
