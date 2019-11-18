package com.boris.Classes;

import com.boris.Main;

import java.io.IOException;

public class BackUp extends Thread{
    private Serialization serialization = new Serialization("Patients.bcp");
    private Patients patients;

    public BackUp(Patients patients){
        this.patients = patients;
    }
    @Override
    public void run(){
        while(true) {
            try {
                serialization.Serialization(patients);
                Thread.sleep(10000);
                System.out.println("BACKUP");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
