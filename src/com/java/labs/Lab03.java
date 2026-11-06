package com.java.labs;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// class Student{
//     private String stuName;
//     private String stuID;
//     private String stuGender;

//     public void setName(String name){
//         stuName = name;
//     }
//     public void setID(String ID){
//         stuID = ID;
//     }
//     public void setGender(String gender){
//         stuGender = gender;
//     }

//     public String getName(){
//         return stuName;
//     }
//     public String getID(){
//         return stuID;
//     }
//     public String getGender(){
//         return stuGender;
//     }
// }

public class Lab03 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String stuName, stuID, stuGender;
        
        try{

            FileWriter fw = new FileWriter("Ex3StudentData.csv");
            fw.write("Name, ID, Gender\n");

            for(int i = 0; i <= 2; i++){
                
                System.out.println("============================================================");
                System.out.printf("\nEnter the name of student #0%d: ", i + 1);
                stuName = sc.nextLine();
                System.out.printf("Enter the ID of student #0%d: ", i + 1);
                stuID = sc.nextLine();
                System.out.printf("Enter the gender of student #0%d: ", i + 1);
                stuGender = sc.nextLine();
                System.out.println("\n============================================================\n");
                
                fw.append(stuName + ", " + stuID + ", " + stuGender + "\n");        
                
            }

            fw.close();

        } catch (IOException e) {
            
            System.out.println("Unable to write into file.");

        }

        sc.close();

    }
}
