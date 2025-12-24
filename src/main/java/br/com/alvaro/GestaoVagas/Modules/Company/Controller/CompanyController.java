package br.com.alvaro.GestaoVagas.Modules.Company.Controller;

import br.com.alvaro.GestaoVagas.Modules.Candidate.Exception.UserFoundedException;
import br.com.alvaro.GestaoVagas.Modules.Company.Entities.CompanyEntity;
import br.com.alvaro.GestaoVagas.Modules.Company.UseCases.CreateCompany;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompany create;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity company) {
        try{
            var result = this.create.execute(company);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
