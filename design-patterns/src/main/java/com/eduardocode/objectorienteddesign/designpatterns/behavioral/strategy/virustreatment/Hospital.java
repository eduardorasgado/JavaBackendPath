package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.virustreatment;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Hospital {
    private Treatment treatmentStrategy;

    private Map<String, Treatment> treatmentMap = new HashMap<>();

    public Hospital() {

        initializeTreatmentMap();
    }

    private void initializeTreatmentMap() {
        treatmentMap.put("spams", new TetatusTreatment());
        treatmentMap.put("flu", new InfluenzaTreatment());
        treatmentMap.put("jaundice", new HepBTreatment());
    }


    public void attendToPatient(Patient patient) {
        System.out.println("Patient: " + patient.getName() + " is received at the hospital...");

        Treatment newTreatment = treatmentMap.get(patient.getSymptom());
        if(isNull(treatmentStrategy) || !treatmentStrategy.equals(newTreatment)) {
            System.out.println("[updating strategy]");

            setTreatmentStrategy(newTreatment);
        }

        treatmentStrategy.treat(patient);

        System.out.println("Patient: " + patient.getName() + " left the hospital...");
    }

    private void setTreatmentStrategy(Treatment treatmentStrategy) {
        this.treatmentStrategy = treatmentStrategy;
    }
}
