package hei.school.prog.repository;

import hei.school.prog.entity.JLend;
import hei.school.prog.models.Lend;
import hei.school.prog.repository.jpa.JLendRepository;
import hei.school.prog.repository.mapper.JLendMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
@AllArgsConstructor
public class LendRepository {
    private final JLendRepository jLendRepository;
    private final JLendMapper jLendMapper;

    public Lend save(Lend lend) {
        String idLend = randomUUID().toString();
        String idMoney = randomUUID().toString();
        return jLendMapper.toDomain(jLendRepository.save(jLendMapper.toEntity(lend, idLend, idMoney)));
    }

    public List<Lend> findAll() {
        List<JLend> jLends = jLendRepository.findAll();
        List<Lend> allLend = new ArrayList<>();

        for (JLend jLend : jLends) {
            allLend.add(jLendMapper.toDomain(jLend));
        }

        return allLend;
    }
}
