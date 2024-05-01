package inheritance;
import java.util.*;

class person {
    protected String name;
    protected String address;
    protected String hobi;

    public void identity()
    {
        System.out.println("Nama : "+name);
        System.out.println("Alamat :"+address);
    }

    public void hobi()
    {
        System.out.println("Hobi saya : "+hobi);
    }
}
