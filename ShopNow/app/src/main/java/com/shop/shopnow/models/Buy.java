package com.shop.shopnow.models;

public class Buy {
    String hinh, ten, soluong, dongia, mausac, bonho;

    public Buy(String hinh, String ten, String soluong, String dongia, String mausac, String bonho) {
        this.hinh = hinh;
        this.ten = ten;
        this.soluong = soluong;
        this.dongia = dongia;
        this.mausac = mausac;
        this.bonho = bonho;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
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

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
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
