package com.example.runrun;

public class Train {

    private  String dist, time, date;

    public Train() {

    }

    public Train(String dist, String time, String date) {
        this.dist = dist;
        this.time = time;
        this.date = date;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
