package week1;

public class tabung {
    public static void main(String[] args) {
        double phi=3.14;
        double tinggi=20;
        double diameter=14;
        double jari2 =  diameter / 2;
        double volume;

        System.out.println("Tinggi tabung adalah : " + tinggi);
        System.out.println("Diameter tabung adalah : " + diameter);
        System.out.println("Jari-jari tabung adalah : " + jari2);

        volume = phi * tinggi * (jari2*jari2);

        System.out.println("Maka Volumenya adalah : " + volume);
    }
}
