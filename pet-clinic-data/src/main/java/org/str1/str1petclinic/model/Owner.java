package org.str1.str1petclinic.model;

import java.util.Set;

public class Owner extends Person {
    Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
