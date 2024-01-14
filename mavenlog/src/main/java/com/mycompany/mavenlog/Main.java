/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenlog;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Map;
import java.util.LinkedHashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Hashtable;
import javax.swing.BoxLayout;

/**
 *
 * @author Al-Rubab Ibn Yeahyea
 */


public class Main {
    
    public static void printErr(int[] arr, String month, String[] err) {
        System.out.println("Error in "+ month +" 2022");
        for (int i= 6; i<15; i++ ) {
           System.out.println(err[i-6]+":   "+ arr[i]);
           
       }
    
    }
    
    public static void printPartition(int[] arr, String month) {
        
          System.out.println("Number of Jobs divided by partion in "+ month +" 2022");
          System.out.println("+-----------------------------------+");
          System.out.println("cpu-epyc           " + arr[3]);
          System.out.println("cpu-opteron        " + arr[5]);
          System.out.println("gpu-k10            " + arr[16]);
          System.out.println("gpu-v100           " + arr[17]);
          System.out.println("gpu-titan          " + arr[18]);
          System.out.println("gpu-k40c           " + arr[18]);
          System.out.println("+-----------------------------------+");
       
    }
    
    public static void main(String[] args) {
       
       
       String[] months = {"June", "July", "August", "September", "October", "November","December"};
       int[] june = new int[16];
       int[] july = new int[16];
       int[] august = new int[16];
       int[] september = new int[16];
       int[] october = new int[16];
       int[] november = new int[16];
       int[] december = new int[16];
       
       june = getInfo("2022-06-01", "2022-06-30");
       july = getInfo("2022-07-01", "2022-07-31");
       august = getInfo("2022-08-01", "2022-08-31");
       september = getInfo("2022-09-01", "2022-09-30");
       october = getInfo("2022-10-01", "2022-10-31");
       november = getInfo("2022-11-01", "2022-11-30");
       december = getInfo("2022-12-01", "2022-12-31");
       int [] all = new int[16];
       all = getInfo("2022-06-01", "2022-12-31");
       String[] err =  {"errorTotal", "errorFreeAccount", "errorInvalidNode", "errorNodeLookupFailure", "errorNodesNotResponding", "errorAlreadyAllocated", "errorSecurityViolation", "errorSocketTimedOut", "errorUserNotFound", "errorOthers"};
       
       
       int [][] arr = {june, july, august, september, october, november, december}; 
       
     
       for(int i=0; i<7; i++) {
           printPartition(arr[i], months[i]);
           printErr(arr[i], months[i], err);
       }
       
      
       
       int[] jobStarted = {june[0], july[0], august[0], september[0], october[0], november[0], december[0]};
       int[] jobEnded = {june[1], july[1], august[1], september[1], october[1], november[1], december[1]};
       int[] jobError = {june[15], july[15], august[15], september[15], october[15], november[15], december[15]};
       
       DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
       dataset2.addValue(june[5], "June", "CPU-opteron");
       dataset2.addValue(july[5], "July", "CPU-opteron");
       dataset2.addValue(august[5], "August", "CPU-opteron");
       dataset2.addValue(september[5], "September", "CPU-opteron");
       dataset2.addValue(october[5], "October", "CPU-opteron");
       dataset2.addValue(november[5], "November", "CPU-opteron");
       dataset2.addValue(december[5], "December", "CPU-opteron");
       
       dataset2.addValue(june[3], "June", "CPU-EPYC");
       dataset2.addValue(july[3], "July", "CPU-EPYC");
       dataset2.addValue(august[3], "August", "CPU-EPYC");
       dataset2.addValue(september[3], "September", "CPU-EPYC");
       dataset2.addValue(october[3], "October", "CPU-EPYC");
       dataset2.addValue(november[3], "November", "CPU-EPYC");
       dataset2.addValue(december[3], "December", "CPU-EPYC");
       
       dataset2.addValue(june[4], "June", "GPU");
       dataset2.addValue(july[4], "July", "GPU");
       dataset2.addValue(august[4], "August", "GPU");
       dataset2.addValue(september[4], "September", "GPU");
       dataset2.addValue(october[4], "October", "GPU");
       dataset2.addValue(november[4], "November", "GPU");
       dataset2.addValue(december[4], "December", "GPU");
       
        JFreeChart chart = ChartFactory.createBarChart("Number of jobs", "Month", "Jobs", dataset2, PlotOrientation.VERTICAL, true, true, false);

        // Create a panel to display the chart
        ChartPanel panel1 = new ChartPanel(chart);

        // Create a frame to hold the chart
        JFrame frame = new JFrame("Bar Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
        frame.setSize(500, 500);
        frame.setVisible(true);
       
       
        
       
       
        // Create a dataset for the chart
        XYDataset dataset = createDataset(months, jobStarted, jobEnded);

        // Create the chart
        JFreeChart chart = ChartFactory.createXYLineChart("Job Status per Month", "Month", "Number of Jobs", dataset, PlotOrientation.VERTICAL, true, true, false);

        // Create a panel to display the chart
        ChartPanel panel = new ChartPanel(chart);

        // Create a frame to hold the chart
        JFrame frame = new JFrame("Line Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);
       
    }
    
    
    public static int[] getInfo( String startDate, String endDate){
        //data format 2022-06-01
            int[] arr = new int[20];
            /*
            
            cpu - epyc
gpu - k10
gpu - v100s
gpu - titan
cpu - opteron
gpu - k40c
            */
            int jobStarted = 0;
            int jobEnded = 0;
            int epyc = 0;
            int gpu = 0;
            int opteron = 0;
            int errorFreeAccount = 0;
            int errorInvalidNode = 0;
            int errorNodeLookupFailure = 0;
            int errorNodesNotResponding = 0;
            int errorAlreadyAllocated = 0;
            int errorSecurityViolation = 0;
            int errorSocketTimedOut = 0;
            int errorUserNotFound = 0;
            int errorOthers = 0;
            int errorTotal = 0;
            int k10 = 0;
            int v100s = 0;
            int titan=0;
            int k40c= 0;
            long execTimeTotal = 0;
            long execTimeAvg = 0;
            
            
            ArrayList<String[]> startingData = new ArrayList<>();
            ArrayList<String[]> endingData = new ArrayList<>();
            try {
            
            FileReader fileReader = new FileReader("C:/Users/Al-Rubab Ibn Yeahyea/Documents/NetBeansProjects/mavenlog/extracted_log");
            BufferedReader br = new BufferedReader(fileReader);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
            String line;
            
            while((line = br.readLine()) != null){
            String date = line.split("\\[|T")[1].split("\\.")[0];
            Date d = sdf.parse(date);
            if(d.after(start) && d.before(end)) {
                if (line.contains("Allocate")){
                    jobStarted++;
                    String[] parts = line.split(" ");
                    startingData.add(new String[]{parts[3].split("=")[1], parts[0].substring(1, parts[0].length()-1)});

                    if (line.contains("Partition=cpu-epyc"))
                    {
                        epyc++;
                    }
                    else if (line.contains("Partition=cpu-opteron"))
                    {
                        opteron++;
                    }
                    else if (line.contains("Partition=gpu-k10"))
                    {
                        gpu++;
                        k10++;
                    }
                    else if (line.contains("Partition=gpu-v100s"))
                    {
                        gpu++;
                        v100s++;
                    }
                    else if (line.contains("Partition=gpu-titan"))
                    {
                        gpu++;
                        titan++;
                    }
                    else if (line.contains("Partition=gpu-k40c"))
                    {
                        gpu++;
                        k40c++;
                    }
              
                }
                else if (line.contains("_job_complete") && line.contains("done"))
                {
                    
                    jobEnded++;
                }
                else if (line.contains("error"))
                {
                    errorTotal++;
                    if (line.contains("error: This association "))
                        errorFreeAccount++;
                    else if (line.contains("error: node_name") && line.contains("invalid node specified:"))
                        errorInvalidNode++;
                    else if (line.contains("_find_node_record: lookup failure for node"))
                        errorNodeLookupFailure++;
                    else if (line.contains("error: Nodes") && line.contains("not responding"))
                        errorNodesNotResponding++;
                    else if (line.contains("_slurm_rpc_complete_job_allocation:") && line.contains("error Job/step already completing or completed"))
                        errorAlreadyAllocated++;
                    else if (line.contains("error: Security violation"))
                        errorSecurityViolation++;
                    else if (line.contains("Socket timed out on send/recv operation"))
                        errorSocketTimedOut++;
                    else if (line.contains("User") && line.contains("not found"))
                        errorUserNotFound++;
                    else
                        errorOthers++;
                }
            }
            
            }
            br.close();
            
        arr[0] = jobStarted;
        arr[1] = jobEnded;
        arr[2] = 0;
        arr[3] = epyc;
        arr[4] = gpu;
        arr[5] = opteron;
        arr[6] = errorFreeAccount;
        arr[7] = errorInvalidNode;
        arr[8] = errorNodeLookupFailure;
        arr[9] = errorNodesNotResponding;
        arr[10] = errorAlreadyAllocated;
        arr[11] = errorSecurityViolation;
        arr[12] = errorSocketTimedOut;
        arr[13] = errorUserNotFound;
        arr[14] = errorOthers;
        arr[15] = errorTotal;
       
        arr[16] = k10;
        arr[17] = v100s;
        arr[18] = titan;
        arr[19] = k40c;
//        arr[16] = execTimeTotal;
//        arr[2] = execTimeAvg;
       
            
        }catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        System.out.println("An error occurred while reading the file");
    }
         return arr;   
        
    }        
    private static XYDataset createDataset(String[] months, int[] jobStarted, int[] jobEnded) {
        XYSeries series1 = new XYSeries("Job Started");
        XYSeries series2 = new XYSeries("Job Ended");
        for(int i=0;i<months.length;i++){
            series1.add(i,jobStarted[i]);
            series2.add(i,jobEnded[i]);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }
        
}
