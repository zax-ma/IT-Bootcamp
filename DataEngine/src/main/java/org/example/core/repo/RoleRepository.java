package org.example.core.repo;

import org.example.core.entity.RoleEntity;
import org.example.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {

    RoleEntity findByName(String name);

    @Override
    Optional<RoleEntity> findById(UUID uuid);

}
