package com.shop.shopnow.models;

public class News {
    int id;
    int src;
    String tieuDe;
    String noiDung;

    public String getTieuDeFull() {
        return tieuDeFull;
    }

    public void setTieuDeFull(String tieuDeFull) {
        this.tieuDeFull = tieuDeFull;
    }

    String tieuDeFull;

    public News(int src, String tieuDe) {
        this.src = src;
        this.tieuDe = tieuDe;
    }

    public News(int id, int src, String tieuDe, String noiDung, String tieuDeFull) {
        this.id = id;
        this.src = src;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
        this.tieuDeFull = tieuDeFull;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
