package org.str1.str1petclinic.model;

import java.util.Set;

public class Vet extends Person {
    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    private Set<Specialty> specialties;
}
