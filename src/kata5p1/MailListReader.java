/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
        
public class MailListReader {
    public MailListReader() {
        
    }
    public static List<String> read(String fileName){
        List<String> lista = new ArrayList<>();
        try {
            int check = 0;
            File myObj = new File(fileName);
            try (Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    for (int i = 0; i < data.length(); i++) {
                        if (data.charAt(i) == '@'){
                            check++;
                        }
                        if (data.charAt(i) == '.' & data.charAt(data.length()-1) != '.' & check == 1){
                            lista.add(data);
                        }
                    }
                    check = 0;
                }
            }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
            }
        return lista;
    }
}
