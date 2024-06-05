package week9;

public class bangundatar {
    private int panjang;
    private int lebar;
    private int diameter;
    protected int sisi;
    private static final double pi = 3.14;

    public bangundatar(int sisi){
        this.sisi = sisi;
    }

    public bangundatar(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public int luas(int a){
        return a*a;
    }

    public int luas(int a, int b){
        return a*b;
    }

    //segitiga
    public double luas(double a, double b){
        return (a*b)/2;
    }

    //lingkaran
    public double luas(double a){
        return (double)pi*a*a; //parsing
    }

    public double keliling(double a){
        return 2*pi*a;
    }

    public int keliling(int a){
        return a+a+a+a;
    }

    public int getSisi(){
        return sisi;
    }

    public int getPanjang(){
        return panjang;
    }
    public int getLebar(){
        return lebar;
    }
    public int getDiameter(){
        return diameter;
    }
}
