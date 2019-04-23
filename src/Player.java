import java.util.ArrayList;

public class Player {
    int level=1,uang=100,exp=0;
    String nama;
    ArrayList<Tanaman> arrBibit = new ArrayList();
    ArrayList<Ladang> arrPetak = new ArrayList();

    public Player(String nami){
        nama=nami;
    }
    public void printStatus(){
    }
    public void beliBibit(int index, int jumlah){
        if (arrBibit.get(index).batasLv<=level){
            if (arrBibit.get(index).hargaB<=uang){
                arrBibit.get(index).jumlah_bibit=+jumlah;
                System.out.println("Bibit Telah ditambahkan");
            }else {
                System.out.println("uang tidak mencukupi");
            }
        }else{
            System.out.println("Level tidak mencukupi");
        }
    }
    public void unlockPetak(int index){
        if (arrPetak.get(index).islocked==true){
            if (arrPetak.get(index).bataslv<=level){
                if (arrPetak.get(index).harga<=uang){
                    arrPetak.get(index).islocked=false;
                    System.out.println("ladang berhasil dibuka");
                }
            }else {
                System.out.println("level tidak mencukupi");
            }
        }else {
            System.out.println("Petak Ladang sudah Terbuka");
        }
        //islocked=false;
    }
}
