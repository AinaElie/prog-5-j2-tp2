package hei.school.prog.models;


import java.time.LocalDateTime;

public record Renting(RentingType type, double value, LocalDateTime rentStart, LocalDateTime rentEnd) {
}
