package week9;

import java.util.Scanner;

public class buatbangundatar {
    public static void main(String[] args) {
        bangundatar persegi = new bangundatar(4);
        System.out.println("hasil luas persegi : "+ persegi.luas(4));
        bangundatar kp = new bangundatar(5);
        System.out.println("Hasil keliling persegi : "+kp.keliling(5));

        bangundatar persegipanjang = new bangundatar(4, 5);
        System.out.println("Hasil luas persegi panjang : " + persegipanjang.luas(4, 5));

        bangundatar segitiga = new bangundatar(4, 3);
        System.out.println("Hasil luas segitiga : "+segitiga.luas(4.0, 3.0));

        bangundatar lingkaran = new bangundatar(2);
        System.out.println("Hasil luas lingkaran : "+lingkaran.luas(2.0));
        bangundatar kl = new bangundatar(5);
        System.out.println("Hasil keliling lingkaran : " +kl.keliling(5.0));
        bangunruang kubus = new bangunruang(5);

        System.out.println("Hasil Volume Kubus : "+kubus.volumekubus(5));

        bangunruang balok = new bangunruang(5, 2, 2);
        System.out.println("Hasil Volume Balok : "+balok.volumebalok(5, 2, 2));
    }
}
