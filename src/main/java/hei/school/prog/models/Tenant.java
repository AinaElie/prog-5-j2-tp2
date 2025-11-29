package hei.school.prog.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Tenant {
    private final String name;
    private final List<Renting> allRenting;
    private final List<Personal> allPersonal;
    private final List<Lend> allLending;

    public Tenant(String name, List<Renting> allRenting, List<Personal> allPersonal, List<Lend> allLending) {
        this.name = name;
        this.allRenting = allRenting;
        this.allPersonal = allPersonal;
        this.allLending = allLending;
    }
}
