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
        this.projects = new Project[100];
    }

}

