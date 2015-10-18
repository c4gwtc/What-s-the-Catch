package com.example.thomasgeorge.myapplication;

/**
 * Created by ThomasGeorge on 10/13/2015.
 */
public class DataProvider {
    private String fishname;
    private String fishmouth;
    private String fishtail;

    public String getFishname() {
        return fishname;
    }

    public void setFishname(String fishname) {
        this.fishname = fishname;
    }

    public String getFishmouth() {
        return fishmouth;
    }

    public void setFishmouth(String fishmouth) {
        this.fishmouth = fishmouth;
    }

    public String getFishtail() {
        return fishtail;
    }

    public void setFishtail(String fishtail) {
        this.fishtail = fishtail;
    }



    public DataProvider(String fishname, String fishmouth, String fishtail){
        this.fishname=fishname;
        this.fishmouth=fishmouth;
        this.fishtail=fishtail;
    }
}
