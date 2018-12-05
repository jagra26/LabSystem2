package com.company;

import java.util.Scanner;


public class System {
    Lab[] Labs;
    Researcher[] Researchers;
    Teacher[] Teachers;
    Phd[] Phds;
    Mastering[] Masterings;
    Undergraduate[] Undergraduates;

    public System() {
        this.Labs = new Lab[1000];
        this.Researchers = new Researcher[1000];
        this.Teachers = new Teacher[1000];
        this.Phds = new Phd[1000];
        this.Masterings = new Mastering[1000];
        this.Undergraduates = new Undergraduate[1000];
    }

    public void newResearcher(boolean isAdmin, System labS) {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your name:\n");
        String newName = input.nextLine();
        java.lang.System.out.print("insert your email:\n");
        String newEmail = input.nextLine();
        int login = 0;
        for (int i = 0; i < 1000; i++) {
            if (labS.Researchers[i] == null) {
                login = i;
                break;
            }
        }
        labS.Researchers[login] = new Researcher(newName, newEmail, login, isAdmin);
        java.lang.System.out.printf("registered successfully\n your login is %d\n", login);

    }

    public void newTeacher(boolean isAdmin, System labS) {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your name:\n");
        String newName = input.nextLine();
        java.lang.System.out.print("insert your email:\n");
        String newEmail = input.nextLine();
        int login = 0;
        for (int i = 0; i < 1000; i++) {
            if (labS.Teachers[i] == null) {
                login = i;
                break;
            }
        }
        labS.Teachers[login] = new Teacher(newName, newEmail, login, isAdmin);
        java.lang.System.out.printf("registered successfully\n your login is %d\n", login);
    }

    public void newPhd(boolean isAdmin, System labS) {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your name:\n");
        String newName = input.nextLine();
        java.lang.System.out.print("insert your email:\n");
        String newEmail = input.nextLine();
        int login = 0;
        for (int i = 0; i < 1000; i++) {
            if (labS.Phds[i] == null) {
                login = i;
                break;
            }
        }
        labS.Phds[login] = new Phd(newName, newEmail, login, isAdmin);
        java.lang.System.out.printf("registered successfully\n your login is %d\n", login);
    }

    public void newMastering(boolean isAdmin, System labS) {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your name:\n");
        String newName = input.nextLine();
        java.lang.System.out.print("insert your email:\n");
        String newEmail = input.nextLine();
        int login = 0;
        for (int i = 0; i < 1000; i++) {
            if (labS.Masterings[i] == null) {
                login = i;
                break;
            }
        }
        labS.Masterings[login] = new Mastering(newName, newEmail, login, isAdmin);
        java.lang.System.out.printf("registered successfully\n your login is %d\n", login);
    }

    public void newUndergraduate(boolean isAdmin, System labS) {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your name:\n");
        String newName = input.nextLine();
        java.lang.System.out.print("insert your email:\n");
        String newEmail = input.nextLine();
        int login = 0;
        for (int i = 0; i < 1000; i++) {
            if (labS.Undergraduates[i] == null) {
                login = i;
                break;
            }
        }
        labS.Undergraduates[login] = new Undergraduate(newName, newEmail, login, isAdmin);
        java.lang.System.out.printf("registered successfully\n your login is %d\n", login);
    }

    public void newAdmin(System labS) {
        java.lang.System.out.print("Choose your formation:\n");
        java.lang.System.out.print("Researcher - 1\n");
        java.lang.System.out.print("Teacher - 2\n");
        java.lang.System.out.print("PhD - 3\n");
        java.lang.System.out.print("Mastering - 4\n");
        java.lang.System.out.print("Undergraduate - 5\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        switch (cases) {
            case 1:
                newResearcher(true, labS);
                break;
            case 2:
                newTeacher(true, labS);
                break;
            case 3:
                newPhd(true, labS);
                break;
            case 4:
                newMastering(true, labS);
                break;
            case 5:
                newUndergraduate(true, labS);
                break;
        }


    }

