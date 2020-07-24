package org.str1.str1petclinic.services;

import org.str1.str1petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
