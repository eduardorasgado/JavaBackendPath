package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.virustreatment;

public class InfluenzaTreatment extends Treatment {

    @Override
    void treat(Patient patient) {
        System.out.println("Applying Influenza vaccine to patient " + patient.getName() + " with symptom: " + patient.getSymptom());
    }
}
