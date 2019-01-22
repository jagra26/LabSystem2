package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
        try {
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
        }catch (InputMismatchException e){
            java.lang.System.out.print("incorrect input\n");
            newUser();
        }
    }
    private void logon (System labS){
        try {
            Scanner input = new Scanner(java.lang.System.in);
            java.lang.System.out.print("insert your login:\n");
            int login = input.nextInt();
            boolean logIn = false;
            boolean isAdm = this.users.get(login).admin;
            while (!logIn) {
                logIn = !userDisp(labS, login, isAdm);
            }
        }catch (InputMismatchException e){
            java.lang.System.out.print("incorrect input\n");
            logon(labS);
        }catch (IndexOutOfBoundsException e){
            java.lang.System.out.print("user not registred\n");
            logon(labS);
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
        try {
            boolean logOff = false;
            java.lang.System.out.print("select a option:\n");
            java.lang.System.out.print("info - 1 \ncollaborator info - 2 \nlab info - 3\n" +
                    "project search - 4\nexit - 5\n");
            Scanner input = new Scanner(java.lang.System.in);
            int cases = input.nextInt();
            switch (cases) {
                case 1:
                    this.users.get(login).info(this);
                    break;
                case 2:
                    colabInfo();
                    break;
                case 3:
                    labInfo();
                    break;
                case 4:
                    projectInfo();
                    break;
                case 5:
                    logOff = true;
                    break;
            }
            return logOff;
        }catch (InputMismatchException e) {
            java.lang.System.out.print("incorrect input\n");
            return commonUDisp(login);
        }
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
        java.lang.System.out.print("info - 1\n collaborator info - 2\nnew project - 3\n"+
                "add participants in a project - 4\n update a project status -5\n"+
                "new publication - 6\n  new guidance - 7\n lab info - 8\n" +
                "project search - 9 exit - 10\n");
        Scanner input = new Scanner(java.lang.System.in);
        try {
            int cases = input.nextInt();
            int newcolab, nLog;
            switch (cases) {
                case 1:
                    labS.users.get(login).info(this);
                    break;
                case 2:
                    colabInfo();
                    break;
                case 3:
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
                case 4:
                    java.lang.System.out.print("insert a project number\n");
                    nLog = input.nextInt();
                    java.lang.System.out.print("enter the new employee login\n");
                    newcolab = input.nextInt();
                    if (!this.projects.get(nLog).participants.contains(newcolab)) {
                        this.projects.get(nLog).participants.add(newcolab);
                        this.users.get(newcolab).myprojects.add(nLog);
                    } else {
                        java.lang.System.out.print("this collaborator already participates in the project\n");
                    }
                    break;
                case 5:
                    java.lang.System.out.print("insert a project number\n");
                    nLog = input.nextInt();
                    if (this.projects.get(nLog).participants.contains(login)) {
                        this.projects.get(nLog).updateStatus();
                    } else {
                        java.lang.System.out.print("You do not participate in this project\n");
                    }
                    break;
                case 6:
                    java.lang.System.out.print("insert a project number\n");
                    nLog = input.nextInt();
                    if (this.projects.get(nLog).participants.contains(login)) {
                        this.projects.get(nLog).newPublication(login, this);
                    } else {
                        java.lang.System.out.print("You do not participate in this project\n");
                    }
                    break;
                case 7:
                    java.lang.System.out.print("insert a project number\n");
                    nLog = input.nextInt();
                    if (this.projects.get(nLog).participants.contains(login)) {
                        this.projects.get(nLog).newGuidance(labS, login);
                    } else {
                        java.lang.System.out.print("You do not participate in this project\n");
                    }
                    break;
                case 8:
                    labInfo();
                    break;
                case 9:
                    projectInfo();
                    break;
                case 10:
                    logOff = true;
                    break;
            }
            return logOff;
        }catch (InputMismatchException e) {
            java.lang.System.out.print("incorrect input\n");
            return adminTDisp(labS, login);
        }catch (IndexOutOfBoundsException e){
            java.lang.System.out.print("project not registred\n");
            return adminTDisp(labS, login);
        }
    }
    private boolean adminUDisp(System labS, int login){
        try {
            boolean logOff = false;
            java.lang.System.out.print("info - 1\ncollaborator info - 2  \nnew project - 3\n" +
                    "add participants in a project - 4 \nupdate a project status -5\n" +
                    "new publication - 6 \nlab info - 7\n project search - 8\nexit - 9\n");
            Scanner input = new Scanner(java.lang.System.in);
            int cases = input.nextInt();
            int newcolab, nLog;
            switch (cases) {
                case 1:
                    labS.users.get(login).info(this);
                    break;
                case 2:
                    colabInfo();
                    break;
                case 3:
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
                case 4:
                    java.lang.System.out.print("insert a project number\n");
                    nLog = input.nextInt();
                    java.lang.System.out.print("enter the new employee login\n");
                    newcolab = input.nextInt();
                    if (!this.projects.get(nLog).participants.contains(newcolab)) {
                        this.projects.get(nLog).participants.add(newcolab);
                        this.users.get(newcolab).myprojects.add(nLog);
                    } else {
                        java.lang.System.out.print("this collaborator already participates in the project\n");
                    }
                    break;
                case 5:
                    java.lang.System.out.print("insert a project number\n");
                    nLog = input.nextInt();
                    if (this.projects.get(nLog).participants.contains(login)) {
                        this.projects.get(nLog).updateStatus();
                    } else {
                        java.lang.System.out.print("You do not participate in this project\n");
                    }
                    break;
                case 6:
                    java.lang.System.out.print("insert a project number\n");
                    nLog = input.nextInt();
                    if (this.projects.get(nLog).participants.contains(login)) {
                        this.projects.get(nLog).newPublication(login, this);
                    } else {
                        java.lang.System.out.print("You do not participate in this project\n");
                    }
                    break;
                case 7:
                    labInfo();
                    break;
                case 8:
                    projectInfo();
                    break;
                case 9:
                    logOff = true;
                    break;
            }
            return logOff;
        }catch (InputMismatchException e) {
            java.lang.System.out.print("incorrect input\n");
            return adminUDisp(labS, login);
        }catch (IndexOutOfBoundsException e){
            java.lang.System.out.print("project not registred\n");
            return adminUDisp(labS, login);
        }
    }
    public boolean display(System labS) {
        try {
            boolean exit = false;
            java.lang.System.out.print("insert your option\n");
            java.lang.System.out.print("New user - 1\n");
            java.lang.System.out.print("Login - 2\n");
            java.lang.System.out.print("Exit - 3\n");
            Scanner input = new Scanner(java.lang.System.in);
            int choice = input.nextInt();
            switch (choice) {
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
        }catch (InputMismatchException e){
            java.lang.System.out.print("incorrect input \n");
            return display(labS);
        }
    }
    private void colabInfo() {
        try {
            Scanner input = new Scanner(java.lang.System.in);
            java.lang.System.out.print("insert the login:\n");
            int login = input.nextInt();
            this.users.get(login).info(this);
        }catch (InputMismatchException e){
            java.lang.System.out.print("incorrect input\n");
            colabInfo();
        }catch (IndexOutOfBoundsException e){
            java.lang.System.out.print("user not registred\n");
            colabInfo();
        }
    }
    private void projectInfo(){
        try {
            Scanner input = new Scanner(java.lang.System.in);
            java.lang.System.out.print("insert a project number");
            int number = input.nextInt();
            java.lang.System.out.print("participants \n");
            for (Integer colab :
                    this.projects.get(number).participants) {
                java.lang.System.out.print(this.users.get(colab).name + "\n");
            }
            java.lang.System.out.print("publications\n");
            for (Publication publication :
                    this.projects.get(number).publications) {
                java.lang.System.out.print(publication);
            }
        }catch (InputMismatchException e){
            java.lang.System.out.print("incorrect input\n");
            projectInfo();
        }catch (IndexOutOfBoundsException e){
            java.lang.System.out.print("project not registred\n");
            projectInfo();
        }
    }
    private void labInfo(){
        java.lang.System.out.print("number of employees: "+this.users.size() +"\n");
        int inPreparation = 0, inProgress = 0, completed = 0;
        int publication = 0, guidance = 0;
        for (int i = 0; i <this.projects.size() ; i++) {
            if (this.projects.get(i).status.equals("in preparation")){
                inPreparation++;
            }else if(this.projects.get(i).status.equals("in progress")){
                inProgress++;
            }else{
                completed++;
            }
            publication += this.projects.get(i).publications.size();
            guidance += this.projects.get(i).guidelines.size();
        }
        java.lang.System.out.print("projects in preparation: "+ inPreparation + "\n" +
        "projects in progress: " + inProgress + "\n" + "projects completed: " + completed + "\n");
        java.lang.System.out.print("total of projects: " + this.users.size() + "\n");
        java.lang.System.out.print("total of publications: " + publication +"\n" +
        "total of guidelines: " + guidance + "\n");

    }

}

