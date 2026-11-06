package com.java.labs;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Lab02 {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int amountOfFiles;

        System.out.print("Enter the amount of files you want created: ");
        amountOfFiles = sc.nextInt();
        sc.nextLine();

        try{

            for(int i = 1; i <= amountOfFiles; i++){
                
                FileWriter fw = new FileWriter("file"+i+".csv");
                double rand = Math.floor(Math.random() * 100) + 1;
                
                fw.write(rand + "\n");
                fw.close();
            }

            List<Double> numList = new ArrayList<>();

            for(int i = 1; i <= amountOfFiles; i++){

                BufferedReader fr = new BufferedReader(new FileReader("file"+i+".csv"));
                String numString;

                while((numString = fr.readLine()) != null){
                    double num = Double.parseDouble(numString);
                    numList.add(num);
                }

                fr.close();
            }

            double min = numList.getFirst(), max = numList.getFirst();

            for(int i = 0; i < amountOfFiles - 1; i++){
                if(max <= numList.get(i + 1)){
                    max = numList.get(i + 1);
                }else if(min > numList.get(i + 1)){
                    min = numList.get(i+1);
                }
            }
            System.out.println("\n=====================================================================");
            System.out.printf("Max is: %.0f\n", max);
            System.out.printf("Min is: %.0f\n", min);
            System.out.println("\nHere's the whole list: " + numList);
            System.out.println("=====================================================================");
            
            

        }
        catch(IOException e){
          
        }
        sc.close();
    }
}
