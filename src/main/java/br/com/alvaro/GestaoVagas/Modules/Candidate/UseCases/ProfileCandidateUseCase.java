package br.com.alvaro.GestaoVagas.Modules.Candidate.UseCases;

import br.com.alvaro.GestaoVagas.Modules.Candidate.DTO.ProfileCandidateResponseDTO;
import br.com.alvaro.GestaoVagas.Modules.Candidate.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository repository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
       var candidate = this.repository.findById(idCandidate).orElseThrow(() -> {
           throw new UsernameNotFoundException("User not found");
       });

       var candidatedto = ProfileCandidateResponseDTO.builder()
               .description(candidate.getDescription())
               .id(candidate.getId())
               .email(candidate.getEmail())
               .name(candidate.getName())
               .username(candidate.getUsername())
               .build();

       return candidatedto;
    }
}
