package br.com.alvaro.GestaoVagas.Modules.Candidate.Entity;

import lombok.Data;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculum;

}
