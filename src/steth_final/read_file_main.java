/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package steth_final;

/**
 *
 * @author Hp
 */
public class read_file_main {

    
    public static void main(String[] args) {
        read_file rf = new read_file();
        rf.openFile();
        rf.readFile();
        rf.closeFile();
        rf.printArray();
    }
}
