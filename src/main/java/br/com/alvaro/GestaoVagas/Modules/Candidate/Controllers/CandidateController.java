package br.com.alvaro.GestaoVagas.Modules.Candidate.Controllers;

import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;
import br.com.alvaro.GestaoVagas.Modules.Candidate.Repository.CandidateRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository repository;

   
    @PostMapping("/create")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
       return this.repository.save(candidateEntity);
    }
}
