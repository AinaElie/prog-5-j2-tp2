package hei.school.prog.controller.rest;

import hei.school.prog.models.Lend;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public record LendRest(String id, String idTenant, Lend lend) {
}
