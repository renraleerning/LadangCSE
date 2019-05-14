import javax.swing.*;
import java.awt.*;

public class Thread1 extends Thread {
    private  MyGUI gui;

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
    }
    public Thread1(){
    createAndShowGUI();
    }

    private void refresh(){
        f.getContentPane().removeAll();
        //f.getContentPane().invalidate();
        f.getContentPane().add(g);
        f.getContentPane().revalidate();
        f.repaint();
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //oPlayer.level++;
        refresh();
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
        posY[0]=100;
        for (int i=1;i<10;i++){
            if (i==5){
                posX[i]=posX[0];
                posY[i]=220;
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
        g.setFont(new Font("Monospaced", Font.BOLD, 15));
        g.drawString("Hai "+oPlayer.nama+" apa yang akan kamu lakukan?",10,10);
        g.drawString("Level : "+oPlayer.level,10,20);
        g.drawString("Uang  : "+oPlayer.uang,10,30);
        g.drawString("EXP   : "+oPlayer.exp+ "(" + oPlayer.morexp + "exp lagi untuk nail lv)",10,40);

        for (int i=0;i<10;i++){
        g.drawRect(posX[i],posY[i],100,100);
        }
    }
}