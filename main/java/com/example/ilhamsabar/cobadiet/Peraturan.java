package com.example.ilhamsabar.cobadiet;

/**
 * Created by ilham sabar on 11/4/2015.
 */
public class Peraturan {
    public int id;
    public String pagi;
    public String siang;
    public String malam;


    public Peraturan() {
        pagi="";
        siang = "";
        malam = "";
        id = 0;
    }

    @Override
    public String toString() {
        return "Peraturan [id=" + id
                + ",pagi=" + pagi
                + ",siang=" + siang
                + ",malam=" + malam;
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
