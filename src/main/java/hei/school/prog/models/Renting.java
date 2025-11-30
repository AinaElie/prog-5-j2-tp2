package hei.school.prog.models;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public record Renting(RentingType type, double value, LocalDateTime rentStart, LocalDateTime rentEnd) {
}
