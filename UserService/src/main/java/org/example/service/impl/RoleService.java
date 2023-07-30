package org.example.service.impl;

import org.example.core.entity.RoleEntity;
import org.example.core.repo.RoleRepository;
import org.example.service.exceptions.errors.RoleNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public RoleEntity getRole(String name){
        RoleEntity role = repository.findByName(name);

        if(role != null){
            return role;
        } else {
            throw new RoleNotFoundException("Role " + name + " was not found!");
        }
    }

}
