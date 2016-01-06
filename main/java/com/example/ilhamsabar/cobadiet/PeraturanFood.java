package com.example.ilhamsabar.cobadiet;

/**
 * Created by ilham sabar on 11/21/2015.
 */
public class PeraturanFood {
    public int id;
    public String sarapan = "";
    public String makansiang = "";
    public String makansore = "";
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

    public String getMakansore(){
        return makansore;
    }

    public void setMakansore(){
        this.makansiang = makansore;
    }

    public String getMakanmalam(){
        return makanmalam;
    }

    public void setMakanmalam(){
        this.makanmalam = makanmalam;
    }

    public PeraturanFood (String sarapan, String makansiang, String makansore, String makanmalam){
        this.sarapan = sarapan;
        this.makansiang = makansiang;
        this.makansore = makansore;
        this.makanmalam = makanmalam;
    }

    public PeraturanFood(){

    }
}


