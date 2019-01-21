package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Guidance {
    Teacher masterMind;
    ArrayList<Integer> students;
    public Guidance(Teacher masterMind){
        this.students = new ArrayList<>();
        this.masterMind = masterMind;
        Scanner input =  new Scanner(java.lang.System.in);
        int cases;
        int login;
        while (true){
            java.lang.System.out.print("add your students\n exit - 4\n");

            java.lang.System.out.print("insert the login\n");
            login = input.nextInt();
            if (!this.students.contains(login)) {
                this.students.add(login);
            }else{
                java.lang.System.out.print("This student has already been registered\n");
            }
            java.lang.System.out.print("exit? yes --1 no --2\n");
            cases = input.nextInt();
            if (cases == 1)
            {
                break;
            }
        }
    }

}
