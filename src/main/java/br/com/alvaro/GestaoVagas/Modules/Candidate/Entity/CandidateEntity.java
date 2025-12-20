package br.com.alvaro.GestaoVagas.Modules.Candidate.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    @Pattern(regexp = "ˆ(?!\\s*$).+", message = "username não pode conter espaço")
    private String username;

    @Email(message = "O campo deve conter um email válido!")
    private String email;

    @Length(min = 10, max = 100, message = "Sua senha deve ter entre 10 e 100 caracteres")
    private String password;
    private String description;
    private String curriculum;

}
