package hei.school.prog.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(callSuper=true)
public class Company extends Tenant {
    private final List<Personal> allPersonal;

    public Company(String name, List<Renting> allRenting, List<Lend> allLending, List<Personal> allPersonal) {
        super(name, allRenting, allLending);
        this.allPersonal = allPersonal;
    }
}
