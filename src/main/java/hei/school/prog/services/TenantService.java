package hei.school.prog.services;

import hei.school.prog.controller.rest.CompanyRest;
import hei.school.prog.models.Company;
import hei.school.prog.repository.TenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantService {
    private final TenantRepository tenantRepository;

    public CompanyRest create(Company company) {
        return tenantRepository.create(company);
    }

    public CompanyRest getById(String id) {
        return tenantRepository.findById(id);
    }
}
