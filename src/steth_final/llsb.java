/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package steth_final;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.io.File;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class llsb extends JPanel {

// the heart beat data array taken from serial communication
    
    static int data[] = new int[500];
   
    
    int k,n,j,total,i;
    private Scanner x;
    
    public void getReadings(){
        
        try{
           x = new Scanner(new File("triscupid.txt"));
       }catch(Exception e){
           System.out.println("file not found");
       } 
    }
    
    public void readFile(){
       
       while(x.hasNext()){
           String sample = x.next();
           //String name = x.next();
           //System.out.printf(" %s\n",sample);
           //float indexInt = new String(index).toFloat();
          // String s = "123";
           int sampleInt = Integer.parseInt( sample );
            data[n] = sampleInt;
            
            n++;
            if(n==500){
                break;
            }
            if(data[n]==0 && data[n-1]==0){
                break;
            }
            
            
            //index = Integer.toString(indexInt);
       }
            //total = n;
            //System.out.println("total ="+total);
       
               
   }
               
   
    public void closeFile(){
       x.close();
   }
    /*public void printArray(){
       int k;
       
       System.out.println("printing data array");
       for(k=0;k<n;k++){
           System.out.printf("%d: %d\t",k+1,data[k]);
           
       }
       System.out.println("\n");
       //System.out.println("array length: " +n);
       //System.out.println("data 490: " +data[489]);
       System.out.println("upfijdsfjsdfjdsk;lfjdshfioheofhkldsnflksdkfdata  " +data[150]);
   }
   */
 
    
          
      
    final int PAD = 10;  /*To declare a constant, use the final keyword before the variable declaration and include
                          an initial value for that variable*/
    int tot=450;
    public void paintComponent(Graphics g) {
        
        
       // System.out.println("this is paintcomponent");
       // System.out.println("downijdsfjsdfjdsk;lfjdshfioheofhkldsnflksdkfdata  " +data[22]);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // Draw ordinate. (Y cordinate)
       g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        //System.out.println("this is paintcomponent");
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h/2, w-PAD, h/2));
        // Draw labels.
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        float sh = lm.getAscent() + lm.getDescent();
        // Ordinate label.
        String s = "dB";
        float sy = PAD + ((h - 2*PAD) - s.length()*sh)/2 + lm.getAscent();
        for(i = 0; i < s.length(); i++) {
            String letter = String.valueOf(s.charAt(i));
            float sw = (float)font.getStringBounds(letter, frc).getWidth();
            float sx = (PAD - sw)/2;
            g2.drawString(letter, sx, sy);
            sy += sh;
        }
        // Abcissa label.
        s = "time";
        sy = h - PAD + (PAD - sh)/2 + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = (w - sw)/2;
        g2.drawString(s, sx, sy);
        // Draw lines.
        total = 450;
        double xInc = (double)(w - 2*PAD)/(data.length-1);
        double scale = (double)(h - 2*PAD)/getMax();
        g2.setPaint(Color.BLUE);
       // System.out.println("this is paintcomponent");
       // System.out.println("xInc: " +xInc);
       // System.out.println("scale: " +scale);
       // System.out.println("total: " +total);
       // System.out.println("max" +getMax());
        
        for(int i = 0; i < data.length-1; i++) {
           // System.out.println("this is paintcomponent");
            double x1 = PAD + i*xInc;
          //  System.out.print("  x1 val: " +x1);
            double y1 = h - PAD - scale*data[i];
          //  System.out.print("  y1 val: " +y1);
            double x2 = PAD + (i+1)*xInc;
          //  System.out.print("  x2 val: " +x2);
            double y2 = h - PAD - scale*data[i+1];
         //   System.out.println("  y2 val: " +y2);
            g2.draw(new Line2D.Double(x1 , y1, x2, y2));
            
        }
        // Mark data points.
       // g2.setPaint(Color.BLACK);
        //for(int i = 0; i < total; i++) {
         //   double x = PAD + i*xInc;
         //   double y = h - PAD - scale*data[i];
         //   g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
       // }
    }

    private int getMax() {
        readings getvalue = new readings();
       // int max = -Integer.MAX_VALUE;
        int max = 100;
        for(int i = 0; i < data.length; i++) {
            
            
           // System.out.println("this is getMax kfskdfjif ");
           // System.out.println(data[i]);
            if(data[i] > max)
                max = data[i];
        }
        return max;
    }

    public static void main(String[] args) {
       //int j;
       //for(j=0;j<2;j++){
           
       //}
        llsb getvalue = new llsb();
        getvalue.getReadings();
        getvalue.readFile();
        getvalue.closeFile();
       // getvalue.printArray();
        initComponents();
    }

    public static void initComponents(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.add(new llsb());
        f.setSize(800,150);
        f.setLocation(570,330);
        f.setVisible(true);
        f.setTitle("Triscupid Waveform");
    }
}