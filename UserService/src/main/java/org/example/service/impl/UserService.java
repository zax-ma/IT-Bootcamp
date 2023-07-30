package org.example.service.impl;


import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.core.entity.UserEntity;
import org.example.core.repo.UserRepository;
import org.example.service.api.IUserService;
import org.example.service.dto.UserAboutDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {

    private final UserRepository repo;
    private final Converter<UserEntity, UserAboutDto> converter;

    public UserService(UserRepository repo, Converter<UserEntity, UserAboutDto> converter) {
        this.repo = repo;
        this.converter = converter;
    }

    @Override
    @Transactional
    public void saveUser(UserEntity userEntity) {
        if (!this.repo.existsByEmail(userEntity.getEmail())){
            repo.save(userEntity);
            log.info("User was saved successfully!");
        } else {
            log.atError();
            throw new RuntimeException("User already exist");
        }

    }

    @Override
    public Page<UserAboutDto> getUserPage(Pageable page) {
        Page<UserEntity> userPage = this.repo.findAll(page);
        if(!userPage.isEmpty()) {
            log.info("User info was created");
            return userPage.map(converter::convert);
        } else {
            log.atError();
            throw new RuntimeException("List of users is empty");
        }
    }

    @Override
    public List<UserAboutDto> findAllUsers() {
        List<UserEntity> users = this.repo.findAll();
        return users.stream()
                .map(converter::convert)
                .toList();
    }

}
