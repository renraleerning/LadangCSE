public class Tanaman {
    public int id_tanaman, batasLv, lama_panen, hargaJ, hargaB, exp_panen,jumlah_bibit=0,jumlah_panen;
    public String jenis_tanaman, nama_tanaman;

    public Tanaman(int idtanam, int bLv, int lamapanen, int harJ, int harB, int exppanen, int jumlahpanen, String nama, String jenis){
        id_tanaman = idtanam;
        batasLv = bLv;
        lama_panen = lamapanen;
        hargaB=harB;
        hargaJ=harJ;
        exp_panen=exppanen;
        jumlah_panen=jumlahpanen;
        nama_tanaman=nama;
        jenis_tanaman=jenis;
    }

}
