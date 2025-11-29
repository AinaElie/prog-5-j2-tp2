package hei.school.prog.repository;

import hei.school.prog.entity.JMoney;
import hei.school.prog.models.Money;
import hei.school.prog.repository.jpa.JMoneyRepository;
import hei.school.prog.repository.mapper.JMoneyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
@AllArgsConstructor
public class MoneyRepository {
    private final JMoneyRepository jMoneyRepository;
    private final JMoneyMapper jMoneyMapper;

    public Money save(Money money) {
        return jMoneyMapper.toDomain(jMoneyRepository.save(jMoneyMapper.toEntity(money, randomUUID().toString())));
    }

    public List<Money> findAll() {
        List<JMoney> jMonies = jMoneyRepository.findAll();
        List<Money> monies = new ArrayList<>();

        for (JMoney jMoney : jMonies) {
            monies.add(jMoneyMapper.toDomain(jMoney));
        }

        return monies;
    }
}
