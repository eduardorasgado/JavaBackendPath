package com.eduardocode.designpatterns.behavioral.strategy.virustreatment;

public class TetatusTreatment extends Treatment {

    @Override
    void treat(Patient patient) {
        System.out.println("Applying Tetatus vaccine to patient " + patient.getName() + " with symptom: " + patient.getSymptom());
    }
}
