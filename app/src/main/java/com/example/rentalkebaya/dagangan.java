package com.example.rentalkebaya;

public class dagangan {
    int imageDagangan;
    String keteranganDagangan;
    String namaGangan;
    double hargaDagangan;

    public dagangan(int imageDagangan, String keteranganDagangan, String namaGangan, double hargaDagangan) {
        this.imageDagangan = imageDagangan;
        this.keteranganDagangan = keteranganDagangan;
        this.namaGangan = namaGangan;
        this.hargaDagangan = hargaDagangan;
    }

    public int getImageDagangan() {
        return imageDagangan;
    }

    public void setImageDagangan(int imageDagangan) {
        this.imageDagangan = imageDagangan;
    }

    public String getKeteranganDagangan() {
        return keteranganDagangan;
    }

    public void setKeteranganDagangan(String keteranganDagangan) {
        this.keteranganDagangan = keteranganDagangan;
    }

    public String getNamaGangan() {
        return namaGangan;
    }

    public void setNamaGangan(String namaGangan) {
        this.namaGangan = namaGangan;
    }

    public double getHargaDagangan() {
        return hargaDagangan;
    }

    public void setHargaDagangan(double hargaDagangan) {
        this.hargaDagangan = hargaDagangan;
    }
}
