package ru.sicampus.bootcamp2026.service;

import org.springframework.stereotype.Service;
import ru.sicampus.bootcamp2026.dto.UsersDTO;

public interface UsersService {

    UsersDTO getUserById(long id);

    UsersDTO createUser(UsersDTO usersDTO);

    UsersDTO updateUser(long id, UsersDTO usersDTO);

    void deleteUser(long id);
}