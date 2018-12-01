package com.company;

import java.util.Scanner;

public class System {
    Lab[] Labs;
    Researcher[] Researchers;
    Teacher[] Teachers;
    Phd[] Phds;
    Mastering[] Masterings;
    Undergraduate[] undergraduates;
    public void newAdmin(){
        java.lang.System.out.print("Choose your formation:\n");
        java.lang.System.out.print("Researcher - 1\n");
        java.lang.System.out.print("Teacher - 2\n");
        java.lang.System.out.print("PhD - 3\n");
        java.lang.System.out.print("Mastering - 4\n");
        java.lang.System.out.print("Undergraduate - 5\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        switch (cases){
            case 1:
                newResearcher(true);
                break;
            case 2:
                newTeacher(true);
                break;
            case 3:
                newPhd(true);
                break;
            case 4:
                newMastering(true);
                break;
            case 5:
                newUndergraduate(true);
                break;
        }


    }

}
