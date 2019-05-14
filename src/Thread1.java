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
        f.setSize(800,600);
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
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        for (int i=0;i<10;i++){
            if (oPlayer.arrPetak.get(i).status!=0 && !oPlayer.arrPetak.get(i).islocked){
                oPlayer.arrPetak.get(i).waktu--;
                if (oPlayer.arrPetak.get(i).status==1 && oPlayer.arrPetak.get(i).waktu%20==0){
                    rand=(int)(Math.random() * ((100 - 5) + 1)) + 5;
                    if (rand>50){
                        oPlayer.arrPetak.get(i).status=2;
                    }
                }else if (oPlayer.arrPetak.get(i).status==2 && oPlayer.arrPetak.get(i).waktu%20==0){
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

class MyGUI extends JPanel {

    public int[] posX = new int[10];
    public int[] posY = new int[10];
    public static Player oPlayer;
    public int jumlah=0;
    public MyGUI() {
        //border berwarna hitam di panel
        setBorder(BorderFactory.createLineBorder(Color.black));
        posX[0]=10;
        posY[0]=150;
        for (int i=1;i<10;i++){
            if (i==5){
                posX[i]=posX[0];
                posY[i]=posY[0]+120;
            }else{
                posX[i]=posX[i-1]+120;
                posY[i]=posY[i-1];
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(800,600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("roboto", Font.BOLD, 15));
        g.drawString("Hai "+oPlayer.nama+" apa yang akan kamu lakukan?",10,40);
        g.drawString("Level : "+oPlayer.level,10,70);
        g.drawString("Uang  : "+oPlayer.uang,10,90);
        g.drawString("EXP   : "+oPlayer.exp+ "(" + oPlayer.morexp + "exp lagi untuk nail lv)",10,110);

        for (int i=0;i<10;i++){
            g.drawRect(posX[i],posY[i],100,100);
            g.drawString("["+i+"]",posX[i]+3,posY[i]+15);
            if(oPlayer.arrPetak.get(i).islocked){
                g.drawString("Terkunci",posX[i]+20,posY[i]+45);
            }else{
                if (oPlayer.arrPetak.get(i).status==0){
                    g.drawString("Kosong",posX[i]+20,posY[i]+45);
                }else{
                    g.drawString(oPlayer.arrPetak.get(i).tanaman,posX[i]+20,posY[i]+40);
                }
                    if(oPlayer.arrPetak.get(i).status==1){
                    g.drawString(oPlayer.arrPetak.get(i).waktu+"s",posX[i]+40,posY[i]+60);
                }else if (oPlayer.arrPetak.get(i).status==2){
                        g.drawString("(layu)",posX[i]+40,posY[i]+60);
                    }else if (oPlayer.arrPetak.get(i).status==4){
                        g.drawString("(matang)",posX[i]+40,posY[i]+60);
                    }else if (oPlayer.arrPetak.get(i).status==5){
                        g.drawString("mati",posX[i]+40,posY[i]+60);
                    }
            }
        }
    }
}