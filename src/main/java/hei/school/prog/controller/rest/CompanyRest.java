package hei.school.prog.controller.rest;


import java.util.List;

public record CompanyRest(String id, String name, List<RentRest> allRent, List<LendRest> allLend, List<PersonalEmployeeRest> personals) {
}
