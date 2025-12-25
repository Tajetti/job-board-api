package br.com.alvaro.GestaoVagas.Modules.Company.UseCases;

import br.com.alvaro.GestaoVagas.Modules.Exception.UserFoundedException;
import br.com.alvaro.GestaoVagas.Modules.Company.Entities.CompanyEntity;
import br.com.alvaro.GestaoVagas.Modules.Company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class CreateCompany {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity company) {
        this.repository
                .findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent((comp) -> {
                    throw new UserFoundedException("Compania já existente!");
                });

                var password = passwordEncoder.encode(company.getPassword());
                company.setPassword(password);

        return this.repository.save(company);
    }
}
