package hei.school.prog.repository;

import hei.school.prog.controller.mapper.PersonalRestMapper;
import hei.school.prog.controller.mapper.TenantRestMapper;
import hei.school.prog.controller.rest.CompanyRest;
import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.controller.rest.PersonalEmployeeRest;
import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.models.Company;
import hei.school.prog.repository.jpa.JTenantRepository;
import hei.school.prog.repository.mapper.JTenantMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
@AllArgsConstructor
public class TenantRepository {
    private final JTenantRepository jTenantRepository;
    private final JTenantMapper jTenantMapper;
    private final TenantRestMapper tenantRestMapper;
    private final RentRepository rentRepository;
    private final LendRepository lendRepository;
    private final PersonalRepository personalRepository;
    private final PersonalRestMapper personalRestMapper;

    public CompanyRest create(Company company) {
        String id = randomUUID().toString();
        List<RentRest> allRents = rentRepository.saveAll(company.getAllRenting(), id);
        List<LendRest> allLends = lendRepository.saveAll(company.getAllLending(), id);
        List<PersonalEmployeeRest> personals = personalRestMapper.toEntityShow(personalRepository.saveAll(company.getAllPersonal(), id));
        return tenantRestMapper.toEntity(jTenantRepository.save(jTenantMapper.toEntity(company, id)), allRents, allLends, personals);
    }

    public CompanyRest findById(String id) {
        List<RentRest> allRents = rentRepository.findAllBy(id);
        List<LendRest> allLends = lendRepository.findAllBy(id);
        List<PersonalEmployeeRest> personal = personalRepository.findAllBy(id);
        return tenantRestMapper.toEntity(jTenantRepository.getReferenceById(id), allRents, allLends, personal);
    }
}
