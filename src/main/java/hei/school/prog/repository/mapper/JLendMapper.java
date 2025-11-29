package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JLend;
import hei.school.prog.models.Lend;
import hei.school.prog.models.Money;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JLendMapper {
    private final JMoneyMapper jMoneyMapper;

    public Lend toDomain(JLend jLend) {
        return new Lend(jMoneyMapper.toDomain(jLend.getMoney()), jLend.getDateOfLend(), jLend.getDateOfReturn(), jLend.getInterest());
    }

    public List<Lend> toDomain(List<JLend> allJLend) {
        List<Lend> lends = new ArrayList<>();

        for (JLend jlend : allJLend) {
            lends.add(toDomain(jlend));
        }

        return lends;
    }

    public JLend toEntity(Lend lend, String id, String idMoney) {
        return new JLend(id, lend.dateOfLend(), lend.dateOfReturn(), lend.interest(), jMoneyMapper.toEntity(lend.money(), idMoney));
    }
}
