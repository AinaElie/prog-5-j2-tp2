package hei.school.prog.repository;

import hei.school.prog.controller.mapper.LendRestMapper;
import hei.school.prog.controller.rest.LendRest;
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
    private final LendRestMapper lendRestMapper;

    public LendRest createLend(Lend lend, String idTenant) {
        return lendRestMapper.toEntity(jLendRepository.save(jLendMapper.toEntity(lend, idTenant, randomUUID().toString())));
    }

    public List<LendRest> saveAll(List<Lend> allLend, String idTenant) {
        List<LendRest> lendRestList = new ArrayList<>();

        for (Lend lend : allLend) {
            lendRestList.add(createLend(lend, idTenant));
        }

        return lendRestList;
    }

    public List<LendRest> findAllBy(String idTenant) {
        return lendRestMapper.toEntity(jLendRepository.findAllByIdTenant(idTenant));
    }

    public List<LendRest> findAll() {
        return lendRestMapper.toEntity(jLendRepository.findAll());
    }
}
