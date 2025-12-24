package br.com.alvaro.GestaoVagas.Modules.Candidate.UseCases;

import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;
import br.com.alvaro.GestaoVagas.Modules.Exception.UserFoundedException;
import br.com.alvaro.GestaoVagas.Modules.Candidate.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidate {

    @Autowired
    private CandidateRepository repository;

    public CandidateEntity execute(CandidateEntity candidate) {
        this.repository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((cand) -> {
                    throw new UserFoundedException("Usuário já existe!");
                });

        return this.repository.save(candidate);
    }
}
