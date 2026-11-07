package com.java.labs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab06 {
    public static void main(String[] args){
        
        int MCount = 0, FCount = 0, totalCount = 0;
        int avg90Count = 0, avg90MCount = 0, avg90FCount = 0;
        int totalAll85Count = 0;
        String[] groups = {"group A", "group B", "group C", "group D", "group E"};
        int[] groupCountTotal = {0,0,0,0,0}; //each element corresponds to the groups above
        int[] groupCountM = {0,0,0,0,0};
        int[] groupCountF = {0,0,0,0,0};

        String line;

        try(BufferedReader br = new BufferedReader(new FileReader("CandidatePerformanceTest.csv"))){
            while((line = br.readLine()) != null){
                
                String[] entry = line.split(",");
                
                //skips the first few lines.
                if(entry.length < 10) continue;
                else totalCount++;
                
                //calculating avg.
                float sum = 0.0f, avg = 0.0f;
                for(int i = 5; i <= 9; i++){ // 5-9 are the indices of the marks.
                    sum += Float.parseFloat(entry[i]);
                }
                avg = sum/5.0f;

                boolean male = (entry[1].equals("male"));   //added this so that conditions are easier to read.

                if(male) MCount++;
                else FCount++;

                if(avg>=90){
                    avg90Count++;
                    if(male) avg90MCount++;
                    else avg90FCount++;
                }

                int subjectsWith85 = 0;
                for(int i = 5; i <= 9; i++){
                    if(Float.parseFloat(entry[i]) >= 85.0f) subjectsWith85++;
                    if(subjectsWith85 == 5) totalAll85Count++;
                }
                for (int i = 0; i <= 4; i++){
                    if(entry[2].equals(groups[i])){
                        groupCountTotal[i]++;
                        if(male) groupCountM[i]++;
                        else groupCountF[i]++;
                    }
                }
            }
        }
        catch(IOException e){
            System.out.println("Can't Read File!");
        }

        System.out.println("===================================== CANDIDATE STATISTICS =====================================");
        
        System.out.printf("\nTotal candidates: %d\n", totalCount);
        System.out.printf("\t+ Percentage of male candidates: %.2f\n", MCount*100.0f/totalCount);
        System.out.printf("\t+ Percentage of female candidates: %.2f\n", FCount*100.0f/totalCount);

        System.out.printf("\nTotal candidates that scored at least a 90 on average: %d\n", avg90Count);
        System.out.printf("\t+ Percentage of male candidates who scored 90 and above: %.2f\n", avg90MCount*100.0f/totalCount);
        System.out.printf("\t+ Percentage of female candidates who scored 90 and above: %.2f\n", avg90FCount*100.0f/totalCount);

        System.out.printf("\nTotal candidates that scored at least 85 for all subjects: %d\n", totalAll85Count);

        int index = 0;

        for(String group : groups){
            System.out.printf("\nTotal candidates in %s: %d\n", group, groupCountTotal[index]);
            System.out.printf("\t+ Percentage of male candidates in %s: %.2f\n", group, groupCountM[index]*100.0f/groupCountTotal[index]);
            System.out.printf("\t+ Percentage of female candidates in %s: %.2f\n", group, groupCountF[index]*100.0f/groupCountTotal[index]);
            index++;
        }

        System.out.println("\n==================================== END OF STATISCAL REPORT ===================================");

    }
}
