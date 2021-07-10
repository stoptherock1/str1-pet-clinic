package org.str1.str1petclinic.services.map;

import org.springframework.stereotype.Service;
import org.str1.str1petclinic.model.Vet;
import org.str1.str1petclinic.services.SpecialtyService;
import org.str1.str1petclinic.services.VetService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            var specialties = vet.getSpecialties();
            if (specialties != null) {
                vet.setSpecialties(specialties
                        .stream()
                        .map(specialty -> {
                            if (specialty.getId() != null) {
                                return specialty;
                            }
                            return specialtyService.save(specialty);
                        }).collect(Collectors.toSet()));
            }

            return super.save(vet);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
