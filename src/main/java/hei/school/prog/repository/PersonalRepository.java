package hei.school.prog.repository;

import hei.school.prog.entity.JPersonal;
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
    private final JPersonalMapper jPersonalMapper;
    private final JPersonalRepository jPersonalRepository;

    public Personal save(Personal personal) {
        return jPersonalMapper.toDomain(jPersonalRepository.save(jPersonalMapper.toEntity(personal, randomUUID().toString())));
    }

    public List<Personal> findAll() {
        List<JPersonal> jPersonals = jPersonalRepository.findAll();
        List<Personal> personals = new ArrayList<>();

        for (JPersonal jPersonal : jPersonals) {
            personals.add(jPersonalMapper.toDomain(jPersonal));
        }

        return personals;
    }
}
