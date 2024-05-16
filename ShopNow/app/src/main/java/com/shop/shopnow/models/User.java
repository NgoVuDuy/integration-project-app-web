package com.shop.shopnow.models;

public class User {
    String taikhoan, sodienthoai, email, matkhau, xacnhanmaukhau;

    public User(String taikhoan, String sodienthoai, String email, String matkhau, String xacnhanmatkhau) {
        this.taikhoan = taikhoan;
        this.sodienthoai = sodienthoai;
        this.email = email;
        this.matkhau = matkhau;
        this.xacnhanmaukhau = xacnhanmatkhau;
    }

    public String getXacnhanmaukhau() {
        return xacnhanmaukhau;
    }

    public void setXacnhanmaukhau(String xacnhanmaukhau) {
        this.xacnhanmaukhau = xacnhanmaukhau;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

}
