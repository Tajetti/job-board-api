package br.com.alvaro.GestaoVagas.Modules.Company.UseCases;

import br.com.alvaro.GestaoVagas.Modules.Exception.UserFoundedException;
import br.com.alvaro.GestaoVagas.Modules.Company.Entities.CompanyEntity;
import br.com.alvaro.GestaoVagas.Modules.Company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompany {

    @Autowired
    private CompanyRepository repository;

    public CompanyEntity execute(CompanyEntity company) {
        repository
                .findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent((comp) -> {
                    throw new UserFoundedException("Compania já existente!");
                });

        return this.repository.save(company);
    }
}
