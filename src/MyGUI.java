import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class MyGUI extends JPanel {
    //lokasi gambar gui
    String alamat = "D:\\Github\\LadangCSE\\asset\\resize\\";
    private BufferedImage image;
    private String lokasiBackground = alamat+"Background.jpg";
    private String lokasiMatang = alamat+"Shiny.png";
    private String lokasiDead = alamat+"dead.png";
    private String lokasiHama = alamat+"hama.png";
    private String lokasiLayu = alamat+"water.png";
    private String lokasiFileKol = alamat+"cabbage - Copy.png";
    private String lokasiFileNanas = alamat+"pineapple - Copy.png";
    private String lokasiFileCabai = alamat+"chili - Copy.png";
    private String lokasiFileLabu = alamat+"pumpkin - Copy.png";
    private String lokasiFileLobak = alamat+"radish - Copy.png";
    private String lokasiFileAlmond = alamat+"almond - Copy.png";
    private String lokasiFileMete = alamat+"cashew - Copy.png";
    private String lokasiFileTauge = alamat+"tauge - Copy.png";
    private String lokasiFilePadi = alamat+"padi - Copy.png";
    private String lokasiFileMelon = alamat+"melon - Copy.png";
    private String lokasiFileBuncis = alamat+"buncis - Copy.png";
    private String lokasiFilePear = alamat+"pear - Copy.png";
    private String lokasiFileTomat = alamat+"tomato - Copy.png";
    private String lokasiFilePeach = alamat+"peach - Copy.png";
    private String lokasiFileJamur = alamat+"jamur - Copy.png";
    private String lokasiFileApel = alamat+"apel - Copy.png";
    private String lokasiFilePaprika = alamat+"paprika - Copy.png";
    private String lokasiFileLemon = alamat+"lemon - Copy.png";
    private String lokasiFileJeruk = alamat+"orange - Copy.png";
    private String lokasiFileJambu = alamat+"guava - Copy.png";
    private String lokasiFileKiwi = alamat+"kiwi - Copy.png";
    private String lokasiFileAloe = alamat+"aloevera - Copy.png";
    private String lokasiFileWortel = alamat+"carrot - Copy.png";
    private String lokasiFileCeri = alamat+"cherry - Copy.png";
    private String lokasiFileMangga = alamat+"mango - Copy.png";
    private String lokasiFileManggis = alamat+"mangosteen - Copy.png";
    private String lokasiFileLeci = alamat+"lychee - Copy.png";
    private String lokasiFileDurian = alamat+"durian - Copy.png";
    private String lokasiFileSunkist = alamat+"sunkist - Copy.png";
    private String lokasiFileBit = alamat+"beet - Copy.png";
    private String lokasiFileZaitun = alamat+"olive - Copy.png";
    private String lokasiFileKurma = alamat+"kurma - Copy.png";
    //untuk notice expup, moneyget, expget
    public int lvnow,l,expget,expnow,e,moneyget,moneynow,m;
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
        return new Dimension(500,400);
    }
    void changefontB(Graphics g){
        g.setFont(new Font("roboto", Font.BOLD, 20));
    }
    void changefontN(Graphics g){
        g.setFont(new Font("roboto", Font.BOLD, 15));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
            try{
                image = ImageIO.read(new File(lokasiBackground));
            }catch (IOException ex){
                //handle exception..
                System.out.println("Error load file!!");
            }
            g.drawImage(image, 0, 0, 800, 600, this);

        changefontN(g);
        g.drawString("Hai "+oPlayer.nama+" apa yang akan kamu lakukan?",10,40);


        //event naik level
        if (l>0){
            l--;
            g.drawString("Level : "+lvnow+" (lv up to "+oPlayer.level+" )",10,70);
        }else{
            g.drawString("Level : "+oPlayer.level,10,70);
        }

        //event uang bertambah
        changefontB(g);
        if (m>0){
            m--;
            g.drawString("Uang  : "+moneynow+" ( "+moneyget+" )",10,90);
        }else{
            g.drawString("Uang  : "+oPlayer.uang,10,90);
        }
        changefontN(g);
        //event exp bertambah
        if (e>0){
            e--;
            g.drawString("EXP   : "+expnow+" (+ "+expget+" )",10,110);
        }else{
            g.drawString("EXP   : "+oPlayer.exp+ " ( " + oPlayer.morexp + " exp lagi untuk nail lv)",10,110);
        }
        //print perabot yang dipunya
        g.drawString("Perabot yang dipunya : ",50, 400);
        int y=420;
        for (Perabot P: oPlayer.arrPerabot) {
            if (P.jumlahPerabot==1){
                g.drawString("- "+P.nama,50, y);
                y=y+15;
            }
        }
        //print item yang dipunya
        g.drawString("Item yang dipunya : ",390, 420);
        y=435;
        for (Item I: oPlayer.arrItem) {
            if (I.jumlahItem>0){
                g.drawString("- "+I.nama+" ("+I.jumlahItem+" buah)",390, y);
                y=y+15;
            }
        }

        for (int i=0;i<10;i++){
            g.drawRect(posX[i],posY[i],100,100);

            if(oPlayer.arrPetak.get(i).islocked){
                g.drawString("Terkunci",posX[i]+20,posY[i]+30);
                g.drawString(oPlayer.arrPetak.get(i).harga+" $",posX[i]+30,posY[i]+50);
                g.drawString("Unlock Lv "+oPlayer.arrPetak.get(i).bataslv,posX[i]+5,posY[i]+70);
            }else{
                if (oPlayer.arrPetak.get(i).status==0){
                    g.drawString("Kosong",posX[i]+20,posY[i]+45);
                }else{
                    if (oPlayer.arrPetak.get(i).tanaman.equals("kol")){
                        try{
                            image = ImageIO.read(new File(lokasiFileKol));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("nanas")){
                        try{
                            image = ImageIO.read(new File(lokasiFileNanas));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("cabai")){
                        try{
                            image = ImageIO.read(new File(lokasiFileCabai));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("labu")){
                        try{
                            image = ImageIO.read(new File(lokasiFileLabu));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("lobak")){
                        try{
                            image = ImageIO.read(new File(lokasiFileLobak));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("almond")){
                        try{
                            image = ImageIO.read(new File(lokasiFileAlmond));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("mete")){
                        try{
                            image = ImageIO.read(new File(lokasiFileMete));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("tauge")){
                        try{
                            image = ImageIO.read(new File(lokasiFileTauge));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("padi")){
                        try{
                            image = ImageIO.read(new File(lokasiFilePadi));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("melon")){
                        try{
                            image = ImageIO.read(new File(lokasiFileMelon));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("buncis")){
                        try{
                            image = ImageIO.read(new File(lokasiFileBuncis));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("pear")){
                        try{
                            image = ImageIO.read(new File(lokasiFilePear));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("tomat")){
                        try{
                            image = ImageIO.read(new File(lokasiFileTomat));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("peach")){
                        try{
                            image = ImageIO.read(new File(lokasiFilePeach));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("jamur")){
                        try{
                            image = ImageIO.read(new File(lokasiFileJamur));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("apel")){
                        try{
                            image = ImageIO.read(new File(lokasiFileApel));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("paprika")){
                        try{
                            image = ImageIO.read(new File(lokasiFilePaprika));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("lemon")){
                        try{
                            image = ImageIO.read(new File(lokasiFileLemon));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("jeruk")){
                        try{
                            image = ImageIO.read(new File(lokasiFileJeruk));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("jambu")){
                        try{
                            image = ImageIO.read(new File(lokasiFileJambu));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("kiwi")){
                        try{
                            image = ImageIO.read(new File(lokasiFileKiwi));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("aloe")){
                        try{
                            image = ImageIO.read(new File(lokasiFileAloe));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("wortel")){
                        try{
                            image = ImageIO.read(new File(lokasiFileWortel));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("ceri")){
                        try{
                            image = ImageIO.read(new File(lokasiFileCeri));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("mangga")){
                        try{
                            image = ImageIO.read(new File(lokasiFileMangga));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("manggis")){
                        try{
                            image = ImageIO.read(new File(lokasiFileManggis));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("leci")){
                        try{
                            image = ImageIO.read(new File(lokasiFileLeci));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("durian")){
                        try{
                            image = ImageIO.read(new File(lokasiFileDurian));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("sunkist")){
                        try{
                            image = ImageIO.read(new File(lokasiFileSunkist));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("bit")){
                        try{
                            image = ImageIO.read(new File(lokasiFileBit));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("zaitun")){
                        try{
                            image = ImageIO.read(new File(lokasiFileZaitun));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }else if (oPlayer.arrPetak.get(i).tanaman.equals("kurma")){
                        try{
                            image = ImageIO.read(new File(lokasiFileKurma));
                        }catch (IOException ex){
                            //handle exception..
                            System.out.println("Error load file!!");
                        }
                        g.drawImage(image, posX[i], posY[i], 100, 100, this);
                    }
                }

                //print status petak
                if(oPlayer.arrPetak.get(i).status==1){//gambar waktu
                    g.drawString(oPlayer.arrPetak.get(i).waktu+"s",posX[i]+40,posY[i]+60);
                }else if (oPlayer.arrPetak.get(i).status==2){//gambar layu
                    g.drawString("(layu)",posX[i]+40,posY[i]+60);
                    try{
                        image = ImageIO.read(new File(lokasiLayu));
                    }catch (IOException ex){
                        //handle exception..
                        System.out.println("Error load file!!");
                    }
                    g.drawImage(image, posX[i], posY[i], 50, 50, this);
                }else if (oPlayer.arrPetak.get(i).status==3){//gambar terkena hama
                g.drawString("(hama)",posX[i]+40,posY[i]+60);
                try{
                    image = ImageIO.read(new File(lokasiHama));
                }catch (IOException ex){
                    //handle exception..
                    System.out.println("Error load file!!");
                }
                g.drawImage(image, posX[i], posY[i], 100, 100, this);
                }else if (oPlayer.arrPetak.get(i).status==4){//gambar matang
                    g.drawString("(matang)",posX[i]+15,posY[i]+60);
                    try{
                        image = ImageIO.read(new File(lokasiMatang));
                    }catch (IOException ex){
                        //handle exception..
                        System.out.println("Error load file!!");
                    }
                }else if (oPlayer.arrPetak.get(i).status==5){//gambar mati
                    g.drawString("mati",posX[i]+40,posY[i]+60);
                    try{
                        image = ImageIO.read(new File(lokasiDead));
                    }catch (IOException ex){
                        //handle exception..
                        System.out.println("Error load file!!");
                    }
                    g.drawImage(image, posX[i], posY[i], 90, 90, this);

                }
            }
            //print nomor ladang
            g.drawString("["+i+"]",posX[i]+3,posY[i]+15);
        }
    }
}