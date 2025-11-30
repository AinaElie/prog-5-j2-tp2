package hei.school.prog.services;

import hei.school.prog.controller.rest.PersonalEmployeeRest;
import hei.school.prog.controller.rest.PersonalRest;
import hei.school.prog.models.Personal;
import hei.school.prog.repository.PersonalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonalService {
    private final PersonalRepository personalRepository;

    public PersonalRest create(Personal personal, String idTenant) {
        return personalRepository.create(personal, idTenant);
    }

    public List<PersonalEmployeeRest> getAll() {
        return personalRepository.findAll();
    }

    public List<PersonalEmployeeRest> getAllBy(String idTenant) {
        return personalRepository.findAllBy(idTenant);
    }
}
