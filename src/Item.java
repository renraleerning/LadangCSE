public class Item extends Barang {

    public int jumlahItem=0;


    public Item( String namaI, int hargaI, String deskripsiI){
        tipe = "item";
        nama = namaI;
        harga = hargaI;
        deskripsi = deskripsiI;
    }

    public void printItem(){
        System.out.println(nama+" ("+jumlahItem+" buah)");
    }

    public void printDeskripsiItem(){
        System.out.println("Nama item    : "+nama);
        System.out.println("Harga item   : "+harga);
        System.out.println("Deskripsi    : "+deskripsi);
    }
}