    public void newUser(System labS) {
        java.lang.System.out.print("Choose your formation:\n");
        java.lang.System.out.print("Researcher - 1\n");
        java.lang.System.out.print("Teacher - 2\n");
        java.lang.System.out.print("PhD - 3\n");
        java.lang.System.out.print("Mastering - 4\n");
        java.lang.System.out.print("Undergraduate - 5\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        switch (cases) {
            case 1:
                newResearcher(false, labS);
                break;
            case 2:
                newTeacher(false, labS);
                break;
            case 3:
                newPhd(false, labS);
                break;
            case 4:
                newMastering(false, labS);
                break;
            case 5:
                newUndergraduate(false, labS);
                break;
        }
    }

    public void logon (System labS){
        java.lang.System.out.print("Choose your formation:\n");
        java.lang.System.out.print("Researcher - 1\n");
        java.lang.System.out.print("Teacher - 2\n");
        java.lang.System.out.print("PhD - 3\n");
        java.lang.System.out.print("Mastering - 4\n");
        java.lang.System.out.print("Undergraduate - 5\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        java.lang.System.out.print("insert your login:\n");
        int login = input.nextInt();
        boolean logIn = false;
        boolean isAdm = false;
        switch (cases) {
            case 1:
                if (labS.Researchers[login] != null){
                    java.lang.System.out.printf("welcome %s!\n", labS.Researchers[login].name);
                    logIn = true;
                    isAdm = labS.Researchers[login].admin;
                }else{
                    java.lang.System.out.print("non-existent user\n");
                }
                break;
            case 2:
                if (labS.Teachers[login] != null){
                    java.lang.System.out.printf("welcome %s!\n", labS.Teachers[login].name);
                    logIn = true;
                    isAdm = labS.Teachers[login].admin;
                }else{
                    java.lang.System.out.print("non-existent user\n");
                }
                break;
            case 3:
                if (labS.Phds[login] != null){
                    java.lang.System.out.printf("welcome %s!\n", labS.Phds[login].name);
                    logIn = true;
                    isAdm = labS.Phds[login].admin;
                }else{
                    java.lang.System.out.print("non-existent user\n");
                }
                break;
            case 4:
                if (labS.Masterings[login] != null){
                    java.lang.System.out.printf("welcome %s!\n", labS.Masterings[login].name);
                    logIn = true;
                    isAdm = labS.Masterings[login].admin;
                }else {
                    java.lang.System.out.print("non-existent user\n");
                }
                break;
            case 5:
                if (labS.Undergraduates[login] != null){
                    java.lang.System.out.printf("welcome %s!\n", labS.Undergraduates[login].name);
                    logIn = true;
                    isAdm = labS.Undergraduates[login].admin;
                }else{
                    java.lang.System.out.print("non-existent user\n");
                }
                break;
        }
        while (logIn){
            logIn = !userDisp(labS, cases, login, isAdm);
        }
    }

    public boolean userDisp(System labS, int cases, int login, boolean isAdm){
        boolean logOff = false;
        if (isAdm){
            logOff = adminDisp(labS, cases, login);
        }else{
            logOff = commonDisp(labS, cases, login);
        }
        return logOff;
    }

    public boolean commonDisp(System labS, int cases, int login){
        boolean logOff = false;
        switch (cases){
            case 1:
                logOff = commonRDisp(labS, login);
                break;
            case 2:
                logOff = commonTDisp(labS, login);
                break;
            case 3:
                logOff = commonPDisp(labS, login);
                break;
            case 4:
                logOff = commonMDisp(labS, login);
                break;
            case 5:
                logOff = commonUDisp(labS, login);
                break;
        }
        return logOff;
    }
    public boolean commonRDisp(System labS, int login){
        boolean logOff = false;
        java.lang.System.out.print("select a option:\n");
        java.lang.System.out.print("info - 1 collaborator info - 2 lab report - 3 exit -4\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int number;
        switch (cases){
            case 1:
                labS.Researchers[login].rInfo();
                break;
            case 2:
                break;
            case 3:
                java.lang.System.out.print("insert a lab number\n");
                number = input.nextInt();
                labS.Labs[number].report(labS.Labs[number]);
                break;
            case 4:
                logOff = true;
                break;
        }

        return logOff;
    }

    public boolean commonTDisp(System labS, int login){
        boolean logOff = false;
        java.lang.System.out.print("select a option:\n");
        java.lang.System.out.print("info - 1 collaborator info - 2 lab report - 3 exit -4\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int number;
        switch (cases){
            case 1:
                labS.Teachers[login].tInfo();
                break;
            case 2:
                break;
            case 3:
                java.lang.System.out.print("insert a lab number\n");
                number = input.nextInt();
                labS.Labs[number].report(labS.Labs[number]);
                break;
            case 4:
                logOff = true;
                break;
        }

        return logOff;
    }
    public boolean commonPDisp(System labS, int login){
        boolean logOff = false;
        java.lang.System.out.print("select a option:\n");
        java.lang.System.out.print("info - 1 collaborator info - 2 lab report - 3 exit -4\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int number;
        switch (cases){
            case 1:
                labS.Phds[login].pInfo();
                break;
            case 2:
                break;
            case 3:
                java.lang.System.out.print("insert a lab number\n");
                number = input.nextInt();
                labS.Labs[number].report(labS.Labs[number]);
                break;
            case 4:
                logOff = true;
                break;
        }

        return logOff;
    }
    public boolean commonMDisp(System labS, int login){
        boolean logOff = false;
        java.lang.System.out.print("select a option:\n");
        java.lang.System.out.print("info - 1 collaborator info - 2 lab report - 3 exit -4\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int number;
        switch (cases){
            case 1:
                labS.Masterings[login].mInfo();
                break;
            case 2:
                break;
            case 3:
                java.lang.System.out.print("insert a lab number\n");
                number = input.nextInt();
                labS.Labs[number].report(labS.Labs[number]);
                break;
            case 4:
                logOff = true;
                break;
        }

        return logOff;
    }

    public boolean commonUDisp(System labS, int login){
        boolean logOff = false;
        java.lang.System.out.print("select a option:\n");
        java.lang.System.out.print("info - 1 collaborator info - 2 lab report - 3 exit -4\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int number;
        switch (cases){
            case 1:
                labS.Undergraduates[login].uInfo();
                break;
            case 2:
                break;
            case 3:
                java.lang.System.out.print("insert a lab number\n");
                number = input.nextInt();
                labS.Labs[number].report(labS.Labs[number]);
                break;
            case 4:
                logOff = true;
                break;
        }

        return logOff;
    }


    public  boolean adminDisp(System labS, int cases, int login){
        boolean logOff = false;
        /*switch (cases){
            case 1:
                logOff = adminRDisp(labS, login);
                break;
            case 2:
                logOff = adminTDisp(labS, login);
                break;
            case 3:
                logOff = adminPDisp(labS, login);
                break;
            case 4:
                logOff = adminMDisp(labS, login);
                break;
            case 5:
                logOff = adminUDisp(labS, login);
                break;
        }*/
        return logOff;
    }

    /*public boolean adminRDisp(System labS, int login){

    }
    public boolean adminTDisp(System labS, int login){

    }
    public boolean adminPDisp(System labS, int login){

    }
    public boolean adminMDisp(System labS, int login){

    }
    public boolean adminUDisp(System labS, int login){

    }*/
    public boolean display(System labS) {
        boolean exit = false;
        java.lang.System.out.print("insert your option\n");
        java.lang.System.out.print("New admin - 1\n");
        java.lang.System.out.print("New user - 2\n");
        java.lang.System.out.print("Login - 3\n");
        java.lang.System.out.print("Exit - 4\n");
        Scanner input = new Scanner(java.lang.System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:
                newAdmin(labS);
                break;
            case 2:
                newUser(labS);
                break;
            case 3:
                logon(labS);
                break;
            case 4:
                exit = true;
                break;
        }
        return exit;
    }


}

