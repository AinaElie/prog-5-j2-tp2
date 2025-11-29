package hei.school.prog.models;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public record Lend(Money money, LocalDateTime dateOfLend, LocalDateTime dateOfReturn, double interest) {
    public Lend addMoney(Money newMoney) {
        Money moneyActual = money.add(newMoney);
        return new Lend(moneyActual, dateOfLend, dateOfReturn, interest);
    }

    public Money returnMoney() {
        return new Money(0.0);
    }
}
