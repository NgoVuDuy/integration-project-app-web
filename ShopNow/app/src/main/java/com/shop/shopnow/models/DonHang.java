package com.shop.shopnow.models;

public class DonHang {
    int maDon;
    String tamTinh;
    String phiVanChuyen;
    String tongTien;
    String trangThai;

    public DonHang(int maDon, String tamTinh, String phiVanChuyen, String tongTien, String trangThai) {
        this.maDon = maDon;
        this.tamTinh = tamTinh;
        this.phiVanChuyen = phiVanChuyen;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public int getMaDon() {
        return maDon;
    }

    public void setMaDon(int maDon) {
        this.maDon = maDon;
    }

    public String getTamTinh() {
        return tamTinh;
    }

    public void setTamTinh(String tamTinh) {
        this.tamTinh = tamTinh;
    }

    public String getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public void setPhiVanChuyen(String phiVanChuyen) {
        this.phiVanChuyen = phiVanChuyen;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
