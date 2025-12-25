package br.com.alvaro.GestaoVagas.Modules.Candidate.Controllers;

import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;
import br.com.alvaro.GestaoVagas.Modules.Candidate.UseCases.CreateCandidate;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidate create;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
      try {
          var result =  this.create.execute(candidateEntity);
          return ResponseEntity.ok().body(result);
      } catch (Exception e){
          return ResponseEntity.badRequest().body(e.getMessage());
      }
    }
}
