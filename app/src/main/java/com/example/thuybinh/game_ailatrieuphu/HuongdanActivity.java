package com.example.thuybinh.game_ailatrieuphu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by THUYBINH-PC on 3/23/2018.
 */

public class HuongdanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huongdan);
    }

    public void goBack(View view) {
        Intent intent = new Intent(HuongdanActivity.this,MainActivity.class);

        startActivity(intent);
    }
}