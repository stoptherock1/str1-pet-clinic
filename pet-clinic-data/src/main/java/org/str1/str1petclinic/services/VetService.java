package org.str1.str1petclinic.services;

import org.str1.str1petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long Id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
