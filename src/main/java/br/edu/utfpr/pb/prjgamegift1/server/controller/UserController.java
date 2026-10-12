package br.edu.utfpr.pb.prjgamegift1.server.controller;

import br.edu.utfpr.pb.prjgamegift1.server.dto.UserDTO;
import br.edu.utfpr.pb.prjgamegift1.server.mapper.UserMapper;
import br.edu.utfpr.pb.prjgamegift1.server.model.User;
import br.edu.utfpr.pb.prjgamegift1.server.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UserDTO userDTO){
        User user = userMapper.toEntity(userDTO);
        userService.save(user);
    }
}
