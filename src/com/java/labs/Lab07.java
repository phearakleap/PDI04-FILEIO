package com.java.labs;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;

public class Lab07 {

    static class Candidate{
        private String[] groups = {"group A", "group B", "group C", "group D", "group E"};
        private int[] groupCounterTotal = {0,0,0,0,0};
        private int[] groupCounterM = {0,0,0,0,0};
        private int[] groupCounterF = {0,0,0,0,0};
        private String[] entry = new String[10];

        private List<String> groupFiles = Arrays.asList("groupA.csv", "groupB.csv", "groupC.csv", "groupD.csv", "groupE.csv");

        private List<String> groupA = new ArrayList<>();
        private List<String> groupB = new ArrayList<>();
        private List<String> groupC = new ArrayList<>();
        private List<String> groupD = new ArrayList<>();
        private List<String> groupE = new ArrayList<>();

        int total = 0, MTotal = 0, FTotal = 0;
        float MPercent = 0.0f, FPercent = 0.0f;
        
        public void setEntry(String[] entry){
            this.entry = entry;
        }

        public void organizeIntoGroup(String fullEntry){
            if(entry[2].equals("group A")) groupA.add(fullEntry);
            else if(entry[2].equals("group B")) groupB.add(fullEntry);
            else if(entry[2].equals("group C")) groupC.add(fullEntry);
            else if(entry[2].equals("group A")) groupD.add(fullEntry);
            else groupE.add(fullEntry);
        }

        public void countCandidateInGroup(){
            boolean male = (entry[1].equals("male"));
            for(int i = 0; i <= 4; i++){
                if(entry[2].equals(groups[i])){
                    groupCounterTotal[i]++;
                    organizeIntoGroup(Arrays.toString(entry));
                    if(male) groupCounterM[i]++;
                    else groupCounterF[i]++;
                }
            }
        }

        public int[] getGroupCounterTotal(){
            return groupCounterTotal;
        }

        public int[] getGroupCounterM(){
            return groupCounterM;
        }

        public int[] getGroupCounterF(){
            return groupCounterF;
        }

        public void writeIntoGroupFiles(){
            try{
                for(int i = 0; i <= 4; i++){
                    FileWriter fw = new FileWriter(groupFiles.get(i));
                    fw.append("List of candidates with the test scores,,,,,,,,,\n");
                    fw.append("ID,gender,group,Education,\"test preparation\n");
                    fw.append("course\",Math,English,Computer,Total,Average\n");
                    
                    if(groupFiles.get(i).equals("groupA.csv")){
                        for(String entry : groupA) fw.append(entry + "\n");
                    } else if(groupFiles.get(i).equals("groupB.csv")){
                        for(String entry : groupB) fw.append(entry + "\n");
                    } else if(groupFiles.get(i).equals("groupC.csv")){
                        for(String entry : groupC) fw.append(entry + "\n");
                    } else if(groupFiles.get(i).equals("groupD.csv")){
                        for(String entry : groupD) fw.append(entry + "\n");
                    } else {
                        for(String entry : groupE) fw.append(entry + "\n");
                    }
                    
                    fw.append("\nTotal: " + groupCounterTotal[i] + " %male: " + groupCounterM[i]*100.0f/groupCounterTotal[i] + "% %female: " + groupCounterF[i]*100.0f/groupCounterTotal[i]);

                    fw.close();
                }
                
            } catch (IOException e) {
                System.out.println("Can't read or write into File!");
            }
        }

    }

    public static void main(String[] args){

        Candidate cd = new Candidate();
        String line;
        
        try (BufferedReader br = new BufferedReader(new FileReader("CandidatePerformanceTest.csv"))){
            
            while((line = br.readLine()) != null){
                String[] entry = line.split(",");
                if(entry.length < 10) continue;

                cd.setEntry(entry);
                cd.countCandidateInGroup();
            }

            cd.writeIntoGroupFiles();

        } catch (IOException e) {
            System.out.println("Can't Read or Write file!");
        }
            
    }
}
