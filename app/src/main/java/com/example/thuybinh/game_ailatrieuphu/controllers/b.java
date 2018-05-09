package com.example.thuybinh.game_ailatrieuphu.controllers;

import java.util.Timer; import java.util.TimerTask;
public class b {


     int counter;
    Timer timer = new Timer(); //new timer
    public void a(){

        counter = 10; //setting the counter to 10 sec
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(Integer.toString(counter)); //the timer lable to counter.
                counter--;
                if (counter == -1) {
                    timer.cancel();

                }
            }

            ;
        //imer.scheduleAtFixedRate(task, 1000, 1000); // =  timer.scheduleAtFixedRate(task, delay, period);

        };
    }

    public static void main(String args[]) {

      b b = new b();
      b.a();
    }
}