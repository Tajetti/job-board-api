package br.com.alvaro.GestaoVagas.Modules.Company.Controller;

import br.com.alvaro.GestaoVagas.Modules.Company.Entities.JobEntity;
import br.com.alvaro.GestaoVagas.Modules.Company.UseCases.CreateJob;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJob create;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity job) {
        try{
            var result = create.execute(job);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
