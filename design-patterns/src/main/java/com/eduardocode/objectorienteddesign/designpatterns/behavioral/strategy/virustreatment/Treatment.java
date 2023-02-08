package com.eduardocode.objectorienteddesign.designpatterns.behavioral.strategy.virustreatment;

public abstract class Treatment {

    public boolean equals(Treatment treatment) {
        return this.getClass().getSimpleName().equals(treatment.getClass().getSimpleName());
    }

    abstract void treat(Patient patient);
}
