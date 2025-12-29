package br.com.alvaro.GestaoVagas.Modules.Candidate.Controllers;

import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;
import br.com.alvaro.GestaoVagas.Modules.Candidate.UseCases.CreateCandidate;
import br.com.alvaro.GestaoVagas.Modules.Candidate.UseCases.ProfileCandidateUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidate create;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
      try {
          var result =  this.create.execute(candidateEntity);
          return ResponseEntity.ok().body(result);
      } catch (Exception e){
          return ResponseEntity.badRequest().body(e.getMessage());
      }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(HttpServletRequest request)
    {
        var idCandidate = request.getAttribute("candidate_id");
        try{
            var result = this.profileCandidateUseCase.execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
