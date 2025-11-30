package hei.school.prog.models;

import lombok.Getter;

import java.time.LocalDateTime;

public record Lend(double value, LocalDateTime dateOfLend, LocalDateTime dateOfReturn, double interest) {
}
