package br.com.alvaro.GestaoVagas.Modules.Candidate.Controllers;

import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/create")
    public void create(@Valid @RequestBody CandidateEntity candidateEntity) {
        System.out.println("Candidato: " + candidateEntity.getEmail());
    }
}
