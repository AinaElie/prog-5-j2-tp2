package hei.school.prog.services;

import hei.school.prog.controller.rest.PersonalEmployeeRest;
import hei.school.prog.controller.rest.PersonalRest;
import hei.school.prog.models.Personal;
import hei.school.prog.repository.PersonalRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonalService {
    private static final Logger log = LoggerFactory.getLogger(PersonalService.class);
    private final PersonalRepository personalRepository;

    public PersonalRest create(Personal personal, String idTenant) {
        PersonalRest personalRest;

        try{
            personalRest = personalRepository.create(personal, idTenant);
            log.info("Created new personal");
        } catch (Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return personalRest;
    }

    public List<PersonalEmployeeRest> getAll() {
        return personalRepository.findAll();
    }

    public List<PersonalEmployeeRest> getAllBy(String idTenant) {
        return personalRepository.findAllBy(idTenant);
    }
}
