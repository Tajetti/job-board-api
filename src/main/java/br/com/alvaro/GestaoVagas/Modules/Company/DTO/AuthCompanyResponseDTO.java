package br.com.alvaro.GestaoVagas.Modules.Company.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthCompanyResponseDTO {
    private String acces_token;
    private Long expires_in;
}
