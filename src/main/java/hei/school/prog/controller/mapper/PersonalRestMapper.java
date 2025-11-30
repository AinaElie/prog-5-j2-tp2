package hei.school.prog.controller.mapper;

import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.controller.rest.PersonalEmployeeRest;
import hei.school.prog.controller.rest.PersonalRest;
import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.entity.JPersonal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PersonalRestMapper {
    public PersonalRest toEntity(JPersonal jPersonal, List<RentRest> allRenting, List<LendRest> allLend) {
        return new PersonalRest(jPersonal.getId(), jPersonal.getIdTenant(), jPersonal.getName(), allRenting, allLend);
    }

    public List<PersonalEmployeeRest> toEntity(List<JPersonal> allPersonal) {
        List<PersonalEmployeeRest> personalEmployeeRestList = new ArrayList<>();

        for (JPersonal jPersonal : allPersonal) {
            personalEmployeeRestList.add(new PersonalEmployeeRest(jPersonal.getId(), jPersonal.getIdTenant(), jPersonal.getName()));
        }

        return personalEmployeeRestList;
    }

    public List<PersonalEmployeeRest> toEntityShow(List<PersonalRest> allPersonal) {
        List<PersonalEmployeeRest> personalEmployeeRestList = new ArrayList<>();

        for (PersonalRest personal : allPersonal) {
            personalEmployeeRestList.add(new PersonalEmployeeRest(personal.id(), personal.idTenant(), personal.name()));
        }

        return personalEmployeeRestList;
    }
}
