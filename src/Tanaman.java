public class Tanaman {

    public int id_tanaman, batasLv, lama_panen, hargaJ, hargaB, exp_panen,jumlah_bibit=0,jumlah_panen;
    public String jenis_tanaman, nama_tanaman;

    public Tanaman(int idtanam, int bLv, int lamapanen, int harJ, int harB, int exppanen, int jumlahpanen, String nama){
        id_tanaman = idtanam;
        batasLv = bLv;
        lama_panen = lamapanen;
        hargaB=harB;
        hargaJ=harJ;
        exp_panen=exppanen;
        jumlah_panen=jumlahpanen;
        nama_tanaman=nama;
    }

    public void printTanaman(){
        System.out.println(nama_tanaman+" ("+jumlah_bibit+" bibit)");
    }
    public void printDeskripsi(){
        System.out.println("Nama             : "+nama_tanaman);
        System.out.println("Harga bibit      : "+hargaB);
        System.out.println("Harga Jual/buah  : "+hargaJ);
        System.out.println("jumlah panen     : "+jumlah_panen);
        System.out.println("EXP yang didapat : "+exp_panen);
        System.out.println("Batas Lv "+batasLv);
    }

}
