package com.green_city_project;
import java.util.Scanner;

public class Info{

    static int getbudget(){
        Scanner input = new Scanner(System.in);
        System.out.println("What is your budget? ");
        int budget = input.nextInt();
        input.close();
        return budget;
    };

    String device_name;
    int device_cost;
    int device_kWh_saved;
    int device_sustainability;
    String device_category;

    public Info(String device_name, int device_cost, int device_kWh_saved, int device_sustainability, String device_category){
        this.device_name = device_name;
        this.device_cost = device_cost;
        this.device_kWh_saved = device_kWh_saved;
        this.device_sustainability = device_sustainability;
        this.device_category = device_category;
    }

    public String getdevice_name(){
        return device_name;
    }

    public void setdevice_name(String device_name){
        this.device_name = device_name;
    }

    public int getdevice_cost(){
        return device_cost;
    }

    public void setdevice_cost(int device_cost){
        this.device_cost = device_cost;
    }

    public int getdevice_kWh_saved(){
        return device_kWh_saved;
    }

    public void setdevice_kWh_saved(int device_kWh_saved){
        this.device_kWh_saved = device_kWh_saved;
    }

    public int getdevice_sustainability(){
        return device_sustainability;
    }

    public void setdevice_sustainability(int device_sustainability){
        this.device_sustainability = device_sustainability;
    }

    public String getdevice_category(){
        return device_category;
    }

    public void setdevice_category(String device_category){
        this.device_category = device_category;
    }

    public int getenergy_saving_x_sustainability(int device_kWh_saved, int device_sustainability){
        return device_kWh_saved * device_sustainability;
    }
}
