package br.com.alvaro.GestaoVagas.Modules.Company.Controller;

import br.com.alvaro.GestaoVagas.Modules.Company.DTO.DTOcreatejob;
import br.com.alvaro.GestaoVagas.Modules.Company.Entities.JobEntity;
import br.com.alvaro.GestaoVagas.Modules.Company.UseCases.CreateJob;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
    public JobEntity create(@Valid @RequestBody DTOcreatejob jobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");
        
        //job.setCompanyId(UUID.fromString(companyId.toString()));
        var job = JobEntity.builder()
            .companyId(UUID.fromString(companyId.toString()))
            .benefits(jobDTO.getBenefits())
            .description(jobDTO.getDescription())
            .level(jobDTO.getLevel())
            .build();

        return this.create.execute(job);
    }
}
