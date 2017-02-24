package com.jeeva.videosplashscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.jeeva.videosplashscreen.R;


/**
 * An example full-screen activity that shows app info(guide) using video.
 */
public class VideoSplashScreenActivity extends AppCompatActivity {

    private VideoView videoView;
    private TextView tvSignUp;
    private Button btnSignIn;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        videoView = (VideoView) findViewById(R.id.videoView);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        String path = "android.resource://" + getPackageName() + "/" + R.raw.aaa;
        Uri uri = Uri.parse(path);

        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        videoView.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideoSplashScreenActivity.this,LoginActivity.class));
                finish();
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideoSplashScreenActivity.this,LoginActivity.class));
                finish();
            }
        });
    }
}
