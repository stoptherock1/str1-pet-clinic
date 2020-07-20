package org.str1.str1petclinic.services;

import org.str1.str1petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long Id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
