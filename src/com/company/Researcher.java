package com.company;

import java.util.ArrayList;

public class Researcher extends People {

    public Researcher(String name, String email, int login, boolean admin) {
        super.name = name;
        super.email = email;
        super.admin = admin;
        super.login = login;
        super.publications = new ArrayList<>();
        super.myprojects = new ArrayList<>();
        super.type = 1;
    }
    
}
