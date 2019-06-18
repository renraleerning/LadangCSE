import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class Thread1 extends Thread {
    private int rand;
    public static Player oPlayer;
    //Buat frame
    private static JFrame f = new JFrame("Ladang.CSE");
    private static MyGUI g = new MyGUI();

    private void createAndShowGUI() {
        //exit jika window ditutup
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tambahkan panel
        f.add(g);
        //pack semua komponen dalam panel
        f.pack();
        //set ukuran panel dalam pixel: lebar, tinggi
        f.setSize(650,500);
        f.setVisible(true);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                refresh();
                run();
            }
        });
        timer.start();
        
    }
    public Thread1(){
    createAndShowGUI();
    }

    private void refresh(){
        f.getContentPane().remove(g);
        f.getContentPane().invalidate();
        f.getContentPane().add(g);
        f.getContentPane().revalidate();
        f.repaint();
    }

    public void run() {
        //untuk notice penambahan uang level exp
        if(oPlayer.exp!=g.expnow){
            g.e=3;
            g.expget=oPlayer.exp-g.expnow;
            g.expnow=oPlayer.exp;
        }
        if (oPlayer.level!=g.lvnow){
            g.l=3;
            g.lvnow=oPlayer.level;
        }
        if (oPlayer.uang!=g.moneynow){
            g.m=3;
            g.moneyget=oPlayer.uang-g.moneynow;
            g.moneynow=oPlayer.uang;
        }
        //pengubahan status ladang
        for (int i=0;i<10;i++){
            if (oPlayer.arrPetak.get(i).status!=0 && !oPlayer.arrPetak.get(i).islocked){
                oPlayer.arrPetak.get(i).waktu--;
                if (oPlayer.arrPetak.get(i).status==1 && oPlayer.arrPetak.get(i).waktu%20==0){//setiap 20 detik akan diserang hama atau layu
                    rand=(int)(Math.random() * ((100 - 5) + 1)) + 5;
                    if (rand>50){
                        if (oPlayer.arrPerabot.get(0).jumlahPerabot!=1){
                            oPlayer.arrPetak.get(i).status=2;
                        }
                    }else if(rand>35){
                        if (oPlayer.arrPerabot.get(1).jumlahPerabot!=1){
                            oPlayer.arrPetak.get(i).status=3;
                        }
                    }
                }else if ((oPlayer.arrPetak.get(i).status==2 || oPlayer.arrPetak.get(i).status==3) && oPlayer.arrPetak.get(i).waktu%20==0){
                    oPlayer.arrPetak.get(i).status=5;
                }
                if (oPlayer.arrPetak.get(i).waktu<=0&&(oPlayer.arrPetak.get(i).status==1||oPlayer.arrPetak.get(i).status==2||oPlayer.arrPetak.get(i).status==3)){
                    oPlayer.arrPetak.get(i).status=4;
                    oPlayer.arrPetak.get(i).waktu=100;
                }else if (oPlayer.arrPetak.get(i).status==4&&oPlayer.arrPetak.get(i).waktu<=0){
                    oPlayer.arrPetak.get(i).status=5;
                }
            }
        }
        //refresh();
    }
}

