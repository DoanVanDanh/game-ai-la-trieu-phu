package com.example.thuybinh.game_ailatrieuphu.controllers;

import com.example.thuybinh.game_ailatrieuphu.models.*;

import java.util.ArrayList;

import android.os.AsyncTask;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public  class QuestionManager {

    private static   ArrayList<Question> questionArrayList;

    /*
        controller: use pattern :singeton
     */
    private static QuestionManager sInstance = null;

    private QuestionManager() {
        this.questionArrayList = new ArrayList<>();
        getJSON("http://gameailatrieuphu.byethost32.com/display2.php");

        System.out.println("manage"+questionArrayList.size());
    }

    public static QuestionManager getsInstance() {
        if (sInstance == null) {
            sInstance = new QuestionManager();
        }
        return sInstance;
    }
    /*
    end of singeton
     */

    /* create temp  question use for project
        question 1--> 5: level 1
        question 6--> 10: level 2
        question 11--> 15: level 3
     */
    public void initQuestion() {


    }

    public ArrayList<Question> getQuestionArrayList() {
        return questionArrayList;
    }

    //chưa làm
    public ArrayList<Question> getQuestionArrayList(int level) {
        return questionArrayList;
    }


    private      void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                try {
                     loadQuestionFromWeb(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadQuestionFromWeb(String json) throws JSONException {
//        ArrayList<Question> questions = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        System.out.println(jsonArray.length());
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                System.out.println(obj.toString());
                //ngu người
//                questionArrayList.get(i).setId(obj.getInt("ID"));
//                questionArrayList.get(i).setContent(obj.getString("Content"));
//                questionArrayList.get(i).setAnswerA(obj.getString("A"));//.replaceAll("(\\r|\\n)", "");
//                questionArrayList.get(i).setAnswerB(obj.getString("B"));
//                questionArrayList.get(i).setAnswerC(obj.getString("C"));
//                questionArrayList.get(i).setAnswerD(obj.getString("D"));
//                questionArrayList.get(i).setAnswer(obj.getString("Answer"));
//                questionArrayList.get(i).setLevel(obj.getInt("Level"));

                Question question = new Question(obj.getInt("ID"),obj.getString("Content"),obj.getString("A"),obj.getString("B"),obj.getString("C"),obj.getString("D"),obj.getString("Answer"),obj.getInt("Level"));
                questionArrayList.add(question);



            }

        }
        catch (Exception e){
            System.out.println("A"+e.getMessage());
        }

    }

}