import java.util.Scanner;

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
        oPlayer.arrBibit.add(2,new Tanaman(3,2,73,30,43,55,4,"cabai"));
        oPlayer.arrBibit.add(3,new Tanaman(4,3,81,30,44,60,5,"labu"));
        oPlayer.arrBibit.add(4,new Tanaman(5,3,88,35,50,78,2,"lobak"));
        oPlayer.arrBibit.add(5,new Tanaman(6,4,90,50,55,84,8,"almond"));
        oPlayer.arrBibit.add(6,new Tanaman(5,4,93,20,60,76,12,"mete"));
        oPlayer.arrBibit.add(7,new Tanaman(6,4,95,15,74,90,10,"tauge"));
        oPlayer.arrBibit.add(8,new Tanaman(7,5,98,38,75,90,3,"padi"));
        oPlayer.arrBibit.add(9,new Tanaman(8,5,100,40,80,120,2,"melon"));
        oPlayer.arrBibit.add(10,new Tanaman(9,5,95,28,80,80,5,"buncis"));
        oPlayer.arrBibit.add(11,new Tanaman(10,5,96,60,80,100,3,"pear"));
        oPlayer.arrBibit.add(12,new Tanaman(11,6,102,48,83,135,5,"tomat"));
        oPlayer.arrBibit.add(13,new Tanaman(12,6,107,33,84,126,6,"peach"));
        oPlayer.arrBibit.add(14,new Tanaman(13, 6,102,50,88,130,6,"jamur"));
        oPlayer.arrBibit.add(15,new Tanaman(14, 6,107,60,120,180,2,"apel"));
        oPlayer.arrBibit.add(16,new Tanaman(15,7,115,45,90,220,2,"paprika"));
        oPlayer.arrBibit.add(17,new Tanaman(16,7,115,79,90,122,5,"lemon"));
        oPlayer.arrBibit.add(18,new Tanaman(17,7,120,120,92,135,7,"jeruk"));
        oPlayer.arrBibit.add(19,new Tanaman(18,7,122,24,90,150,10,"jambu"));
        oPlayer.arrBibit.add(20,new Tanaman(19,8,122,80,101,220,5,"kiwi"));
        oPlayer.arrBibit.add(21,new Tanaman(20,8,125,95,120,218,8,"aloe"));
        oPlayer.arrBibit.add(22,new Tanaman(21,8,125,100,134,228,5,"wortel"));
        oPlayer.arrBibit.add(23,new Tanaman(22,8,128,80,128,218,6,"ceri"));
        oPlayer.arrBibit.add(24,new Tanaman(23,9,130,55,140,330,7,"mangga"));
        oPlayer.arrBibit.add(25,new Tanaman(24,9,133,98,145,333,10,"manggis"));
        oPlayer.arrBibit.add(26,new Tanaman(25,9,135,102,201,340,12,"leci"));
        oPlayer.arrBibit.add(27,new Tanaman(26,9,135,130,150,308,5,"durian"));
        oPlayer.arrBibit.add(28,new Tanaman(27,10,150,90,160,450,5,"sunkist"));
        oPlayer.arrBibit.add(29,new Tanaman(28,10,158,100,167,458,8,"bit"));
        oPlayer.arrBibit.add(30,new Tanaman(29,10,160,300,177,462,4,"zaitun"));
        oPlayer.arrBibit.add(31,new Tanaman(30,10,170,40,187,556,3,"kurma"));

        //simpan item
        oPlayer.arrItem.add(0, new Item("Anti Hama", 80,"Item ini akan menjaga tanaman Anda dari hama"));
        oPlayer.arrItem.add(1, new Item("Fertilizer", 200,"Item ini akan membuat tanaman Anda cepat panen"));

        //simpan perabot
        oPlayer.arrPerabot.add(0, new Perabot("Jet Pump", 12000,"Perabot Jet Pump ini akan menyiram seluruh ladang yang berisi tanaman"));
        oPlayer.arrPerabot.add(1, new Perabot("Pagar", 8500,"Perabot Pagar ini akan menjaga tanaman Anda dari hama"));
        oPlayer.arrPerabot.add(2, new Perabot("Pembungkus Buah",17500,"Perabot Pembungkus Buah ini akan memperbagus buah sehingga harga buah menjadi 2x lipat"));

        //buat ladang
        oPlayer.arrPetak.add(0,new Ladang(1,0, false));
        for (int j=1;j<10;j++){
            oPlayer.arrPetak.add(j,new Ladang(j+1,(j*3/2)*500, true));
        }
        //buat thread dan GUI
        MyGUI.oPlayer=oPlayer;
        Thread1 t1= new Thread1();
        Thread1.oPlayer=oPlayer;
        //t1.start();
    }
    public void mulai () {
        Scanner in = new Scanner(System.in);
        boolean st=false;
        int input, input2, input3;
        int i=0;


        //
        do{
            System.out.println("Hai "+oPlayer.nama+" apa yang akan kamu lakukan?");
            oPlayer.printStatus();
            System.out.println("\nMenu : ");
            System.out.println("1. Tanam                6.  Buka ladang");
            System.out.println("2. Siram                7.  Beri Fertilizer");
            System.out.println("3. Panen                8.  Beli Bibit");
            System.out.println("4. Bersihkan ladang     9.  Beli Item");
            System.out.println("5. Beri antihama        10. Beli Perabot");
            System.out.println("");
            System.out.println("Masukkan Pilihan : "); input=in.nextInt();
            switch (input){
                case 1 : //tanam ladang
                    do{
                        System.out.println("tanam di ladang No 0-9 (99 untuk keluar): ");
                        input2=in.nextInt();
                        if (input2>-1&&input2<10){
                            if (!oPlayer.arrPetak.get(input2).islocked && oPlayer.arrPetak.get(input2).status==0){
                                System.out.println("tanam dengan bibit : ");
                                oPlayer.tampilkan_bibit();
                                System.out.println("masukkan pilihan : "); input3 = in.nextInt();
                                input3--;
                                if (input3>=0&&input3<32){
                                    oPlayer.tanam(input2,input3);
                                }
                            }else if (input2==99) {
                                break;
                            }else {
                                    System.out.println("invalid!");
                                }
                            }
                        }while (input2!=99);
                    break;
                case 2://siram
                    do{
                        System.out.println("Siram Ladang No 0-9 (99 untuk keluar): ");
                        input2=in.nextInt();
                        if (input2>-1 && input2<10){
                            oPlayer.siramLadang(input2);
                        }else{
                            System.out.println("Invalid");
                        }
                    }while (input2!=99);
                    break;
                case 3 ://panen
                    do {
                        System.out.println("panen ladang No 0-9 (99 untuk keluar) : ");input2 = in.nextInt();
                        if (input2>-1 && input2<10) {
                            oPlayer.panen(input2);
                        }
                    }while (input2!=99);
                    break;
                case 4 : //bersihkan ladang
                        System.out.println("bersihkan ladang No : "); input2 = in.nextInt();
                        if (input2>-1 && input2<10){
                            oPlayer.arrPetak.get(input2).status=0;
                        }
                    break;
                case 5 ://beri antihama
                    System.out.println("Beri Anti Hama ke ladang No : "); input2 = in.nextInt();
                    if (input2>-1 && input2<10 && oPlayer.arrItem.get(0).jumlahItem>0 && oPlayer.arrPetak.get(input2).status==3){
                        oPlayer.arrItem.get(0).jumlahItem--;
                        oPlayer.arrPetak.get(input2).status=1;
                    }else {
                        System.out.println("invalid");
                    }
                    break;
                case 6 ://buka ladang
                    System.out.println("Buka Ladang No ; ");
                    System.out.println("masukkan pilihan : "); input2 = in.nextInt();
                    if (input2>-1 && input2<10){
                        oPlayer.unlockPetak(input2);
                    }
                    break;
                case 7://beri fertilizer
                    System.out.println("Beri Anti Fertilizer ke ladang No : "); input2 = in.nextInt();
                    if (input2>-1 && input2<10){
                        oPlayer.beri_fertilizer(input2);
                    }
                    break;
                case 8 ://Beli bibit
                    oPlayer.tampilkan_bibit();
                    System.out.println("masukkan pilihan : "); input2 = in.nextInt();
                    input2--;
                    if (input2>=0&&input2<32){
                        oPlayer.beliBibit(input2);
                    }else if (input2!=-1){
                        System.out.println("tanaman tidak ditemukan");
                    }
                    break;
                case 9 ://Beli Item
                    i=1;
                    for (Item I: oPlayer.arrItem) {
                        System.out.println(i+". "+I.nama);
                        i++;
                    }
                    System.out.println("masukkan pilihan : "); input2 = in.nextInt();
                    input2--;
                    if (input2>=0&&input2<=1){
                        oPlayer.beli_item(input2);
                    }else {
                        System.out.println("invalid");
                    }
                    break;
                case 10 ://beli perabot
                    i=1;
                    for (Perabot P: oPlayer.arrPerabot) {
                        System.out.println(i+". ");
                        P.printDeskripsiPerabot();
                        i++;
                    }
                    System.out.println("masukkan pilihan : "); input2 = in.nextInt();
                    input2--;
                    if (input2>=0&&input2<=2){
                        oPlayer.beli_perabot(input2);
                    }
                    break;
                case 99 :
                    break;
                case 141197:
                    oPlayer.uang=oPlayer.uang+100000;
                    oPlayer.level=9;
                    break;
            }
        }while(st==false);

    }

    public static void main(String[] args) {
        GameEngine ge = new GameEngine();
        ge.mulai();

    }
}
