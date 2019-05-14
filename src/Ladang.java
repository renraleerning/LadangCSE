public class Ladang {
    boolean islocked=true;
    int waktu,harga;
    int hargabuah;
    int jumlah; //jumlah panen
    String tanaman;
    int bataslv;
    int exp_panen;
    int status; //0=kosong, 1=sedang ditanam, 2=butuh air, 3 terkena hama, 4 panen, 5 mati

    public Ladang(int bLv, int hargi, boolean lock){
        bataslv=bLv;
        harga=hargi;
        islocked=lock;
    }

    public void ubahStatus(int st){
        if (st>=0&&st<=5){
            status=st;
        }
    }
}
