package com.simon;

import com.pi4j.device.Device;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;
import java.nio.LongBuffer;
import java.util.BitSet;

public class Main {

    public static void main(String[] args) throws IOException, I2CFactory.UnsupportedBusNumberException, InterruptedException {
        // write your code here

        max17043 max = new max17043(I2CFactory.getInstance(I2CBus.BUS_1));

        TestAllFunction(max);


      while(true){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.print("Default alert treshold:\t");
            System.out.print(max.getAlertThreshold());
            System.out.println("%");

            System.out.print("Voltage:\t\t");
            System.out.print(max.getVcell());
            System.out.println(" V");

            System.out.print("State of charge :\t");
            System.out.print(max.getSOC());
            System.out.println("%");
//          System.out.print("State of charge soc v2:\t");
//          System.out.print(max.getSoCv2(max.device));
//          System.out.println("%");

            System.out.println("");
            System.out.print("Alert triggered:\t");
            if(max.getAlertTriggered()){
//                System.out.println("dos not work atm");
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            Thread.sleep(10000);
        }


    }

    private static void TestAllFunction(max17043 max) throws IOException, InterruptedException {

//        max.reset();
        max.QuickStart();

        Thread.sleep(1000);

        System.out.print("Default alert treshold:\t");
        System.out.print(max.getAlertThreshold());
        System.out.println("%");
        int threashold = 20;
        System.out.println("setting alert threshold to "+threashold +" %");
        max.setAlertThreshold(threashold);

        System.out.print("new alert treshold:\t");
        System.out.print(max.getAlertThreshold());
        System.out.println("%");

        System.out.print("Voltage:\t\t");
        System.out.print(max.getVcell());
        System.out.println(" V");


        System.out.print("State of charge :\t");
        System.out.print(max.getSOC());
        System.out.println("%");


        System.out.println("");
        System.out.println("Config data");

        System.out.print("Version:\t\t");
        System.out.println(max.getVersion());

        System.out.print("Alert treshold:\t\t");
        System.out.print(max.getAlertThreshold());
        System.out.println("%");


        System.out.print("Alert triggered:\t");
        if(max.getAlertTriggered()){
//                System.out.println("dos not work atm");
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
