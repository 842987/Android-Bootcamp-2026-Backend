package ru.sicampus.bootcamp2026.service.impl;

import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sicampus.bootcamp2026.dto.UsersDTO;
import ru.sicampus.bootcamp2026.entity.Invitations;
import ru.sicampus.bootcamp2026.entity.Users;
import ru.sicampus.bootcamp2026.exception.UserNotFoundException;
import ru.sicampus.bootcamp2026.repository.InvitationsRepository;
import ru.sicampus.bootcamp2026.repository.UsersRepository;
import ru.sicampus.bootcamp2026.service.UsersService;
import ru.sicampus.bootcamp2026.util.UsersMapper;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final InvitationsRepository invitationsRepository;
    @Override
    public UsersDTO getUserById(long id) {
        return usersRepository.findById(id).map(UsersMapper::convertToDTO)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public UsersDTO createUser(UsersDTO usersDTO) {
        Users user = new Users();
        user.setName(user.getName());
        user.setAvatarUrl(user.getAvatarUrl());
        return UsersMapper.convertToDTO(usersRepository.save(user));
    }

    @Override
    public UsersDTO updateUser(long id, UsersDTO usersDTO) {
        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        user.setId(usersDTO.getId());
        user.setName(usersDTO.getName());
        user.setAvatarUrl(usersDTO.getAvatarUrl());
        return UsersMapper.convertToDTO(usersRepository.save(user));
    }

    @Override
    public void deleteUser(long id) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
//        List<Invitations> userInvitations = invitationsRepository.findAllByInvitedUserId(user);
//        invitationsRepository.deleteAll(userInvitations);
        usersRepository.delete(user);
    }
}