package inheritance;
import java.util.*;

public class student extends person{
        String nim;
        int sks;
        int spp;
        int modul;

        public String getNim()
        {
            return nim;
        }

        @Override
        public void identity()
        {
            System.out.println("NIM : "+getNim());
            super.identity();
            System.out.println("Tagihan : "+ hitungPembayaran());
        }
        public int hitungPembayaran()
        {
            int total;
            modul = modul*100000;
            total = sks*250000;
            return spp + total + modul;
        }
}
