package br.edu.utfpr.pb.prjgamegift1.server.dto;

import lombok.Data;

@Data
public class AuthRequestDTO { // essa classe representa o JSON do POST de /login
    private String email;
    private String password;
}
