package com.java.labs;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lab05 {
    public static void main(String[] args){

        //reused code from previous file
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

        String[] stu1 = {"sarak", "8009", "M"};
        String[] stu2 = {"panhaseth", "1009", "M"};
        String[] stu3 = {"sophal", "6767", "M"};

        listOfStudents.add(Arrays.asList(stu1));
        listOfStudents.add(Arrays.asList(stu2));
        listOfStudents.add(Arrays.asList(stu3));

        /*
        New stuff so just explaining here for my sake:
        - Comparators are objects that allow us to pass in two items and order it in any manner
        - By default, comparators can't compare a list of lists, therefore we need to use a helper
          comparator by calling its method: .comparing()
        - .comparing() allows us to pass in additional arguments to access the keys of the inner list.
        - this allows us to sort BASED ON a chosen key in the inner list, the key here being the first index (student name)
        */
        listOfStudents.sort(Comparator.comparing(name -> name.get(0), String.CASE_INSENSITIVE_ORDER));
        
        try(FileWriter fw = new FileWriter("Ex3StudentData.csv")){
            
            for(List<String> line : listOfStudents){
            
                fw.append(line.get(0) + ",");
                fw.append(line.get(1) + ",");
                fw.append(line.get(2) + "\n");
            
            }

        }
        catch(IOException e){
            System.out.println("Can't write into file!");
        }
    }
    
}
