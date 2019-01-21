package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class System {
    ArrayList<People> users;
    ArrayList<Project> projects;

    public System() {
        this.users = new ArrayList<>();
        this.projects = new ArrayList<>();
    }
    private void newPeople(boolean isAdmin, int type) {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your name:\n");
        String newName = input.nextLine();
        java.lang.System.out.print("insert your email:\n");
        String newEmail = input.nextLine();
        switch (type) {
            case 1:
                Researcher newResearcher = new Researcher(newName, newEmail, this.users.size() - 1, isAdmin);
                this.users.add(newResearcher);
                java.lang.System.out.printf("registered successfully\n your login is %d\n", this.users.indexOf(newResearcher));
                break;
            case 2:
                Teacher newTeacher = new Teacher(newName, newEmail, this.users.size() - 1, isAdmin);
                this.users.add(newTeacher);
                java.lang.System.out.printf("registered successfully\n your login is %d\n", this.users.indexOf(newTeacher));
                break;
            case 3:
                Phd newPhd = new Phd(newName, newEmail, this.users.size()-1, isAdmin);
                this.users.add(newPhd);
                java.lang.System.out.printf("registered successfully\n your login is %d\n", this.users.indexOf(newPhd));
                break;
            case 4:
                Mastering newMastering = new Mastering(newName, newEmail, this.users.size()-1, isAdmin);
                this.users.add(newMastering);
                java.lang.System.out.printf("registered successfully\n your login is %d\n", this.users.indexOf(newMastering));
                break;
            case 5:
                Undergraduate newUndergraduate = new Undergraduate(newName, newEmail, this.users.size()-1, isAdmin);
                this.users.add(newUndergraduate);
                java.lang.System.out.printf("registered successfully\n your login is %d\n", this.users.indexOf(newUndergraduate));
                break;
        }
    }
    private boolean isAdmin(int input){
        if (input == 1){return true;}
        return false;
    }
    private void newUser() {
        java.lang.System.out.print("Choose your formation:\n");
        java.lang.System.out.print("Researcher - 1\n");
        java.lang.System.out.print("Teacher - 2\n");
        java.lang.System.out.print("PhD - 3\n");
        java.lang.System.out.print("Mastering - 4\n");
        java.lang.System.out.print("Undergraduate - 5\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        java.lang.System.out.print("Admin?\n yes -- 1 no -- 2\n");
        int admin = input.nextInt();
        boolean isadmin = isAdmin(admin);
        newPeople(isadmin, cases);
    }
    private void logon (System labS){
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert your login:\n");
        int login = input.nextInt();
        boolean logIn = false;
        boolean isAdm = this.users.get(login).admin;
        while (!logIn){
            logIn = !userDisp(labS, login, isAdm);
        }
    }
    private boolean userDisp(System labS, int login, boolean isAdm){
        boolean logOff = false;
        if (isAdm){
            logOff = adminDisp(labS, login);
        }else{
            logOff = commonUDisp(login);
        }
        return logOff;
    }
    private boolean commonUDisp(int login){
        boolean logOff = false;
        java.lang.System.out.print("select a option:\n");
        java.lang.System.out.print("info - 1 collaborator info - 2 exit - 3\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int number;
        switch (cases){
            case 1:
                this.users.get(login).info();
                break;
            case 2:
                colabInfo();
                break;
            case 3:
                logOff = true;
                break;
        }

        return logOff;
    }
    private  boolean adminDisp(System labS, int login){
        boolean logOff = false;
        if (labS.users.get(login).type == 2){
            logOff = adminTDisp(labS, login);
        }else{
            logOff =adminUDisp(labS, login);
        }
        return logOff;
    }
    private boolean adminTDisp(System labS, int login){
        boolean logOff = false;
        java.lang.System.out.print("select a option:\n");
        java.lang.System.out.print("info - 1\n collaborator info - 2\nnew project - 5\n"+
                "add participants in a project - 7\n update a project status -8\n"+
                "new publication - 9\n  new guidance - 10\n exit - 11\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int newcolab, nLog;
        switch (cases){
            case 1:
                labS.users.get(login).info();
                break;
            case 2:
                colabInfo();
                break;
            case 5:
                java.lang.System.out.print("insert a project title\n");
                String title = input.nextLine();
                java.lang.System.out.print("insert a funding agency\n");
                String fundingAgency = input.nextLine();
                java.lang.System.out.print("Insert a objective\n");
                String objective = input.nextLine();
                java.lang.System.out.print("insert a description\n");
                String description = input.nextLine();
                java.lang.System.out.print("insert a begin (year)\n");
                int begin = input.nextInt();
                java.lang.System.out.print("insert a end (year)\n");
                int end = input.nextInt();
                java.lang.System.out.print("insert a value\n");
                double value = input.nextDouble();
                labS.projects.add(new Project(labS, title, fundingAgency, objective,
                         description, begin, end, value, login));
                break;
            case 7:
                java.lang.System.out.print("insert a project number\n");
                nLog = input.nextInt();
                java.lang.System.out.print("enter the new employee login\n");
                newcolab = input.nextInt();
                if (!this.projects.get(nLog).participants.contains(newcolab)){
                    this.projects.get(nLog).participants.add(newcolab);
                    this.users.get(newcolab).myprojects.add(nLog);
                }else{
                    java.lang.System.out.print("this collaborator already participates in the project\n");
                }
                break;
            case 8:
                java.lang.System.out.print("insert a project number\n");
                nLog = input.nextInt();
                if (this.projects.get(nLog).participants.contains(login)){
                    this.projects.get(nLog).updateStatus();
                }else{
                    java.lang.System.out.print("You do not participate in this project\n");
                }
                break;
            case 9:
                java.lang.System.out.print("insert a project number\n");
                nLog = input.nextInt();
                if (this.projects.get(nLog).participants.contains(login)){
                    this.projects.get(nLog).newPublication(login);
                }else{
                    java.lang.System.out.print("You do not participate in this project\n");
                }
                break;
            case 10:
                java.lang.System.out.print("insert a project number\n");
                nLog = input.nextInt();
                if (this.projects.get(nLog).participants.contains(login)){
                    this.projects.get(nLog).newGuidance(labS, login);
                }else{
                    java.lang.System.out.print("You do not participate in this project\n");
                }
                break;
            case 11:
                logOff = true;
                break;
        }

        return logOff;

    }
    private boolean adminUDisp(System labS, int login){
        boolean logOff = false;
        java.lang.System.out.print("info - 1 collaborator info - 2  new project - 5\n"+
                "add participants in a lab - 6 add participants in a project - 7 update a project status -8\n"+
                "new publication - 9 exit - 10\n");
        Scanner input = new Scanner(java.lang.System.in);
        int cases = input.nextInt();
        int newcolab, nLog;
        switch (cases){
            case 1:
                labS.users.get(login).info();
                break;
            case 2:
                colabInfo();
                break;
            case 5:
                java.lang.System.out.print("insert a project title\n");
                String title = input.nextLine();
                java.lang.System.out.print("insert a funding agency\n");
                String fundingAgency = input.nextLine();
                java.lang.System.out.print("Insert a objective\n");
                String objective = input.nextLine();
                java.lang.System.out.print("insert a description\n");
                String description = input.nextLine();
                java.lang.System.out.print("insert a begin (year)\n");
                int begin = input.nextInt();
                java.lang.System.out.print("insert a end (year)\n");
                int end = input.nextInt();
                java.lang.System.out.print("insert a value\n");
                double value = input.nextDouble();
                labS.projects.add(new Project(labS, title, fundingAgency, objective,
                        description, begin, end, value, login));
                break;
            case 7:
                java.lang.System.out.print("insert a project number\n");
                nLog = input.nextInt();
                java.lang.System.out.print("enter the new employee login\n");
                newcolab = input.nextInt();
                if (!this.projects.get(nLog).participants.contains(newcolab)){
                    this.projects.get(nLog).participants.add(newcolab);
                    this.users.get(newcolab).myprojects.add(nLog);
                }else{
                    java.lang.System.out.print("this collaborator already participates in the project\n");
                }
                break;
            case 8:
                java.lang.System.out.print("insert a project number\n");
                nLog = input.nextInt();
                if (this.projects.get(nLog).participants.contains(login)){
                    this.projects.get(nLog).updateStatus();
                }else{
                    java.lang.System.out.print("You do not participate in this project\n");
                }
                break;
            case 9:
                java.lang.System.out.print("insert a project number\n");
                nLog = input.nextInt();
                if (this.projects.get(nLog).participants.contains(login)){
                    this.projects.get(nLog).newPublication(login);
                }else{
                    java.lang.System.out.print("You do not participate in this project\n");
                }
                break;

            case 10:
                logOff = true;
                break;
        }

        return logOff;

    }
    public boolean display(System labS) {
        boolean exit = false;
        java.lang.System.out.print("insert your option\n");
        java.lang.System.out.print("New user - 1\n");
        java.lang.System.out.print("Login - 2\n");
        java.lang.System.out.print("Exit - 3\n");
        Scanner input = new Scanner(java.lang.System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:
                newUser();
                break;
            case 2:
                logon(labS);
                break;
            case 3:
                exit = true;
                break;
        }
        return exit;
    }
    private void colabInfo(){
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert the login:\n");
        int login = input.nextInt();
        this.users.get(login).info();
        }

}

