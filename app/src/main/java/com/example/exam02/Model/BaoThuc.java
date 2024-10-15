package com.example.exam02.Model;

public class BaoThuc {
    private String tenBaoThuc;
    private String thoiGian;
    private Boolean lapLai;
    private String ngayTrongTuan;


    public BaoThuc(String tenBaoThuc, String thoiGian, Boolean lapLai, String ngayTrongTuan) {
        this.tenBaoThuc = tenBaoThuc;
        this.thoiGian = thoiGian;
        this.lapLai = lapLai;
        this.ngayTrongTuan = ngayTrongTuan;
    }

    public String getTenBaoThuc() {
        return tenBaoThuc;
    }

    public void setTenBaoThuc(String tenBaoThuc) {
        this.tenBaoThuc = tenBaoThuc;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Boolean getLapLai() {
        return lapLai;
    }

    public void setLapLai(Boolean lapLai) {
        this.lapLai = lapLai;
    }

    public String getNgayTrongTuan() {
        return ngayTrongTuan;
    }

    public void setNgayTrongTuan(String ngayTrongTuan) {
        this.ngayTrongTuan = ngayTrongTuan;
    }


    @Override
    public String toString() {
        return this.getThoiGian();
    }
}
