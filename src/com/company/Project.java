package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Project {
    String title, fundingAgency, objective, description, status;
    ArrayList<Integer> participants;
    int begin, end;
    double value;
    ArrayList<Publication> publications;
    ArrayList<Guidance> guidelines;
    public Project(System labS, String title, String fundingAgency, String objective, String description, int begin, int end, double value,
                   int login){
        this.title = title;
        this.fundingAgency = fundingAgency;
        this.objective = objective;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.value = value;
        this.participants = new ArrayList<>();
        this.publications = new ArrayList<>();
        this.guidelines = new ArrayList<>();
        this.participants.add(login);
        this.status = "in preparation";
        int tLog;
        Scanner input = new Scanner(java.lang.System.in);
        if(labS.users.get(login).type != 2){
            int stop = 0;
            while (stop != 2){
                java.lang.System.out.print("insert a login\n");
                tLog = input.nextInt();
                stop = this.addParticipant(labS, this, tLog);
            }

        }

    }
    public int addParticipant(System labS, Project project, int login) {
        if (!project.participants.contains(login) && !project.status.equals("in preparation")) {
            project.participants.add(login);
            return labS.users.get(login).type;
        }else{
            java.lang.System.out.print("this user is already participating in the project or the project is in preparation\n");
            return -1;
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void updateStatus(){
        if (this.status.equals("in preparation")){
            this.setStatus("in progress");
            java.lang.System.out.print("Now, the status is in progress\n");
        }else{
            if (!this.publications.isEmpty() || !this.guidelines.isEmpty()){
                this.setStatus("completed");
                java.lang.System.out.print("Now, the status is completed\n");
            }else{
                java.lang.System.out.print("this project has no publications\n");
            }
        }
    }
    public void newPublication(int login) {
        Scanner input = new Scanner(java.lang.System.in);
        java.lang.System.out.print("insert a title, a conference and a year");
        String title = input.nextLine();
        String conference = input.nextLine();
        int year = input.nextInt();
        this.publications.add(new Publication(title, conference, login, year));
    }
    public void newGuidance(System labS, int login){
        this.guidelines.add( new Guidance((Teacher)labS.users.get(login)));
        }
    }

