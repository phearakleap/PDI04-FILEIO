package com.java.labs;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Lab02 {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int amountOfFiles;
        List<Double> numList = new ArrayList<>();

        System.out.print("Enter the amount of files you want created: ");
        amountOfFiles = sc.nextInt();
        sc.nextLine();
        sc.close();

        try{
            for(int i = 1; i <= amountOfFiles; i++){
                FileWriter fw = new FileWriter("file"+i+".csv");
                double rand = Math.floor(Math.random() * 100) + 1;
                fw.write(rand + "\n");
                fw.close();
            }

            for(int i = 1; i <= amountOfFiles; i++){
                BufferedReader br = new BufferedReader(new FileReader("file"+i+".csv"));
                String numString;
                while((numString = br.readLine()) != null){
                    double num = Double.parseDouble(numString);
                    numList.add(num);
                }
                br.close();
            }
        }
        catch(IOException e){
            System.out.println("An unexpected error has occured!");
        }

        double min = numList.getFirst(), max = numList.getFirst();
        
        for (int i = 0; i < amountOfFiles - 1; i++){
            if(max <= numList.get(i+1)){
                max = numList.get(i+1);
            }
            if(min > amountOfFiles - 1){
                min = numList.get(i+1);
            }
        }

        System.out.println("\n=================================================================");
        System.out.printf("The maximum number is: %.0f\n", max);
        System.out.printf("The minimum number is: %.0f\n", min);
        System.out.println("\nThe full list: " + numList);
        System.out.println("=================================================================");
    }
}
