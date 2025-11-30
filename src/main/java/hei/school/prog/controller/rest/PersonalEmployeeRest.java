package hei.school.prog.controller.rest;

import lombok.Getter;

@Getter
public record PersonalEmployeeRest(String id, String idTenant, String name) {
}
