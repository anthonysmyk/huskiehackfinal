package com.hack1.project;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.atomic.AtomicReference;



public class Guidedmeditation extends AppCompatActivity {
    private Button btn;
    private Button sucess;
    private boolean playPause;
    private MediaPlayer mediaPlayer;
    private ProgressDialog progressDialog;
    private boolean initialStage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidedmeditation);
        btn = (Button) findViewById(R.id.audioStreamBtn);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        progressDialog = new ProgressDialog(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!playPause) {
                    btn.setText("Pause Streaming");

                    if (initialStage) {
                        new Player().execute("https://r5---sn-vgqsknls.googlevideo.com/videoplayback?keepalive=yes&signature=153BB7881DFA32EF6EFB9E16E816B6B1A85D499F.0E2B213C46CEF986E48B58FC27C75B8FE1787337&ipbits=0&key=cms1&c=WEB&sparams=clen,dur,ei,expire,gir,id,ip,ipbits,ipbypass,itag,keepalive,lmt,mime,mip,mm,mn,ms,mv,pl,requiressl,source&lmt=1537640930856450&clen=15623405&requiressl=yes&ip=172.104.237.17&gir=yes&source=youtube&pl=16&ei=grByXMe-G4zZgQeg0YTYCw&id=o-AKS4Fv0lGHh3g6buO6FXOdq9bcNSpr3N3BsqL0oXx4SB&fvip=5&mime=audio%2Fwebm&itag=251&dur=1024.721&expire=1551041762&ratebypass=yes&title=Guided%20Meditation%20for%20Inner%20Peace%20and%20Calm&redirect_counter=1&rm=sn-ab5y676&req_id=d23cee3c48aaa3ee&cms_redirect=yes&ipbypass=yes&mip=131.156.156.242&mm=31&mn=sn-vgqsknls&ms=au&mt=1551020079&mv=m");
                    } else {
                        if (!mediaPlayer.isPlaying())
                            mediaPlayer.start();
                    }

                    playPause = true;

                } else {
                    btn.setText("Launch Streaming");

                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }

                    playPause = false;
                }
            }
        });
sucess = findViewById(R.id.sucess);
sucess.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (!playPause) {
            sucess.setText("Pause Streaming");

            if (initialStage) {
                new Player().execute("https://r6---sn-vgqsrn7d.googlevideo.com/videoplayback?mime=audio%2Fwebm&key=cms1&expire=1551041974&fvip=5&itag=171&lmt=1541011906262225&ipbits=0&source=youtube&pl=16&dur=1317.571&gir=yes&requiressl=yes&clen=15915583&txp=5411222&id=o-AKSzjdh1MW_bG4aRHP-l-HyfD8AlC0y2VZf683og3Vd0&keepalive=yes&ei=VrFyXLuSK4mdhAf58ZjYDw&sparams=clen,dur,ei,expire,gir,id,ip,ipbits,itag,keepalive,lmt,mime,mip,mm,mn,ms,mv,pl,requiressl,source&ip=139.162.242.153&signature=808D3722EEFCA12D3FC8D5959926112BAA53F7A1.5BB01BEE8B4D0DE50AE49CAC057C9E94300FD749&c=WEB&ratebypass=yes&title=CHIT%20SHAKTI%20MEDITATION%20FOR%20SUCCESS&redirect_counter=1&cm2rm=sn-5hnks7e&req_id=5b2ae4e54ee1a3ee&cms_redirect=yes&mip=131.156.156.242&mm=34&mn=sn-vgqsrn7d&ms=ltu&mt=1551020319&mv=m");
            } else {
                if (!mediaPlayer.isPlaying())
                    mediaPlayer.start();
            }

            playPause = true;

        } else {
            sucess.setText("Launch Streaming");

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }

            playPause = false;
        }
    }
    });
};


    @Override
    protected void onPause() {
        super.onPause();

        if (mediaPlayer != null) {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    class Player extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            Boolean prepared = false;

            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        initialStage = true;
                        playPause = false;
                        btn.setText("Launch Streaming");
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });

                mediaPlayer.prepare();
                prepared = true;

            } catch (Exception e) {
                Log.e("MyAudioStreamingApp", e.getMessage());
                prepared = false;
            }

            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }

            mediaPlayer.start();
            initialStage = false;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("Buffering...");
            progressDialog.show();
        }
    }

}




