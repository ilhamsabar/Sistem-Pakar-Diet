package com.example.ilhamsabar.cobadiet;

/**
 * Created by ilham sabar on 11/20/2015.
 */
public class PeraturanAtkins {
    public int id;
    public String sarapan = "";
    public String makansiang = "";
    public String makanmalam = "";

    public void setID(int id){
        this.id = id;
    }

    public String getSarapan(){
        return sarapan;
    }

    public void setSarapan(){
        this.sarapan = sarapan;
    }

    public String getMakansiang(){
        return makansiang;
    }

    public void setMakansiang(){
        this.makansiang = makansiang;
    }

    public String getMakanmalam(){
        return makanmalam;
    }

    public void setMakanmalam(){
        this.makanmalam = makanmalam;
    }

    public PeraturanAtkins (String sarapan, String makansiang, String makanmalam){
        this.sarapan = sarapan;
        this.makansiang = makansiang;
        this.makanmalam = makanmalam;
    }

    public PeraturanAtkins(){

    }

}
