package com.java.labs;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Lab02 {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int numFiles;
        System.out.print("Enter the amount of files you want created: ");
        numFiles = sc.nextInt();
        sc.nextLine();

        try{
            
            for(int i = 1; i <= numFiles; i++){
                FileWriter fw = new FileWriter("file"+i+".csv");
                double rand = Math.floor(Math.random() * 100) + 1;
                fw.write(rand + "\n");
                fw.close();
            }
            for(int i = 1; i <= numFiles; i++){
                FileReader fr = new FileReader("file"+i+".csv");
                int characters, min, max;
                while((characters = fr.read()) != -1){
                    min = fr.read();
                    System.out.println(min);
                }
            }
            
            

        }
        catch(IOException e){

        }
        sc.close();
    }
}
