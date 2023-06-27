package com.example.app;

public class MonAn {
    private int Id, gia;
    private String Ten, moTa;
    private byte[] Hinh;

    public MonAn(int id, String ten, String moTa, int gia, byte[] hinh) {
        Id = id;
        Ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        Hinh = hinh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public byte[] getHinh() {
        return Hinh;
    }

    public void setHinh(byte[] hinh) {
        Hinh = hinh;
    }
}
