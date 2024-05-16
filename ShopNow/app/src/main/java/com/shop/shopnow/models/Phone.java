package com.shop.shopnow.models;

import java.io.Serializable;

public class Phone implements Serializable {
    int idDienThoai;
    String tenDienThoai;
    String giaDienThoai;
    String manHinh;
    String heDieuHanh;
    String camreraTruoc, camreraSau;
    String chip, ram, sim,pin, hang;
    String mauMacDinh, boNhoMacDinh;
    String src;

    public Phone() {
    }

    public Phone(int idDienThoai, String src, String tenDienThoai) {
        this.idDienThoai = idDienThoai;
        this.src = src;
        this.tenDienThoai = tenDienThoai;
    }

    public Phone(int idDienThoai, String tenDienThoai, String giaDienThoai, String manHinh, String heDieuHanh, String camreraTruoc, String camreraSau, String chip, String ram, String sim, String pin, String hang, String mauMacDinh, String boNhoMacDinh, String src) {
        this.idDienThoai = idDienThoai;
        this.tenDienThoai = tenDienThoai;
        this.giaDienThoai = giaDienThoai;
        this.manHinh = manHinh;
        this.heDieuHanh = heDieuHanh;
        this.camreraTruoc = camreraTruoc;
        this.camreraSau = camreraSau;
        this.chip = chip;
        this.ram = ram;
        this.sim = sim;
        this.pin = pin;
        this.hang = hang;
        this.mauMacDinh = mauMacDinh;
        this.boNhoMacDinh = boNhoMacDinh;
        this.src = src;
    }

    public int getIdDienThoai() {
        return idDienThoai;
    }

    public void setIdDienThoai(int idDienThoai) {
        this.idDienThoai = idDienThoai;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getCamreraTruoc() {
        return camreraTruoc;
    }

    public void setCamreraTruoc(String camreraTruoc) {
        this.camreraTruoc = camreraTruoc;
    }

    public String getCamreraSau() {
        return camreraSau;
    }

    public void setCamreraSau(String camreraSau) {
        this.camreraSau = camreraSau;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getMauMacDinh() {
        return mauMacDinh;
    }

    public void setMauMacDinh(String mauMacDinh) {
        this.mauMacDinh = mauMacDinh;
    }

    public String getBoNhoMacDinh() {
        return boNhoMacDinh;
    }

    public void setBoNhoMacDinh(String boNhoMacDinh) {
        this.boNhoMacDinh = boNhoMacDinh;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTenDienThoai() {
        return tenDienThoai;
    }

    public void setTenDienThoai(String tenDienThoai) {
        this.tenDienThoai = tenDienThoai;
    }

    public String getGiaDienThoai() {
        return giaDienThoai;
    }

    public void setGiaDienThoai(String giaDienThoai) {
        this.giaDienThoai = giaDienThoai;
    }
}


