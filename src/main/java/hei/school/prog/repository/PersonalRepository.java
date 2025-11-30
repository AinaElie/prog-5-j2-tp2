package hei.school.prog.repository;

import hei.school.prog.controller.mapper.PersonalRestMapper;
import hei.school.prog.controller.rest.PersonalEmployeeRest;
import hei.school.prog.controller.rest.PersonalRest;
import hei.school.prog.models.Personal;
import hei.school.prog.repository.jpa.JPersonalRepository;
import hei.school.prog.repository.mapper.JPersonalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
@AllArgsConstructor
public class PersonalRepository {
    private final JPersonalRepository jPersonalRepository;
    private final RentRepository rentRepository;
    private final LendRepository lendRepository;
    private final PersonalRestMapper personalRestMapper;
    private final JPersonalMapper jPersonalMapper;

    public PersonalRest create(Personal personal, String idTenant) {
        String id = randomUUID().toString();
        return personalRestMapper.toEntity(jPersonalRepository.save(jPersonalMapper.toEntity(personal, idTenant, id)), rentRepository.saveAll(personal.getAllRenting(), id), lendRepository.saveAll(personal.getAllLending(), id));
    }

    public List<PersonalRest> saveAll(List<Personal> personals, String idTenant) {
        List<PersonalRest> personalRests = new ArrayList<>();

        for (Personal personal : personals) {
            personalRests.add(create(personal, idTenant));
        }

        return personalRests;
    }

    public List<PersonalEmployeeRest> findAllBy(String idTenant) {
        return personalRestMapper.toEntity(jPersonalRepository.findAllByIdTenant(idTenant));
    }

    public List<PersonalEmployeeRest> findAll() {
        return personalRestMapper.toEntity(jPersonalRepository.findAll());
    }

}
