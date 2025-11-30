package hei.school.prog.controller.mapper;

import hei.school.prog.controller.rest.CompanyRest;
import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.controller.rest.PersonalEmployeeRest;
import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.entity.JTenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TenantRestMapper {
    public CompanyRest toEntity(JTenant jTenant, List<RentRest> allRenting, List<LendRest> allLend, List<PersonalEmployeeRest> personals) {
        return new CompanyRest(
                jTenant.getId(),
                jTenant.getName(),
                allRenting,
                allLend,
                personals
        );
    }
}
