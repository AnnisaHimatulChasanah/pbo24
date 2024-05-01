package inheritance;
import java.util.*;

public class inheritmain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        student mhs = new student();

        System.out.print("Masukkan NIM : ");
        mhs.nim = input.next();
        System.out.print("Masukkan Nama : ");
        mhs.name = input.next();
        System.out.print("Masukkan Alamat : ");
        mhs.address = input.next();
        System.out.print("Masukkan SPP :");
        mhs.spp = input.nextInt();
        System.out.print("Masukkan SKS : ");
        mhs.sks = input.nextInt();
        System.out.print("Masukkan Modul : ");
        mhs.modul = input.nextInt();
        System.out.print("Masukkan hobi :");
        mhs.hobi = input.next();
        mhs.identity();
        mhs.hobi();

        // String nim = mhs.getNim();
        // System.out.println(nim);
    }
}

