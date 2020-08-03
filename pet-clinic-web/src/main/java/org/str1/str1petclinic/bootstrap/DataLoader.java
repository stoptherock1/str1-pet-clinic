package org.str1.str1petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.str1.str1petclinic.model.Owner;
import org.str1.str1petclinic.model.Vet;
import org.str1.str1petclinic.services.OwnerService;
import org.str1.str1petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("AAAA");
        owner1.setLastName("BBBB");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("CCCC");
        owner2.setLastName("DDDDD");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("EEEE");
        vet1.setLastName("FFFF");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("GGGG");
        vet2.setLastName("HHHH");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
