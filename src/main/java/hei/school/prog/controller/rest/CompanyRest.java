package hei.school.prog.controller.rest;

import lombok.Getter;

import java.util.List;

@Getter
public record CompanyRest(String id, String name, List<RentRest> allRent, List<LendRest> allLend, List<PersonalEmployeeRest> personals) {
}
