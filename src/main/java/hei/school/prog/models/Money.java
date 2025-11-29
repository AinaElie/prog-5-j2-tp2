package hei.school.prog.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static hei.school.prog.models.MoneyType.ARIARY;

@ToString
@EqualsAndHashCode
@Getter
public class Money {
    private final double amount;
    private final MoneyType type;

    public Money(double amount) {
        this.amount = amount;
        this.type = ARIARY;
    }

    public Money add(Money newMoney) {
        double newAmount = this.amount + newMoney.amount;
        return new Money(newAmount);
    }
}
