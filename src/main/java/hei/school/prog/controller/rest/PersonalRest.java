package hei.school.prog.controller.rest;

import java.util.List;

public record PersonalRest(String id, String idTenant, String name, List<RentRest> allRent, List<LendRest> allLend) {
}
