package com.green_city_project;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int budget = Info.getbudget();
        List<Info> selected_devices = new ArrayList<>();
        
        Info devices[]={
            new Info("Air Conditioner", 40000, 850, 3, "Heating & Cooling"),
            new Info("Motion Sensor Light Switches", 1500, 180, 4, "Smart & Control Systems"),
            new Info("Solar Water Heater", 30000, 2500, 5, "Renewable Energy"),
            new Info("LED Lights with Solar Panel", 1000, 90, 5, "Renewable Energy"),
            new Info("Solar Powered Charging Station", 350000, 8000, 5, "Renewable Energy"),
            new Info("Vending Machine", 140000, 1200, 3, "Infrastructure / Building Systems"),
            new Info("Rainwater Harvesting Pump", 2000, 200, 4, "Renewable Energy"),
            new Info("Hand Dryer", 10000, 380, 3, "Heating & Cooling"),
            new Info("Dishwasher", 25000, 600, 3, "Heating & Cooling"),
            new Info("Energy Recovery Ventilation System", 60000, 1000, 2, "Heating & Cooling"),
            new Info("Refrigerator", 90000, 1000, 3, "Heating & Cooling"), 
            new Info("Wall Mounted Fan", 6000, 200, 2, "Heating & Cooling"),
            new Info("Smart Blinds", 2000, 300, 4, "Smart & Control Systems"),
            new Info("Irrigation Controller", 3500, 100, 1, "Infrastructure / Building Systems"),
            new Info("Elevator Control System", 30000, 6000, 1, "Infrastructure / Building Systems"),
            new Info("Kiosk", 25000, 700, 1, "Infrastructure / Building Systems"),
            new Info("Wind Powered Street Light", 50000, 300, 5, "Infrastructure / Building Systems"),
            new Info("Smart Board with Power Saver Mode", 75000, 250, 1, "Infrastructure / Building Systems"),
            new Info("Building occupancy sensor", 4000, 130, 4, "Infrastructure / Building Systems"),
            new Info("Electric Stove", 3000, 1000, 2, "Heating & Cooling"),
        };

        int dp[][] = new int[devices.length + 1][budget + 1];

        for(int i = 1; i<=devices.length; i++){
            int cost = devices[i - 1].getdevice_cost();
            int value = devices[i - 1].getenergy_saving_x_sustainability(devices[i-1].getdevice_kWh_saved(), devices[i-1].getdevice_sustainability());

            for(int w = 0; w <= budget; w++){
                if(cost > w){
                    dp[i][w] = dp[i - 1][w];
                }
                else{
                    dp[i][w] = Math.max(
                        dp[i - 1][w],
                        dp[i - 1][w - cost] + value
                    );
                }
            }
        }
        int w = budget;
        for(int i = devices.length; i > 0; i--){
            if(dp[i][w] != dp[i-1][w]){
                Info dev = devices[i - 1];
                selected_devices.add(dev);
                w -= dev.getdevice_cost();
            }
        }

        int total_cost = 0;
        int total_energy_saved = 0;
        int total_sustainability_score = 0;

        for(Info device: selected_devices){
            total_cost += device.getdevice_cost();
            total_energy_saved += device.getdevice_kWh_saved();
            total_sustainability_score += device.getenergy_saving_x_sustainability(device.getdevice_kWh_saved(), device.getdevice_sustainability());
            
        }  

        System.out.println("List of the selected devices: ");
        for(Info device : selected_devices){
            System.out.println("Name: " + device.getdevice_name() + "Cost: " + device.getdevice_cost() + "\nEnergy saved: " + device.getdevice_kWh_saved() + "\nIndividual sustainability score: " + device.getenergy_saving_x_sustainability(device.getdevice_kWh_saved(), device.getdevice_sustainability()));
            System.out.println();
        }

        System.out.println("\nTotal cost of selected devices: " + total_cost);
        System.out.println("Total energy saved: " + total_energy_saved + " kWh");
        System.out.println("Total sustainability score: " + total_sustainability_score);

        HtmlExporter.export(selected_devices, total_cost, total_energy_saved, total_sustainability_score);

    }
}