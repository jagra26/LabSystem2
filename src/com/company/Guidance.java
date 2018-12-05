package com.company;

import java.util.Scanner;

public class Guidance {
    Teacher masterMind;
    int[][] students;
    public Guidance(Teacher masterMind){
        this.students = new int[3][1000];
        this.masterMind = masterMind;
        Scanner input =  new Scanner(java.lang.System.in);
        int cases;
        int login;
        java.lang.System.out.print("add your students\n PhD - 1 Mastering - 2 Undergraduate -3 exit - 4\n");
        cases = input.nextInt();
        java.lang.System.out.print("insert the login\n");
        login = input.nextInt();
        while (true){
            java.lang.System.out.print("add your students\n PhD - 1 Mastering - 2 Undergraduate -3 exit - 4\n");
            cases = input.nextInt();
            if (cases == 4)
            {
                break;
            }
            java.lang.System.out.print("insert the login\n");
            login = input.nextInt();
            this.students[cases-1][login] = 1;
        }
    }

}
