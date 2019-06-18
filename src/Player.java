import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    int level = 10, uang = 100000, exp = 0, morexp = 50;
    String nama;
    ArrayList<Tanaman> arrBibit = new ArrayList();
    ArrayList<Ladang> arrPetak = new ArrayList();
    ArrayList<Item> arrItem = new ArrayList();
    ArrayList<Perabot> arrPerabot = new ArrayList();

    public Player(String nami) {
        nama = nami;
    }

    public void printStatus() {
        System.out.println("Level : " + level);
        System.out.println("Uang  : " + uang);
        System.out.println("exp   : " + exp + "(" + morexp + "exp lagi untuk nail lv)");
    }

    public void beliBibit(int index, int jumlah) {
        if (arrBibit.get(index).batasLv <= level) {
            if (arrBibit.get(index).hargaB*jumlah <= uang) {
                arrBibit.get(index).jumlah_bibit = +jumlah;
                uang=uang-arrBibit.get(index).hargaB*jumlah;
                System.out.println("Bibit Telah ditambahkan");
            } else {
                System.out.println("uang tidak mencukupi");
            }
        } else {
            System.out.println("Level tidak mencukupi");
        }
    }

    public void unlockPetak(int index) {
        if (arrPetak.get(index).islocked == true) {
            if (arrPetak.get(index).bataslv <= level) {
                if (arrPetak.get(index).harga <= uang) {
                    arrPetak.get(index).islocked = false;
                    uang=uang-arrPetak.get(index).harga;
                    System.out.println("ladang berhasil dibuka");
                }
            } else {
                System.out.println("level tidak mencukupi");
            }
        } else {
            System.out.println("Petak Ladang sudah Terbuka");
        }
        //islocked=false;
    }

    public void dapatExp(int experience) {
        exp = exp + experience;
        morexp = morexp - experience;
        if (morexp <= 0) {
            exp = morexp * -1;
            level++;
            morexp = level * 100 * 2;
        }
    }

    public void beliBibit(int index) {
        Scanner in = new Scanner(System.in);
        int input;
        if (arrBibit.get(index).batasLv <= level) {
            arrBibit.get(index).printDeskripsi();
            System.out.println("\nBeli dengan jumlah : ");
            input = in.nextInt();
            beliBibit(index, input);
        } else {
            System.out.println("tanaman belum terbuka");

        }
    }
    public void siramLadang(int index){
        if (arrPetak.get(index).status==2){
            arrPetak.get(index).status=1;
        }else {
            System.out.println("invalid");
        }
    }
    //indexl=index ladang indext=index bibit/tanaman
    public void tanam(int indexl , int indext){
        if (arrBibit.get(indext).jumlah_bibit>0){
            arrPetak.get(indexl).status=1;
            arrPetak.get(indexl).waktu=arrBibit.get(indext).lama_panen;
            arrPetak.get(indexl).tanaman=arrBibit.get(indext).nama_tanaman;
            arrPetak.get(indexl).jumlah=arrBibit.get(indext).jumlah_panen;
            arrPetak.get(indexl).exp_panen=arrBibit.get(indext).exp_panen;
            arrPetak.get(indexl).hargabuah=arrBibit.get(indexl).hargaJ;
            arrBibit.get(indext).jumlah_bibit--;
        }else{
            System.out.println("invalid");
        }
    }
    public void tampilkan_bibit(){
        int j=0;
        for (Tanaman i:arrBibit)
        {
            j++;
            if (i.batasLv<=level){
                System.out.print(j+". ");i.printTanaman();
            }else {
                break;
            }

        }
        System.out.println("0. cancel");
    }
    public void panen(int indexl){
        if (arrPetak.get(indexl).status==4){
            dapatExp(arrPetak.get(indexl).exp_panen);
            uang=uang+(arrPetak.get(indexl).jumlah*arrPetak.get(indexl).hargabuah);
            if (arrPerabot.get(2).jumlahPerabot==1){
                uang=uang+(arrPetak.get(indexl).jumlah*arrPetak.get(indexl).hargabuah);
            }
            arrPetak.get(indexl).status=0;
        }
    }
    public void beri_fertilizer(int index1){
        if (arrItem.get(1).jumlahItem>0&&arrPetak.get(index1).status!=0){
            for (Tanaman t:arrBibit) {
                if(arrPetak.get(index1).tanaman.equals(t.nama_tanaman)){
                    arrPetak.get(index1).waktu=arrPetak.get(index1).waktu - (t.lama_panen/2);
                    arrItem.get(1).jumlahItem--;
                    break;
                }
            }
        }else {
            System.out.println("invalid");
        }
    }
    public void beli_item(int index1){
        arrItem.get(index1).printDeskripsiItem();
        Scanner in = new Scanner(System.in);
        System.out.println("\nBeli dengan jumlah : ");
        int input;
        input = in.nextInt();
        if (arrItem.get(index1).harga*input<=uang) {
            arrItem.get(index1).jumlahItem=arrItem.get(index1).jumlahItem+input;
            uang=uang-arrItem.get(index1).harga*input;
        } else {
            System.out.println("Invalid");

        }
    }
    public void beli_perabot(int index){
        if (arrPerabot.get(index).jumlahPerabot==0 && uang>= arrPerabot.get(index).harga){
            arrPerabot.get(index).jumlahPerabot=1;
            uang=uang-arrPerabot.get(index).harga;
        }
    }
}
