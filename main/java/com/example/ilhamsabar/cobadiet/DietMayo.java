package com.example.ilhamsabar.cobadiet;

/**
 * Created by ilham sabar on 11/15/2015.
 */
public class DietMayo {
    private int id;
    private String pagi;
    private  String siang;
    private  String malam;

    public DietMayo(){

    }

    public DietMayo(String pagi, String siang, String malam){
        super();
        this.pagi = pagi;
        this.siang = siang;
        this.malam = malam;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getPagi() {
        return pagi;
    }

    public void setPagi (String pagi){
        this.pagi = pagi;
    }

    public String getSiang() {
        return siang;
    }

    public void setSiang (String siang){
        this.siang =siang;
    }

    public String getMalam() {
        return pagi;
    }

    public void setMalam (String malam){
        this.malam = malam;
    }
}
