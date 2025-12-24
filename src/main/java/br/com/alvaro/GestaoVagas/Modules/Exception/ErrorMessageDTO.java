package br.com.alvaro.GestaoVagas.Modules.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    
    private String message;
    private String field;
    
}
