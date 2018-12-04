package com.company;

import java.util.Scanner;

public class Lab {
    String name;
    int[][] contributors;
    Project[] projects;
    int size;
    int login;
    public Lab(String name, int cases, int userLogin, int labLogin){
        this.name = name;
        this.login = labLogin;
        this.contributors = new int[5][1000];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j< 1000; j++){
                this.contributors[i][j] = 0;
            }
        }
        this.contributors[cases-1][userLogin] = 1;
        this.projects = new Project[1000];
        this.size = 1;
    }
    public void addContributors(Lab laboratory, int cases, int login){
        laboratory.contributors[cases-1][login] = 1;
        laboratory.size++;
    }

    public void newLab(System labS, int login, int cases){
        java.lang.System.out.print("enter the name of the laboratory:\n");
        Scanner input = new Scanner(java.lang.System.in);
        String name = input.nextLine();
        for (int i = 0; i<1000; i++){
            if (labS.Labs[i] == null){
                labS.Labs[i] = new Lab(name, cases, login, i);
                java.lang.System.out.printf("number of lab is %d\n", i);
                break;
            }
        }
    }
    public void newProject(System labS, Lab laboratory, int cases, int login){
        String title, fundingAgency, objective, description;
        int begin, end, value;
        java.lang.System.out.print("insert a title for the project\n");
        Scanner input = new Scanner(java.lang.System.in);
        title = input.nextLine();
        java.lang.System.out.print("insert the project funding agency\n");
        fundingAgency = input.nextLine();
        java.lang.System.out.print("insert the objective\n");
        objective = input.nextLine();
        java.lang.System.out.print("insert a description\n");
        description = input.nextLine();
        java.lang.System.out.print("enter the start and end year\n");
        begin = input.nextInt();
        end = input.nextInt();
        java.lang.System.out.print("insert the value of project");
        value = input.nextInt();
        for (int i = 0; i< 1000; i++){
            if(laboratory.projects[i] == null){
                laboratory.projects[i] = new Project(labS, title,fundingAgency, objective, description, begin, end, value, cases, login);
                break;
            }
        }
    }
    public void report(Lab laboratory){
        int  st1 = 0, st2 = 0, st3 = 0, pub = 0, gui = 0;
        for (int i = 0; i< 1000; i++){
            if(laboratory.projects[i] != null){
                if (!laboratory.projects[i].status.equals("in preparation")){
                    st1++;
                }else if (!laboratory.projects[i].status.equals("in progress")){
                    st2++;
                    for (int j = 0; j< 100; j++){
                        if (laboratory.projects[i].publications[j] != null){
                            pub++;
                        }
                        if (laboratory.projects[i].guidelines[j] != null){
                            gui++;
                        }
                    }
                }else{
                    st3++;
                    for (int j = 0; j< 100; j++){
                        if (laboratory.projects[i].publications[j] != null){
                            pub++;
                        }
                        if (laboratory.projects[i].guidelines[j] != null){
                            gui++;
                        }
                    }
                }
            }
        }
        java.lang.System.out.printf("-- Laboratory %s --\n", laboratory.name);
        java.lang.System.out.printf("Number of contributors -- %d\n", laboratory.size);
        java.lang.System.out.printf("Number of projects in preparation -- %d\n", st1);
        java.lang.System.out.printf("Number of projects in progress -- %d\n", st2);
        java.lang.System.out.printf("Number of completed projects -- %d\n", st3);
        java.lang.System.out.printf("Total number of projects -- %d\n", st1+st2+st3);
        java.lang.System.out.printf("Number of publications -- %d\n", pub);
        java.lang.System.out.printf("Number of guidelines -- %d\n ", gui);

    }

}
