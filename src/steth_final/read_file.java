/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package steth_final;

import java.io.*;
import java.util.*;

/**
 *
 * @author Hp
 */
public class read_file {
    private Scanner x;
int id_array[] = new int[1000];
int n=0, i, indexInt;
String index;
   public void openFile(){
       try{
           x = new Scanner(new File("heart.txt"));
       }catch(Exception e){
           System.out.println("file not found");
       } 
   }
   
   public void readFile(){
       
       while(x.hasNext()){
           index = x.next();
           //String name = x.next();
           System.out.printf(" %s \n",index);
           //float indexInt = new String(index).toFloat();
          // String s = "123";
           indexInt = Integer.parseInt( index );
            id_array[n] = indexInt;
            n++;
            //index = Integer.toString(indexInt);
       }
       
   }
   
   public void closeFile(){
       x.close();
   }
   
   public void printArray(){
       int k, add;
       System.out.println("printing int array");
       for(k=0;k<n;k++){
           System.out.println(id_array[k]);
           
       }
       add = id_array[1]+id_array[2];
       System.out.printf("element 2 + element 3 = %d\n",add);
   }
}
