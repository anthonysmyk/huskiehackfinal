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
                        new Player().execute("https://r4---sn-vgqsknek.googlevideo.com/videoplayback?key=cms1&gir=yes&sparams=clen,dur,ei,expire,gir,id,ip,ipbits,ipbypass,itag,keepalive,lmt,mime,mip,mm,mn,ms,mv,pl,requiressl,source&expire=1551019282&c=WEB&itag=171&fvip=4&ipbits=0&mime=audio%2Fwebm&txp=5511222&signature=08E39FF984A6FFE71EDCB731A8F9F9B4CC6F4170.4A9F795F0D5A38F06654A24EBD96653D257ED5E4&clen=32998184&requiressl=yes&ip=172.104.225.96&lmt=1547589663404521&dur=3626.171&pl=16&source=youtube&ei=sVhyXNfAOtbMgAeo67TQDA&keepalive=yes&id=o-AADVpllGskkU1ntkvZztq2rQViNwhAZqfu-HCjkkpuYp&ratebypass=yes&title=%22Instant%20Relief%20From%20Anxiety%20%26%20Stress%22%20Peaceful%20Meditation%20Music%2C%20Deep%20Relaxing%20%26%20Healing%20Music&redirect_counter=1&rm=sn-ab5e7r7z&req_id=62b4c38e50f1a3ee&cms_redirect=yes&ipbypass=yes&mip=131.156.156.242&mm=31&mn=sn-vgqsknek&ms=au&mt=1550997595&mv=m");
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
                new Player().execute("https://r6---sn-vgqsrn7d.googlevideo.com/videoplayback?lmt=1541011906262225&clen=15915583&dur=1317.571&gir=yes&txp=5411222&itag=171&expire=1551019748&sparams=clen,dur,ei,expire,gir,id,ip,ipbits,itag,keepalive,lmt,mime,mip,mm,mn,ms,mv,pl,requiressl,source&source=youtube&mime=audio%2Fwebm&keepalive=yes&signature=57ED40F37EDD386F3A06E30384E54B38692D4FEC.6F2EC0F8D855864F48E96115DBE4770B7B7336DC&requiressl=yes&pl=16&c=WEB&fvip=1&id=o-AHnNlRPT87Px5qXgm0MrKMiykItYEMhR403QcKBLLvk-&ei=hFpyXNDlCYa-V8D2r7AD&ip=212.71.247.4&key=cms1&ipbits=0&ratebypass=yes&title=CHIT%20SHAKTI%20MEDITATION%20FOR%20SUCCESS&redirect_counter=1&cm2rm=sn-5hnell76&req_id=2d44e54c2ad5a3ee&cms_redirect=yes&mip=131.156.156.242&mm=34&mn=sn-vgqsrn7d&ms=ltu&mt=1550998115&mv=m");
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




