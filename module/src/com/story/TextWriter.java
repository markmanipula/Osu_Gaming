package com.story;

import java.util.ArrayList;
import java.util.Random;

public class TextWriter implements Runnable {
    private String text;
    private int animationTime;
    private TextOutput textOutput;
    private Random random = new Random();
    private ArrayList<Integer> theDots = new ArrayList<>();
    public TextWriter(String text, int animationTime, TextOutput textField) {
        this.text = text;
        this.animationTime = animationTime;
        this.textOutput = textField;
    }

    // set the dots
    public void setTheDots() {
        for (int i = 0; i < text.length(); i++) {

        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.') {
                    String textAtThisPoint = text.substring(0,i);
                    textOutput.writeText(textAtThisPoint);
                    Thread.sleep(animationTime + random.nextInt(150));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
