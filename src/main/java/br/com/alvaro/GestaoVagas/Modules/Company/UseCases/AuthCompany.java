package br.com.alvaro.GestaoVagas.Modules.Company.UseCases;

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

import br.com.alvaro.GestaoVagas.Modules.Company.DTO.DtoCompany;
import br.com.alvaro.GestaoVagas.Modules.Company.Repository.CompanyRepository;

@Service
public class AuthCompany 
{
    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(DtoCompany dtoCompany) throws AuthenticationException 
    {
        var company = this.repository.findByUsername(dtoCompany.getUsername())
            .orElseThrow(() -> 
                { 
                    throw new UsernameNotFoundException("Username/password incorrect!");
                }
            );
        // Verificando se as senhas são iguais:
        var passwordMatches = this.passwordEncoder.matches(dtoCompany.getPassword(), company.getPassword());
        //Caso senhas não iguais:
        if(!passwordMatches) {
            throw new AuthenticationException();
        }    
        //Caso senhas iguais:
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var token = JWT.create().withIssuer("javagas")
            .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
            .withSubject(company.getId().toString())
            .sign(algorithm);
        return token;

    }

}
