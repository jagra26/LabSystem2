package com.company;

import java.util.Scanner;

public class Project {
    String title, fundingAgency, objective, description, status;
    int[][] participants;
    int begin, end, value;
    Publication[] publications;
    Guidance[] guidelines;
    public Project(System labS, String title, String fundingAgency, String objective, String description, int begin, int end, int value,
                   int cases, int login){
        this.title = title;
        this.fundingAgency = fundingAgency;
        this.objective = objective;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.value = value;
        this.participants = new int[5][1000];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j< 1000; j++){
                this.participants[i][j] = 0;
            }
        }
        this.publications = new Publication[100];
        this.guidelines = new Guidance[100];
        this.participants[cases-1][login] = 1;
        this.status = "in preparation";
        int tLog;
        Scanner input = new Scanner(java.lang.System.in);
        if(cases != 2){
            java.lang.System.out.print("insert a teacher login\n");
            tLog = input.nextInt();
            this.addParticipant(labS, this, 2, tLog);
        }

    }
    public void addParticipant(System labS, Project project, int cases, int login) {
        if (project != null && !project.status.equals("in preparation")) {
            boolean free = true;
            switch (cases) {
                case 1:
                    for (int i = 0; i < 100; i++) {
                        if (labS.Researchers[login].projects[i] != null) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        project.participants[cases - 1][login] = 1;
                        for (int i = 0; i < 100; i++) {
                            if (labS.Researchers[login].projects[i] == null) {
                                labS.Researchers[login].projects[i] = project;
                                break;
                            }
                        }
                    } else {
                        java.lang.System.out.print("user not available\n");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 100; i++) {
                        if (labS.Teachers[login].projects[i] != null) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        project.participants[cases - 1][login] = 1;
                        for (int i = 0; i < 100; i++) {
                            if (labS.Teachers[login].projects[i] == null) {
                                labS.Teachers[login].projects[i] = project;
                                break;
                            }
                        }
                    } else {
                        java.lang.System.out.print("user not available\n");
                    }
                    break;
                case 3:
                    for (int i = 0; i < 100; i++) {
                        if (labS.Phds[login].projects[i] != null) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        project.participants[cases - 1][login] = 1;
                        for (int i = 0; i < 100; i++) {
                            if (labS.Phds[login].projects[i] == null) {
                                labS.Phds[login].projects[i] = project;
                                break;
                            }
                        }
                    } else {
                        java.lang.System.out.print("user not available\n");
                    }
                    break;
                case 4:
                    for (int i = 0; i < 100; i++) {
                        if (labS.Masterings[login].projects[i] != null) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        project.participants[cases - 1][login] = 1;
                        for (int i = 0; i < 100; i++) {
                            if (labS.Masterings[login].projects[i] == null) {
                                labS.Masterings[login].projects[i] = project;
                                break;
                            }
                        }
                    } else {
                        java.lang.System.out.print("user not available\n");
                    }
                    break;
                case 5:
                    for (int i = 0; i < 100; i++) {
                        if (labS.Undergraduates[login].projects[i] != null && !labS.Undergraduates[login].projects[i].status.equals("in progress")) {
                            free = false;
                            break;
                        }
                    }
                    if (free) {
                        project.participants[cases - 1][login] = 1;
                        for (int i = 0; i < 100; i++) {
                            if (labS.Undergraduates[login].projects[i] == null) {
                                labS.Undergraduates[login].projects[i] = project;
                                break;
                            }
                        }
                    } else {
                        java.lang.System.out.print("user not available\n");
                    }
                    break;
            }

        }
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void updateStatus(){
        if (this.status.equals("in preparation")){
            this.setStatus("in progress");
        }else{
            for (int i = 0; i<100; i++){
                if (this.publications[i] != null || this.guidelines[i] != null){
                    this.setStatus("completed");
                    break;
                }
            }

        }
    }
    public void newPublication(int cases, int login) {
        if (this != null && !this.status.equals("in progress")) {
            Scanner input = new Scanner(java.lang.System.in);
            String title, conference;
            int year;
            for (int i = 0; i < 100; i++) {
                if (this.publications[i] == null) {
                    java.lang.System.out.print("insert a title, a conference and a year");
                    title = input.nextLine();
                    conference = input.nextLine();
                    year = input.nextInt();
                    this.publications[i] = new Publication(title, conference, cases, login, year);
                }
            }
        }
    }
    public void newGuidance(System labS, int login){
        if (this != null ) {
            for (int i = 0; i < 100; i++) {
                if (this.guidelines[i] == null) {
                    this.guidelines[i] = new Guidance(labS.Teachers[login]);
                }
            }
        }
    }
}
