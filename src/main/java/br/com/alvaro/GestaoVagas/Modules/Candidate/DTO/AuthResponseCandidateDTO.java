package br.com.alvaro.GestaoVagas.Modules.Candidate.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseCandidateDTO {
    private Long expire_in;
    private String access_token;
}
