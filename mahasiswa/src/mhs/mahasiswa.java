/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mhs;

/**
 *
 * @author annis
 */
public class mahasiswa {
    protected String nim;
    protected String nama;
    protected double nilai_uts;
    protected double nilai_uas;
    protected double nilai_tugas;
    protected double nilai_akhir;
    protected char nilai_huruf;
    protected String predikat;

    public mahasiswa(String nim, String nama, double nilai_uts, double nilai_uas, double nilai_tugas) {
        this.nim = nim;
        this.nama = nama;
        this.nilai_uts = nilai_uts;
        this.nilai_uas = nilai_uas;
        this.nilai_tugas = nilai_tugas;
        
        // Hitung nilai akhir, nilai huruf, dan predikat saat objek dibuat
        hitungNilaiAkhir();
        tentukanNilaiHurufDanPredikat();
    }
    
    // Metode untuk menghitung nilai akhir
    public void hitungNilaiAkhir() {
        this.nilai_akhir = (nilai_uts * 0.35) + (nilai_uas * 0.35) + (nilai_tugas * 0.30);
    }

    // Metode untuk menentukan nilai huruf
    public void tentukanNilaiHurufDanPredikat() {
        if (nilai_akhir >= 80) {
            nilai_huruf = 'A';
            predikat = "Sangat Baik";
        } else if (nilai_akhir >= 70) {
            nilai_huruf = 'B';
            predikat = "Baik";
        } else if (nilai_akhir >= 60) {
            nilai_huruf = 'C';
            predikat = "Cukup";
        } else if (nilai_akhir >= 50) {
            nilai_huruf = 'D';
            predikat = "Kurang";
        } else {
            nilai_huruf = 'E';
            predikat = "Sangat Kurang";
        }
    }
    // Getter untuk mendapatkan nilai-nilai
    public double getNilai_uts() {
        return nilai_uts;
    }

    public double getNilai_uas() {
        return nilai_uas;
    }

    public double getNilai_tugas() {
        return nilai_tugas;
    }

    public double getNilai_akhir() {
        return nilai_akhir;
    }

    public char getNilai_huruf() {
        return nilai_huruf;
    }

    public String getPredikat() {
        return predikat;
    }
}
