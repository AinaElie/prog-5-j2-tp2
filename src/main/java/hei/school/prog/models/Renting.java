package hei.school.prog.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class Renting {
    private final RentingType type;
    private final double value;
    private final LocalDateTime rentStart;
    private final LocalDateTime rentEnd;

    public Renting(RentingType type, double value, LocalDateTime rentStart, LocalDateTime rentEnd) {
        this.type = type;
        this.value = value;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
    }
}
