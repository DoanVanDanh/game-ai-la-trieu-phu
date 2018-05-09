package com.example.thuybinh.game_ailatrieuphu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.thuybinh.game_ailatrieuphu.controllers.QuestionManager;
import com.example.thuybinh.game_ailatrieuphu.models.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.start();

    }


    public void huongDan(View view) {
        Intent intent = new Intent(MainActivity.this,HuongdanActivity.class);

        startActivity(intent);
    }

    public void startGame(View view) {
        mediaPlayer.stop();
        // ID của file nhạc trong thư mục 'raw'.


        finish();
        startActivity(new Intent(this,StartGameActivity.class));
    }

    public void abc(View view) {
        startActivity(new Intent(this,activity_main2.class));
    }


}
