package com.shop.shopnow.models;

public class ChiTietDon {
    String anh;
    String ten;
    String soluong;
    String mausac;
    String bonho;

    public ChiTietDon(String anh, String ten, String soluong, String mausac, String bonho) {
        this.anh = anh;
        this.ten = ten;
        this.soluong = soluong;
        this.mausac = mausac;
        this.bonho = bonho;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public String getBonho() {
        return bonho;
    }

    public void setBonho(String bonho) {
        this.bonho = bonho;
    }
}
