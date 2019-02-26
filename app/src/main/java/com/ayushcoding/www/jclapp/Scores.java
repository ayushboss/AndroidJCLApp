package com.ayushcoding.www.jclapp;

/**
 * Created by Ayush on 5/2/2016.
 */
public class Scores {
    int id, total, correct;
    String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public int getTotal() {
        return total;
    }

    public int getCorrect() {

        return correct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
