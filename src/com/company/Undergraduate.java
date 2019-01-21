package com.company;

import java.util.ArrayList;

public class Undergraduate extends People {

    public Undergraduate(String name, String email, int login, boolean admin) {
        super.name = name;
        super.email = email;
        super.login = login;
        super.admin = admin;
        super.type = 5;
        super.publications = new ArrayList<>();
        super.myprojects = new ArrayList<>();
    }
}



