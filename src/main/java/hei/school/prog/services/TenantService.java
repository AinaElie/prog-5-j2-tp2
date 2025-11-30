package hei.school.prog.services;

import hei.school.prog.controller.rest.CompanyRest;
import hei.school.prog.models.Company;
import hei.school.prog.repository.TenantRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TenantService.class);
    private final TenantRepository tenantRepository;

    public CompanyRest create(Company company) {
        CompanyRest companyRest;
        try{
            companyRest = tenantRepository.create(company);
            LOGGER.info("Creation new Company");
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return companyRest;
    }

    public CompanyRest getById(String id) {
        CompanyRest companyRest;
        try{
            companyRest = tenantRepository.findById(id);
            LOGGER.info("Get Companies by Id");
        } catch (Exception e){
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return companyRest;
    }
}
