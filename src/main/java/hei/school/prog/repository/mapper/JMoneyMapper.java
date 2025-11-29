package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JMoney;
import hei.school.prog.models.Money;
import org.springframework.stereotype.Component;

@Component
public class JMoneyMapper {
    public Money toDomain(JMoney jmoney) {
        return new Money(jmoney.getAmount());
    }

    public JMoney toEntity(Money money, String id) {
        return new JMoney(id, money.getAmount(), money.getType());
    }
}
