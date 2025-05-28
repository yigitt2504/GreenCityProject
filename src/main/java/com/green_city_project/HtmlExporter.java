package com.green_city_project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlExporter {
    public static void export(List<Info> devices, int totalCost, int totalEnergy, int totalScore) {
        String green_city_project = "green_city_report.html";
        try (FileWriter writer = new FileWriter(green_city_project)){
            writer.write("<!DOCTYPE html>\n<html>\n<head>\n");
            writer.write("<title>Green City Project Report</title>\n");
            writer.write("<style>\n");
            writer.write("body { font-family: Arial; margin: 40px; }\n");
            writer.write("table { border-collapse: collapse; width: 100%; }\n");
            writer.write("th, td { border: 1px solid #ddd; padding: 8px; }\n");
            writer.write("th { background-color:rgb(18, 13, 168); color: white; }\n");
            writer.write("</style>\n");
            writer.write("</head>\n<body>\n");
            writer.write("<h1>Green City Project - Selected Devices Report</h1>\n");
            writer.write("<table>\n<tr><th>Name</th><th>Cost </th><th>Energy Saved (kWh)</th><th>Sustainability Score</th></tr>\n");

            for (Info device : devices) {
                writer.write("<tr>");
                writer.write("<td>" + device.getdevice_name() + "</td>");
                writer.write("<td>" + device.getdevice_cost() + "</td>");
                writer.write("<td>" + device.getdevice_kWh_saved() + "</td>");
                writer.write("<td>" + device.getdevice_sustainability() + "</td>");
                writer.write("</tr>\n");
            }

            writer.write("</table>\n<br>\n");
            writer.write("<h3>Total Cost: " + totalCost + "</h3>\n");
            writer.write("<h3>Total Energy Saved: " + totalEnergy + " kWh</h3>\n");
            writer.write("<h3>Total Sustainability Score: " + totalScore + "</h3>\n");
            writer.write("</body>\n</html>");
            System.out.println("Report exported as '" + green_city_project);
        }

        catch (IOException e) {
            System.err.println("Error writing to HTML file: " + e.getMessage());
        }

    }
}
