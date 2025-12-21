package br.com.alvaro.GestaoVagas.Modules.Candidate.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    
}
