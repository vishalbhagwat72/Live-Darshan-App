package com.marathidevelopers.livedarshan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

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
    private long backPressedTime;
    private Toast backToast;
    CardView box4;
    CardView box1;
    CardView box2;
    CardView box3;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Recycler1 = findViewById(R.id.my_recycler);
        Recycler1();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        setAds();

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId(getString(R.string.banner));
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        box1 = findViewById(R.id.box1);
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            startActivity(new Intent(MainActivity.this,Aarti.class));
                            mInterstitialAd=null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(MainActivity.this,Aarti.class));
                }
            }

        });

        box2 = findViewById(R.id.box2);
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            startActivity(new Intent(MainActivity.this,Timings.class));
                            mInterstitialAd=null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(MainActivity.this,Timings.class));
                }
            }
        });

        box3 = findViewById(R.id.box3);
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MoreApps.class));
            }
        });

        box4 = findViewById(R.id.box4);
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.marathidevelopers.livedarshan");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });






    }

    private void Recycler1() {


        Recycler1.setHasFixedSize(true);
        Recycler1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<phonehelper> phonelocations = new ArrayList<>();
        phonelocations.add(new phonehelper( R.drawable.pandharpur));
        phonelocations.add(new phonehelper( R.drawable.saibaba));
        phonelocations.add(new phonehelper( R.drawable.siddhivinayak));
        phonelocations.add(new phonehelper( R.drawable.mahalakshmi));
        phonelocations.add(new phonehelper( R.drawable.tuljapur));
        phonelocations.add(new phonehelper( R.drawable.jyotiba));
        phonelocations.add(new phonehelper( R.drawable.shanidev));
        phonelocations.add(new phonehelper( R.drawable.dagdusheth));
        phonelocations.add(new phonehelper( R.drawable.ujjain));
        phonelocations.add(new phonehelper( R.drawable.somnath));
        phonelocations.add(new phonehelper( R.drawable.kashi));
        phonelocations.add(new phonehelper( R.drawable.iscon));
        phonelocations.add(new phonehelper( R.drawable.saptashrungi));

        adapter = new adapterphone(phonelocations, this);
        Recycler1.setAdapter(adapter);

    }




    @Override
    public void onphoneListClick(int clickedItemIndex) {


        Intent mIntent;
        switch (clickedItemIndex) {

                case 0:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Vitthal.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Vitthal.class));
                    }
                    break;



                case 1:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,SaiBaba.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,SaiBaba.class));
                    }
                    break;



                case 2:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Siddhivinayak.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Siddhivinayak.class));
                    }
                    break;


                case 3:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Mahalakshmi.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Mahalakshmi.class));
                    }
                    break;


               case 4:
                   if (mInterstitialAd != null) {
                       mInterstitialAd.show(MainActivity.this);
                       mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                           @Override
                           public void onAdDismissedFullScreenContent() {
                               super.onAdDismissedFullScreenContent();
                               startActivity(new Intent(MainActivity.this,Tuljapur.class));
                               mInterstitialAd=null;
                               setAds();
                           }
                       });
                   } else {
                       startActivity(new Intent(MainActivity.this,Tuljapur.class));
                   }
                   break;



                case 5:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Jyotiba.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Jyotiba.class));
                    }
                    break;



                case 6:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Shanidev.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Shanidev.class));
                    }
                    break;


                case 7:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Dagdusheth.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Dagdusheth.class));
                    }
                    break;


                case 8:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Ujjain.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Ujjain.class));
                    }
                    break;


                case 9:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Somnath.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Somnath.class));
                    }
                    break;


                case 10:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Kashi.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Kashi.class));
                    }
                    break;


                case 11:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Iscon.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Iscon.class));
                    }
                    break;


                case 12:
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(MainActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startActivity(new Intent(MainActivity.this,Saptshrungi.class));
                                mInterstitialAd=null;
                                setAds();
                            }
                        });
                    } else {
                        startActivity(new Intent(MainActivity.this,Saptshrungi.class));
                    }
                    break;
        }
    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast=Toast.makeText(getBaseContext(),"Press Back Again To Exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime= System.currentTimeMillis();
    }

        public void setAds(){

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,getString(R.string.inter), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;

            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                mInterstitialAd = null;
            }
        });
    }
}
