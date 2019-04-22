import java.util.Scanner;
import java.util.ArrayList;

public class GameEngine {
    Player oPlayer;

    public void mulai () {
        boolean st=false;
        System.out.println("Masukkan Nama Anda :");
        Scanner in = new Scanner(System.in);
        String ngaran = in.nextLine();
        oPlayer = new Player(ngaran);
//        id_tanaman = idtanam;
//        batasLv = bLv;
//        lama_panen = lamapanen;
//        hargaJ=harJ;
//        hargaB=harB;
//        exp_panen=exppanen;
//        jumlah_panen=jumlahpanen;
//        nama_tanaman=nama;
//        jenis_tanaman=jenis;
        oPlayer.Bibit.add(0,new Tanaman(1,1,60,25,30,24,3,"kol","sayuran"));
        oPlayer.Bibit.add(1,new Tanaman(2,2,65,35,40,68,2,"nanas","buah"));
        oPlayer.Bibit.add(2,new Tanaman(3,2,73,30,43,55,3,"cabai","sayuran"));
        oPlayer.Bibit.add(3,new Tanaman(4,3,81,30,44,73,4,"jagung","sayuran"));
        oPlayer.Bibit.add(4,new Tanaman(5,3,88,35,50,75,2,"lobak","sayuran"));
        oPlayer.Bibit.add(5,new Tanaman(6,4,90,50,55,84,8,"almond","kacang-kacangan"));
        oPlayer.Bibit.add(6,new Tanaman(5,4,93,20,60,76,9,"mete","kacang-kacangan"));
        oPlayer.Bibit.add(7,new Tanaman(6,4,95,15,74,90,10,"Tauge","sayuran"));
        oPlayer.Bibit.add(8,new Tanaman(7,5,98,38,75,86,3,"kentang","sayuran"));
        oPlayer.Bibit.add(9,new Tanaman(8,5,100,40,78,100,2,"melon","buah"));
        oPlayer.Bibit.add(10,new Tanaman(9,5,95,28,80,80,5,"buncis","sayuran"));
        oPlayer.Bibit.add(11,new Tanaman(10,5,96,60,80,100,1,"pear","buah"));
        oPlayer.Bibit.add(12,new Tanaman(11,6,102,48,83,105,4,"tomat","sayuran"));
        oPlayer.Bibit.add(13,new Tanaman(12,6,107,33,84,106,3,"semangka","buah"));
        oPlayer.Bibit.add(14,new Tanaman(13, 6,102,50,88,100,3,"alpukat","buah"));
        oPlayer.Bibit.add(15,new Tanaman(14, 6,107,60,83,80,2,"apel","buah"));
        oPlayer.Bibit.add(16,new Tanaman(15,7,115,45,90,100,3,"paprika","sayuran"));
        oPlayer.Bibit.add(17,new Tanaman(16,7,115,40,90,102,3,"lemon","buah"));
        oPlayer.Bibit.add(18,new Tanaman(17,7,120,40,92,105,5,"rambutan","buah"));
        oPlayer.Bibit.add(19,new Tanaman(18,7,122,80,90,100,2,"jambu","buah"));
        oPlayer.Bibit.add(20,new Tanaman(19,8,122,60,101,120,4,"kembang kol","sayuran"));
        oPlayer.Bibit.add(21,new Tanaman(20,8,125,35,120,118,6,"oyong","sayuran"));
        oPlayer.Bibit.add(22,new Tanaman(21,8,125,60,134,128,3,"wortel","sayuran"));
        oPlayer.Bibit.add(23,new Tanaman(22,8,128,50,128,118,3,"buah naga","buah"));
        oPlayer.Bibit.add(24,new Tanaman(23,9,130,35,140,130,7,"mangga","buah"));
        oPlayer.Bibit.add(25,new Tanaman(24,9,133,88,145,133,4,"blueberry","buah"));
        oPlayer.Bibit.add(26,new Tanaman(25,9,135,92,148,140,3,"leci","buah"));
        oPlayer.Bibit.add(27,new Tanaman(26,9,135,30,150,138,8,"timun jepang","sayuran"));
        oPlayer.Bibit.add(28,new Tanaman(27,10,150,90,160,150,2,"asparagus","sayuran"));
        oPlayer.Bibit.add(29,new Tanaman(28,10,158,100,167,158,2,"bit","buah"));
        oPlayer.Bibit.add(30,new Tanaman(29,10,160,50,177,162,5,"zaitun","buah"));
        oPlayer.Bibit.add(31,new Tanaman(30,10,170,40,187,156,5,"kurma","buah"));


        do{

        }while(st==true);

    }

    public static void main(String[] args) {


        GameEngine ge = new GameEngine();
        ge.mulai();
    }
}
