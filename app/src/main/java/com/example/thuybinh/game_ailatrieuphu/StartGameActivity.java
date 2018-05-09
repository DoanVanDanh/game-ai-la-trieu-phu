package com.example.thuybinh.game_ailatrieuphu;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thuybinh.game_ailatrieuphu.controllers.QuestionManager;
import com.example.thuybinh.game_ailatrieuphu.models.Question;

import java.util.ArrayList;
import java.util.Random;

public class StartGameActivity extends AppCompatActivity {
    ArrayList<Question> questions;
    TextView tvQuestion;
    TextView tvCoin;
    Button btnAnswerA;
    Button btnAnswerB;
    Button btnAnswerC;
    Button btnAnswerD;

    int coin ;
    int time;
    int numberQuestion;

    Thread thread;
    ArrayList<String> answerList;
    //kiếm tra sự trợ giúp đó dùng hay chưa
    ArrayList<String> helped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.batdauchoi);
        mediaPlayer2.start();

        this.questions = QuestionManager.getsInstance().getQuestionArrayList();
        System.out.println("start activity nè"+questions.size());

        AlertDialog alertDialog = new AlertDialog.Builder(StartGameActivity.this).create();
        alertDialog.setTitle("Chào bạn");
        alertDialog.setMessage("bạn đã bắt đầu chơi chưa nào");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        init();
                        setWidgets();
                    }
                });
        alertDialog.show();


        getWidgets();
        setListenner();



    }

    public  void getWidgets(){
        btnAnswerA = findViewById(R.id.answer_A);
        btnAnswerB = findViewById(R.id.answer_B);
        btnAnswerC = findViewById(R.id.answer_C);
        btnAnswerD = findViewById(R.id.answer_D);

        tvQuestion = findViewById(R.id.txt_questions);
        tvCoin = findViewById(R.id.tvCoin);
    }

    public void setWidgets(){
        Question question = questions.get(numberQuestion);
        btnAnswerA.setText(question.getAnswerA());
        btnAnswerB.setText(question.getAnswerB());
        btnAnswerC.setText(question.getAnswerC());
        btnAnswerD.setText(question.getAnswerD());
        tvQuestion.setText("Câu "+(numberQuestion+1)+" \n" + question.getContent());
        tvCoin.setText(String.valueOf(coin));


        btnAnswerA.setTextColor(Color.BLACK);
        btnAnswerC.setTextColor(Color.BLACK);
        btnAnswerB.setTextColor(Color.BLACK);
        btnAnswerD.setTextColor(Color.BLACK);


    }

    public void init(){
        numberQuestion =0;
        coin =0;
        time =0;

        answerList = new ArrayList<>();
        helped = new ArrayList<>();
        helped.add("");
        helped.add("");
        helped.add("");
        helped.add("");


    }

    public void setListenner(){

    }


    public void clickAnswerA(View view){
        Question question = questions.get(numberQuestion);

//        notifiAnswerRight(question);
        if(question.getAnswer().equalsIgnoreCase("A")){
            setIfAnswerRight(btnAnswerA);
        }
        else {

            notifiAnswerRight(question);
            setIfAnswerWrong(btnAnswerA);
        }

    }

    public void clickAnswerB(View view){
        Question question = questions.get(numberQuestion);


        if(question.getAnswer().equalsIgnoreCase("B")){
            setIfAnswerRight(btnAnswerB);
        }
        else {
            notifiAnswerRight(question);
            setIfAnswerWrong(btnAnswerB);
        }
    }



    public void clickAnswerC(View view){
        Question question = questions.get(numberQuestion);


        if(question.getAnswer().equalsIgnoreCase("C")){
            setIfAnswerRight(btnAnswerC);
        }
        else {
            notifiAnswerRight(question);
            setIfAnswerWrong(btnAnswerC);
        }
    }

    public void clickAnswerD(View view){
        Question question = questions.get(numberQuestion);


        if(question.getAnswer().equalsIgnoreCase("D")){
            setIfAnswerRight(btnAnswerD);
        }
        else {
            notifiAnswerRight(question);
            setIfAnswerWrong(btnAnswerD);
        }
    }

    public void setIfAnswerRight(Button btnClick){
//        btnClick.setBackgroundColor(17);
        btnClick.setTextColor(Color.GREEN);
        numberQuestion++;
        coin = coin + numberQuestion*1000;

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //chuyen qua cau hoi tiep theo
        setWidgets();

    }


    private void setIfAnswerWrong(Button btnClick) {
        btnClick.setBackgroundColor(Color.YELLOW);


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AlertDialog alertDialog = new AlertDialog.Builder(StartGameActivity.this).create();
        alertDialog.setTitle("Game over");
        alertDialog.setMessage("You have " + coin + " poin");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
//                        onBackPressed();
                        startActivity(new Intent(StartGameActivity.this,MainActivity.class));
                    }
                });
        alertDialog.show();

    }

    //thong bao cau dung : doi mau cau dung
    public void notifiAnswerRight(Question question){
        String answer = question.getAnswer();
        if(answer.equalsIgnoreCase("A")){
            btnAnswerA.setBackgroundColor(Color.GREEN);
        }
        if(answer.equalsIgnoreCase("B")){
            btnAnswerB.setBackgroundColor(Color.GREEN);
        }
        if(answer.equalsIgnoreCase("C")){
            btnAnswerC.setBackgroundColor(Color.GREEN);
        }
        if(answer.equalsIgnoreCase("D")){
            btnAnswerD.setBackgroundColor(Color.GREEN);
        }


    }

    /***
     * tro giup
     * @param view
     */
    public void click5050(View view) {
        if (helped.get(0).isEmpty()) {
            Question question = questions.get(numberQuestion);
            String answer = question.getAnswer();

            answerList.add("A");
            answerList.add("B");
            answerList.add("C");
            answerList.add("D");

            answerList.remove(question.getAnswer());

            System.out.println(answerList.toString());
            Random random = new Random();
            int randomAnswer1 = random.nextInt(3);
            int randomAnswer2 = randomAnswer1;
            while (randomAnswer1 == randomAnswer2) {
                randomAnswer2 = random.nextInt(3);
            }
            System.out.println("random" + randomAnswer1 + " " + randomAnswer2);
            if (answerList.get(randomAnswer1).equalsIgnoreCase("A")) {
                btnAnswerA.setText("answer A is wrong");
            }

            if (answerList.get(randomAnswer1).equalsIgnoreCase("B")) {
                btnAnswerB.setText("answer B is wrong");
            }
            if (answerList.get(randomAnswer1).equalsIgnoreCase("C")) {
                btnAnswerC.setText("answer C is wrong");
            }
            if (answerList.get(randomAnswer1).equalsIgnoreCase("D")) {
                btnAnswerD.setText("answer D is wrong");
            }

            ///
            if (answerList.get(randomAnswer2).equalsIgnoreCase("A")) {
                btnAnswerA.setText("answer A is wrong");
            }

            if (answerList.get(randomAnswer2).equalsIgnoreCase("B")) {
                btnAnswerB.setText("answer B is wrong");
            }
            if (answerList.get(randomAnswer2).equalsIgnoreCase("C")) {
                btnAnswerC.setText("answer C is wrong");
            }
            if (answerList.get(randomAnswer2).equalsIgnoreCase("D")) {
                btnAnswerD.setText("answer D is wrong");
            }
            answerList.clear();
            helped.set(0, "ok");
        } else {
            Toast.makeText(this, "bạn đã dùng sự trợ giúp này", Toast.LENGTH_SHORT).show();
        }
    }

    public void clickChangQuestion(View view) {
        if (helped.get(3).isEmpty()) {
            numberQuestion++;


//           Question question = questions.get(numberQuestion);
//           btnAnswerA.setText(question.getAnswerA());
//           btnAnswerB.setText(question.getAnswerB());
//           btnAnswerC.setText(question.getAnswerC());
//           btnAnswerD.setText(question.getAnswerD());
//           tvQuestion.setText("Câu "+(numberQuestion)+" \n" + question.getContent());
//           tvCoin.setText(String.valueOf(coin));
            setWidgets();

            answerList.clear();
            helped.set(3, "ok");

        }
        else {
          Toast.makeText(this, "bạn đã dùng sự trợ giúp này", Toast.LENGTH_SHORT).show();
        }

    }
}
