package com.lexart.app.modules.user.adapter.out.persistence.repository;

import com.lexart.app.modules.user.application.port.out.UserRepository;
import com.lexart.app.modules.user.domain.exception.UserNotFoundException;
import com.lexart.app.modules.user.domain.model.User;
import com.lexart.app.modules.user.adapter.out.persistence.entity.UserEntity;
import com.lexart.app.modules.user.adapter.out.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringUserRepository springUserRepository;


    public UserRepositoryImpl(SpringUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public void save(User user) {
        UserEntity entity = UserMapper.mapToEntity(user);
        springUserRepository.save(entity);
    }

    @Override
    public Optional<User> getById(Long id) {
        Optional<UserEntity> userEntity = springUserRepository.findById(id);
        return userEntity.map(UserMapper::mapToDomain);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        Optional<UserEntity> userEntity = springUserRepository.findByUsername(username);
        if (userEntity.isEmpty()) {
            throw new UserNotFoundException(username);
        }

        return userEntity.map(UserMapper::mapToDomain);
    }


}