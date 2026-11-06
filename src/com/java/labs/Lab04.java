package com.java.labs;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab04 {
    public static void main(String[] args){
        List<List<String>> listOfStudents = new ArrayList<>();
        String entry, startOfFile = "Name,ID,Gender";

        try(BufferedReader br = new BufferedReader(new FileReader("Ex3StudentData.csv"))){

            while((entry = br.readLine()) != null){
                
                if(entry.equals(startOfFile)){
                    continue;
                }
                else{
                    String[] studentData = entry.split(",");
                    listOfStudents.add(Arrays.asList(studentData));
                }
            }


        }
        catch(IOException e){
            System.out.println("Can't read file!");
        }
        
        int index = 1;
        
        for(List<String> studentData : listOfStudents){
            
            System.out.printf("================================ #0%d ================================\n", index);
            System.out.printf("\nStudent Name: %s", studentData.get(0));
            System.out.printf("\nStudent ID: %s", studentData.get(1));
            System.out.printf("\nStudent Gender: %s\n\n", studentData.get(2));
            index++;
        }

        System.out.println("================================ END ================================");

    }
    
}
