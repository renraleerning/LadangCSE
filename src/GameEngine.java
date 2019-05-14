import java.util.Scanner;
import java.util.ArrayList;

public class GameEngine {
    static Player oPlayer;

    public GameEngine(){
        System.out.println("Masukkan Nama Anda :");
        Scanner in = new Scanner(System.in);
        String ngaran = in.nextLine();
        oPlayer = new Player(ngaran);

        //simpan bibit;
        oPlayer.arrBibit.add(0,new Tanaman(1,1,60,25,30,24,3,"kol"));
        oPlayer.arrBibit.add(1,new Tanaman(2,2,65,35,40,68,2,"nanas"));
        oPlayer.arrBibit.add(2,new Tanaman(3,2,73,30,43,55,3,"cabai"));
        oPlayer.arrBibit.add(3,new Tanaman(4,3,81,30,44,73,4,"labu"));
        oPlayer.arrBibit.add(4,new Tanaman(5,3,88,35,50,75,2,"lobak"));
        oPlayer.arrBibit.add(5,new Tanaman(6,4,90,50,55,84,8,"almond"));
        oPlayer.arrBibit.add(6,new Tanaman(5,4,93,20,60,76,9,"mete"));
        oPlayer.arrBibit.add(7,new Tanaman(6,4,95,15,74,90,10,"tauge"));
        oPlayer.arrBibit.add(8,new Tanaman(7,5,98,38,75,86,3,"padi"));
        oPlayer.arrBibit.add(9,new Tanaman(8,5,100,40,78,100,2,"melon"));
        oPlayer.arrBibit.add(10,new Tanaman(9,5,95,28,80,80,5,"buncis"));
        oPlayer.arrBibit.add(11,new Tanaman(10,5,96,60,80,100,2,"pear"));
        oPlayer.arrBibit.add(12,new Tanaman(11,6,102,48,83,105,4,"tomat"));
        oPlayer.arrBibit.add(13,new Tanaman(12,6,107,33,84,106,3,"peach"));
        oPlayer.arrBibit.add(14,new Tanaman(13, 6,102,50,88,100,3,"jamur"));
        oPlayer.arrBibit.add(15,new Tanaman(14, 6,107,60,83,80,2,"apel"));
        oPlayer.arrBibit.add(16,new Tanaman(15,7,115,45,90,100,3,"paprika"));
        oPlayer.arrBibit.add(17,new Tanaman(16,7,115,40,90,102,3,"lemon"));
        oPlayer.arrBibit.add(18,new Tanaman(17,7,120,40,92,105,5,"jeruk"));
        oPlayer.arrBibit.add(19,new Tanaman(18,7,122,80,90,100,2,"jambu"));
        oPlayer.arrBibit.add(20,new Tanaman(19,8,122,60,101,120,4,"kiwi"));
        oPlayer.arrBibit.add(21,new Tanaman(20,8,125,35,120,118,6,"aloe"));
        oPlayer.arrBibit.add(22,new Tanaman(21,8,125,60,134,128,3,"wortel"));
        oPlayer.arrBibit.add(23,new Tanaman(22,8,128,50,128,118,3,"ceri"));
        oPlayer.arrBibit.add(24,new Tanaman(23,9,130,35,140,130,7,"mangga"));
        oPlayer.arrBibit.add(25,new Tanaman(24,9,133,88,145,133,4,"manggis"));
        oPlayer.arrBibit.add(26,new Tanaman(25,9,135,92,148,140,3,"leci"));
        oPlayer.arrBibit.add(27,new Tanaman(26,9,135,30,150,138,8,"durian"));
        oPlayer.arrBibit.add(28,new Tanaman(27,10,150,90,160,150,2,"sunkist"));
        oPlayer.arrBibit.add(29,new Tanaman(28,10,158,100,167,158,2,"bit"));
        oPlayer.arrBibit.add(30,new Tanaman(29,10,160,50,177,162,5,"zaitun"));
        oPlayer.arrBibit.add(31,new Tanaman(30,10,170,40,187,156,5,"kurma"));

        //buat ladang
        oPlayer.arrPetak.add(0,new Ladang(1,0, false));
        for (int j=1;j<10;j++){
            oPlayer.arrPetak.add(j,new Ladang(j+1,(j*3/2)*500, true));
        }
        //buat thread dan GUI
        MyGUI.oPlayer=oPlayer;
        Thread1 t1= new Thread1();
        Thread1.oPlayer=oPlayer;
        t1.start();
    }
    public void mulai () {
        Scanner in = new Scanner(System.in);
        boolean st=false;
        int input, input2, input3;
        int j=0;


        //
        do{
            System.out.println("Hai "+oPlayer.nama+" apa yang akan kamu lakukan?");
            oPlayer.printStatus();
            System.out.println("\nMenu : ");
            System.out.println("1. Tanam                6. Beri Fertilizer");
            System.out.println("2. Siram                7. Beli Bibit");
            System.out.println("3. Panen                8. Beli Item");
            System.out.println("4. Bersihkan ladang     9. Beli Perabot");
            System.out.println("5. Buka Ladang");
            System.out.println("");
            System.out.println("Masukkan Pilihan : "); input=in.nextInt();
            switch (input){
                case 1 :

                    break;
                case 2:
                    System.out.println("(99 untuk keluar) \nSiram Ladang No : ");
                    do{
                        input2=in.nextInt();
                        if (input2>-1 && input2<10){
                            oPlayer.siramLadang(input2);
                        }else{
                            System.out.println("Invalid");
                        }
                    }while (input2!=99);
                    break;

                case 7 :
                    j=0;
                    for (Tanaman i:oPlayer.arrBibit)
                    {
                        j++;
                        if (i.batasLv<=oPlayer.level){
                            System.out.print(j+". ");i.printTanaman();
                        }else {
                            break;
                        }

                    }
                    System.out.println("0. cancel");
                    System.out.println("masukkan pilihan : "); input2 = in.nextInt();
                    input2--;
                    if (input2>=0&&input2<32){
                        oPlayer.beliBibit(input2);
                    }else if (input2!=-1){
                        System.out.println("tanaman tidak ditemukan");
                    }
                    break;
                case 99 :
                    break;
            }
        }while(st==false);

    }

    public static void main(String[] args) {
        GameEngine ge = new GameEngine();
        ge.mulai();

    }
}
