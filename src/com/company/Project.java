package com.company;

public class Project {
    String title, fundingAgency, objective, description, status;
    int[][] participants;
    int begin, end, value;
    public Project(String title, String fundingAgency, String objective, String description, int begin, int end, int value,
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
        this.participants[cases-1][login] = 1;
        this.status = "in preparation";
    }
    public void addParticipant(Lab laboratory, Project project, int cases, int login){
        if (laboratory.contributors[cases-1][login] == 1){
            project.participants[cases-1][login] = 1;
        }else{
            java.lang.System.out.print("user does not belong to the laboratory\n");
        }

    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void updateStatus(Project project){
        if (project.status == "in preparation"){
            project.setStatus("in progress");
        }else{
            project.setStatus("completed");
        }
    }
}
