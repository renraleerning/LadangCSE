public class Perabot extends Barang {

    public int jumlahPerabot=0;


    public Perabot(String namaP, int hargaP, String deskripsiP){
        tipe = "perabot";
        nama = namaP;
        harga = hargaP;
        deskripsi = deskripsiP;
    }

    public void printDeskripsiPerabot(){
        System.out.println("Nama perabot    : "+nama);
        System.out.println("Harga perabot   : "+harga);
        System.out.println("Deskripsi       : "+deskripsi);
    }
}
