package br.com.alvaro.GestaoVagas.Modules.Candidate.UseCases;

import br.com.alvaro.GestaoVagas.Exception.UserFoundedException;
import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;
import br.com.alvaro.GestaoVagas.Modules.Candidate.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidate {

    @Autowired
    private CandidateRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidate) {
        this.repository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((cand) -> {
                    throw new UserFoundedException("Usuário já existe!");
                });

                var password = passwordEncoder.encode(candidate.getPassword());
                candidate.setPassword(password);

        return this.repository.save(candidate);
    }
}
