package week9;

public class bangunruang extends bangundatar {
    private int tinggi;

    public bangunruang(int panjang, int lebar, int tinggi){
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public int getTinggi(){
        return tinggi;
    }

    public bangunruang(int sisi){
        super(sisi);
        this.sisi = super.getSisi();
    }

    public int volumekubus(int sisi){
        return super.getSisi()*super.getSisi()*super.getSisi();
    }

    public int volumebalok(int panjang, int lebar, int tinggi){
        return super.getPanjang()*super.getLebar()*getTinggi();
    }
}
