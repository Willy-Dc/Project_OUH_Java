/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugasproject;

/**
 *
 * @author MSI THIN 15
 */
public class Main {
    public static void main(String[] args) {

        OrangUtan[] tracker = new OrangUtan[6];

        tracker[0] = new OrangUtanHaven("Lewis", "Makan", "Pulau 3");
        tracker[1] = new OrangUtanHaven("Fahzren", "Istirahat", "Pulau 5");
        tracker[2] = new OrangUtanHaven("Dina", "Makan", "Pulau 7");
        tracker[3] = new OrangUtanHaven("Krismon", "Istirahat", "Pulau 8");
        tracker[4] = new OrangUtanHaven("Leuser", "Istirahat", "Pulau 9");
        tracker[5] = new OrangUtanHaven("Dek Nong", "Istirahat", "Pulau 4");

        int[] respon = {5, 0, 0, 8, 0, 4};

        for (int i = 0; i < tracker.length; i++) {
            tracker[i].lakukanAktivitas();
            tracker[i].cekRespon("tidak ada");
            tracker[i].cekRespon("pengunjung", respon[i]);
            System.out.println("--------------------------------");
        }
    }
}

abstract class OrangUtan {

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the aktivitasSaatIni
     */
    public String getAktivitasSaatIni() {
        return aktivitasSaatIni;
    }

    private String nama;
    private String aktivitasSaatIni;
    private String responStimulus;

    public OrangUtan(String nama, String aktivitasSaatIni) {
        this.nama = nama;
        setAktivitasSaatIni(aktivitasSaatIni); 
    }
  
    public void setAktivitasSaatIni(String aktivitasSaatIni) {
        if (aktivitasSaatIni.equals("Makan") ||
            aktivitasSaatIni.equals("Manjat") ||
            aktivitasSaatIni.equals("Istirahat") ||
            aktivitasSaatIni.equals("Interaksi")) {

            this.aktivitasSaatIni = aktivitasSaatIni;
        } else {
            System.out.println("Aktivitas tidak terdefinisi");
            this.aktivitasSaatIni = "Tidak diketahui";
        }
    }

    public String getResponStimulus() {
        return responStimulus;
    }

    public void setResponStimulus(String responStimulus) {
        this.responStimulus = responStimulus;
    }

    // Abstract method
    public abstract void lakukanAktivitas();

    // Overloading
    public void cekRespon(String stimulus) {
        setResponStimulus(stimulus);
        System.out.println("Respon terhadap Makanan: " + stimulus);
    }

    public void cekRespon(String stimulus, int tingkatRespon) {
        System.out.println("Respon terhadap " + stimulus + " : " + tingkatRespon + "/10");
    }
}

class OrangUtanHaven extends OrangUtan {

    /**
     * @return the lokasi
     */
    public String getLokasi() {
        return lokasi;
    }

    /**
     * @param lokasi the lokasi to set
     */
    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    private String lokasi;

    public OrangUtanHaven(String nama, String aktivitasSaatIni, String lokasi) {
        super(nama, aktivitasSaatIni);
        this.lokasi = lokasi;
    }


    @Override
    public void lakukanAktivitas() {
        System.out.println("Lokasi   : " + getLokasi());
        System.out.println("Nama     : " + getNama());

        if (getAktivitasSaatIni().equalsIgnoreCase("Makan")) {
            System.out.println("Aktivitas: sedang makan pisang");
        } else if (getAktivitasSaatIni().equalsIgnoreCase("Manjat")) {
            System.out.println("Aktivitas: sedang memanjat pohon");
        } else if (getAktivitasSaatIni().equalsIgnoreCase("Istirahat")) {
            System.out.println("Aktivitas: sedang istirahat");
        } else if (getAktivitasSaatIni().equalsIgnoreCase("Interaksi")) {
            System.out.println("Aktivitas: sedang berinteraksi");
        } else {
            System.out.println("Aktivitas: tidak terdefinisi");
        }
    }
}

