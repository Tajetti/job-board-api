package br.com.alvaro.GestaoVagas.Modules.Company.Repository;

import br.com.alvaro.GestaoVagas.Modules.Company.Entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
