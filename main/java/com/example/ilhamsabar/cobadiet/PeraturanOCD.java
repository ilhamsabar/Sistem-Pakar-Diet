package com.example.ilhamsabar.cobadiet;

/**
 * Created by ilham sabar on 11/16/2015.
 */
public class PeraturanOCD {
    public int id;
    public String puasa16 = "";
    public String puasa18 = "";
    public String puasa20 = "";
    public String puasa24 = "";


    public PeraturanOCD() {
//        id = 0;
//        puasa16 = "";
//        puasa18 = "";
//        puasa20 = "";
//        puasa24 = "";
    }

    public void setID(int id){
        this.id = id;
    }

    public String getPuasa16(){
        return puasa16;
    }

    public void setPuasa16(){
        this.puasa16 = puasa16;
    }

    public String getPuasa18(){
        return puasa18;
    }

    public void setPuasa18(){
        this.puasa18 = puasa18;
    }

    public String getPuasa20(){
        return puasa20;
    }

    public void setPuasa20(){
        this.puasa20 = puasa20;
    }

    public String getPuasa24(){
        return puasa24;
    }

    public void setPuasa24(){
        this.puasa24 = puasa24;
    }

    public PeraturanOCD ( String puasa16, String puasa18, String puasa20, String puasa24){
        this.puasa16 = puasa16;
        this.puasa18 = puasa18;
        this.puasa20 = puasa20;
        this.puasa24 = puasa24;
    }



//	@Override
//	public String toString() {
//		return "Peraturan [id=" + id
//				+ ",Judul=" + Judul
//				+ ",Bab=" + Bab
//				+ ",Judul_Bab=" + Judul_Bab
//				+ ",Pasal=" + Pasal
//				+ ",Isi=" + Isi
//				+ "]";
//	}

//    public Peraturan(String Pagi, String Siang, String Malam, int ID) {
//        pagi = Pagi;
//        siang = Siang;
//        malam = Malam;
//
//    }
}