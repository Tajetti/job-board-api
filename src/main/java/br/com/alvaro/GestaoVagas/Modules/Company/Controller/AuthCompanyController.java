package br.com.alvaro.GestaoVagas.Modules.Company.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alvaro.GestaoVagas.Modules.Company.DTO.DtoCompany;
import br.com.alvaro.GestaoVagas.Modules.Company.UseCases.AuthCompany;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthCompanyController {
    
    @Autowired
    private AuthCompany authCompany;

    @PostMapping("/company")
    public ResponseEntity<Object> create(@RequestBody DtoCompany dtoCompany) throws AuthenticationException
    {
        try{
            var result = this.authCompany.execute(dtoCompany);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    
}
