package hei.school.prog.controller.rest;

import hei.school.prog.models.Renting;
import lombok.Getter;

@Getter
public record RentRest(String id, String idTenant, Renting renting) {
}
