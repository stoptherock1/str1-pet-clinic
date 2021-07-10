package org.str1.str1petclinic.services.map;

import org.springframework.stereotype.Service;
import org.str1.str1petclinic.model.Owner;
import org.str1.str1petclinic.services.OwnerService;
import org.str1.str1petclinic.services.PetService;
import org.str1.str1petclinic.services.PetTypeService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.setPets(owner.getPets()
                        .stream()
                        .map(pet -> {
                            if (pet.getPetType() == null) {
                                throw new RuntimeException("Pet Type is required");
                            }

                            if (pet.getPetType().getId() == null) {
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            }

                            if (pet.getId() == null) {
                                return petService.save(pet);
                            }
                            return pet;
                        })
                        .collect(Collectors.toSet()));
            }
            return super.save(owner);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
