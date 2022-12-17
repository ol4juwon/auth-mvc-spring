package com.ol4juwon.test.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ol4juwon.test.dto.UserDto;
import com.ol4juwon.test.entity.Role;
import com.ol4juwon.test.repository.RoleRepository;
import com.ol4juwon.test.repository.UsersRepository;
import com.ol4juwon.test.service.UserService;
import com.ol4juwon.test.users.Users;

@Service
public class UserServiceImpl  implements UserService{
    private UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl (UsersRepository usersRepository, RoleRepository roleRepository,PasswordEncoder passwordEncoder ){
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto){
        Users user = new Users();
        user.setName(userDto.getFirstName()+ " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }

        user.setRoles(Arrays.asList(role));
        usersRepository.save(user);

    }


    @Override
    public Users findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
    @Override
    public List<UserDto> findAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }
    private UserDto mapToUserDto(Users user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        System.out.println("name"+ user.getName());
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
