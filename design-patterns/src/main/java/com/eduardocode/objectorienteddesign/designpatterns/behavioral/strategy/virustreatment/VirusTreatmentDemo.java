package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.virustreatment;

public class VirusTreatmentDemo {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Patient patient1 = new Patient("Andrew", "jaundice");
        Patient patient2 = new Patient("Mario", "flu");
        Patient patient3 = new Patient("Renuka", "flu");
        Patient patient4 = new Patient("John", "spams");

        hospital.attendToPatient(patient1);
        hospital.attendToPatient(patient2);
        hospital.attendToPatient(patient3);
        hospital.attendToPatient(patient4);
    }
}
