package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.virustreatment;

public class HepBTreatment extends Treatment {

    @Override
    void treat(Patient patient) {
        System.out.println("Applying Hepatitis B vaccine to patient " + patient.getName() + " with symptom: " + patient.getSymptom());
    }
}
