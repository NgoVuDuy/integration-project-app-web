package com.shop.shopnow.models;

public class GioHang {
    int id;
    String hinhanh;
    String ten, dongia, mausac, bonho, soluong, tongtien;


    public GioHang(int id, String hinhanh, String ten, String dongia, String mausac, String bonho, String soluong, String tongtien) {
        this.id = id;
        this.hinhanh = hinhanh;
        this.ten = ten;
        this.dongia = dongia;
        this.mausac = mausac;
        this.bonho = bonho;
        this.soluong = soluong;
        this.tongtien = tongtien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }
}
