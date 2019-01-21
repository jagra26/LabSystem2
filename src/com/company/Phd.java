package com.company;

import java.util.ArrayList;

public class Phd extends People {


    public Phd(String name, String email, int login, boolean admin){
        super.name = name;
        super.email = email;
        super.login = login;
        super.admin = admin;
        super.type = 3;
        super.publications = new ArrayList<>();
        super.myprojects = new ArrayList<>();
    }
    
}
