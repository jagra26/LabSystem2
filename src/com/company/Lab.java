package com.company;

public class Lab {
    String name;
    int[][] contributors;
    Project[] projects;
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
    }
    public void addContributors(Lab laboratory, int cases, int login){
        laboratory.contributors[cases-1][login] = 1;
    }
}
