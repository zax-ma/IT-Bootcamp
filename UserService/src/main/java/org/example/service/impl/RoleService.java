package org.example.service.impl;

import org.example.core.entity.RoleEntity;
import org.example.core.repo.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public RoleEntity getRole(String name){
        RoleEntity role;
        try {
            role = repository.findByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Role already exist");
        }
        return role;
    }

}
