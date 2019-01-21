package com.company;

import java.util.ArrayList;

public class Mastering extends People{
    public Mastering(String name, String email, int login, boolean admin){
        super.name = name;
        super.email = email;
        super.login = login;
        super.admin = admin;
        super.type = 4;
        super.publications = new ArrayList<>();
        super.myprojects = new ArrayList<>();
    }

}


