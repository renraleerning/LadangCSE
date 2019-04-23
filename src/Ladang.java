public class Ladang {
    boolean islocked=true;
    int waktu,lama_panen,harga;
    String tanaman;
    int bataslv;
    int status; //0=kosong, 1=sedang ditanam, 2=butuh air, 3 terkena hama, 4 panen, 5 mati

    public Ladang(int bLv, int hargi){
        bataslv=bLv;
        harga=hargi;
    }

    public void ubahStatus(int st){
        if (st>=0&&st<=5){
            status=st;
        }
    }
    public void siramTanaman(){
        if (status==2){
            if (waktu>=lama_panen){
                status=4;
            }else {
                status=1;
            }
        }
    }
}
