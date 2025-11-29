package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JPersonal;
import hei.school.prog.models.Personal;
import hei.school.prog.models.Tenant;
import hei.school.prog.repository.jpa.JPersonalAndLendRepository;
import hei.school.prog.repository.jpa.JRentingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JPersonalMapper {
    private final JRentingRepository jRentingRepository;
    private final JRentingMapper jRentingMapper;
    private final JPersonalAndLendRepository jPersonalAndLendRepository;
    private final JLendMapper jLendMapper;

    public Personal toDomain(JPersonal jPersonal) {
        return new Personal(
                jPersonal.getName(),
                jRentingMapper.toDomain(jRentingRepository.findAllBy(jPersonal.getId())),
                jLendMapper.toDomain(jPersonalAndLendRepository.findAllBy(jPersonal.getId()))
        );
    }

    public List<Personal> toDomain(List<JPersonal> jPersonals) {
        List<Personal> personals = new ArrayList<>();

        for (JPersonal personal : jPersonals) {
            personals.add(toDomain(personal));
        }
        return personals;
    }

    public JPersonal toEntity(Personal personal, String id) {
        return new JPersonal(id, personal.name());
    }
}
