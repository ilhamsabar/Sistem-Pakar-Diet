package com.example.ilhamsabar.cobadiet;

/**
 * Created by ilham sabar on 11/21/2015.
 */
public class PeraturanGoldarah {
    public int id;
    public String gola = "";
    public String golb = "";
    public String golo = "";
    public String golab = "";

    public void setID(int id){
        this.id = id;
    }

    public String getGola(){
        return gola;
    }

    public void setGola(){
        this.gola = gola;
    }

    public String getGolb(){
        return golb;
    }

    public void setGolb(){
        this.golb = golb;
    }

    public String getGolo(){
        return golo;
    }

    public void setGolo(){
        this.golo = golo;
    }

    public void setGolab(){
        this.golab = golab;
    }
    public String getGolab(){
        return golab;
    }


    public PeraturanGoldarah (String gola, String golb, String golo, String golab){
        this.gola = gola;
        this.golb = golb;
        this.golo = golo;
        this.golab = golab;
    }

    public PeraturanGoldarah(){

    }
}
