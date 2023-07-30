package org.example.core.repo;

import jakarta.transaction.Transactional;
import org.example.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
        UserEntity findByEmail(String email);

        boolean existsByEmail(String email);

        @Override
        Optional<UserEntity> findById(UUID uuid);

}
