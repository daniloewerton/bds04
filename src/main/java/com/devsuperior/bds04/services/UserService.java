package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.UserDTO;
import com.devsuperior.bds04.entities.User;
import com.devsuperior.bds04.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTO insert(final UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = repository.save(user);
        return new UserDTO(user);
    }

    public UserDTO findById(final Long id) {
        User user = repository.findById(id).get();
        return new UserDTO(user);
    }

    public List<UserDTO> findAll() {
        final List<User> users = repository.findAll();
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public void delete(final Long id) {
        User user = repository.getOne(id);
        repository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = repository.findByEmail(email);
        if(user == null) {
            LOGGER.warn("Usuário não encontrado " + email);
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        LOGGER.info("Usuário encontrado " + email);
        return user;
    }
}
