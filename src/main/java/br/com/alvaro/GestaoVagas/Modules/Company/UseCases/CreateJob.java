package br.com.alvaro.GestaoVagas.Modules.Company.UseCases;

import br.com.alvaro.GestaoVagas.Modules.Company.Entities.JobEntity;
import br.com.alvaro.GestaoVagas.Modules.Company.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJob {

    @Autowired
    private JobRepository repository;

    public JobEntity execute(JobEntity job) {
        return this.repository.save(job);
    }
}
