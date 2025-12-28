package br.com.alvaro.GestaoVagas.Modules.Candidate.UseCases;

import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.alvaro.GestaoVagas.Modules.Candidate.DTO.AuthRequestCandidateDTO;
import br.com.alvaro.GestaoVagas.Modules.Candidate.DTO.AuthResponseCandidateDTO;
import br.com.alvaro.GestaoVagas.Modules.Candidate.Entity.CandidateEntity;
import br.com.alvaro.GestaoVagas.Modules.Candidate.Repository.CandidateRepository;
import jakarta.validation.Valid;

@Service
public class AuthCandidateUseCase {
    
    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository repository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponseCandidateDTO execute(AuthRequestCandidateDTO authRequestCandidateDTO) throws AuthenticationException
    {
        var candidate = repository.findByUsername(authRequestCandidateDTO.username())
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Username/Password incorrect!");
            });
        var passwordMatches = this.passwordEncoder
            .matches(authRequestCandidateDTO.password(), candidate.getPassword());

        if(!passwordMatches)
        {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expireIn = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create()
                    .withIssuer("javagas")
                    .withSubject(candidate.getId().toString())
                    .withClaim("roles", Arrays.asList("candidate"))
                    .withExpiresAt(expireIn)
                    .sign(algorithm);
                    
        var authResponseCandidateDTO = AuthResponseCandidateDTO.builder()
            .access_token(token)
            .expire_in(expireIn.toEpochMilli())
            .build();

        return authResponseCandidateDTO;
    }
}
