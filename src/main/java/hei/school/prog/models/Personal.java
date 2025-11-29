package hei.school.prog.models;

import lombok.Getter;

import java.util.List;

@Getter
public record Personal(String name, List<Renting> allRenting, List<Lend> allLending) {

    public Money getValueOfAllRenting() {
        double newValue = allRenting.stream().mapToDouble(Renting::getValue).sum();
        return new Money(newValue);
    }

    public Money getValueOfAllLending() {
        double newValue = allLending.stream().mapToDouble(element -> element.returnMoney().getAmount()).sum();
        return new Money(newValue);
    }
}
