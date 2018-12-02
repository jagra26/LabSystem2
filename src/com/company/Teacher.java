package com.company;

import java.util.Scanner;

public class Teacher {
    String name;
    String email;
    int login;
    Project[] projects;
    boolean admin;
    public Teacher(String name, String email, int login, boolean admin){
        this.name = name;
        this.email = email;
        this.login = login;
        this.admin = admin;
        this.projects = new Project[1000];
    }
    public void newTeacher(boolean isAdmin, System labS){
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your name:\n");
        String newName = input.nextLine();
        java.lang.System.out.print("insert your email:\n");
        String newEmail = input.nextLine();
        int login=0;
        for (int i = 0; i<1000; i++){
            if(labS.Teachers[i] == null){
                login = i;
                break;
            }
        }
        labS.Teachers[login]= new Teacher(newName, newEmail, login, isAdmin);
        java.lang.System.out.printf("registered successfully\n your login is %d\n", login);
    }
}
}
