package hei.school.prog.controller.rest;

import lombok.Getter;

import java.util.List;

@Getter
public record PersonalRest(String id, String idTenant, String name, List<RentRest> allRent, List<LendRest> allLend) {
}
