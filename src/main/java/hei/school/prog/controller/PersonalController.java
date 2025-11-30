package hei.school.prog.controller;

import hei.school.prog.controller.rest.PersonalRest;
import hei.school.prog.models.Personal;
import hei.school.prog.services.PersonalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @PostMapping("/{id}/personal/create")
    public PersonalRest create(@RequestBody Personal personal, @PathVariable(name = "id") String idTenant) {
        return personalService.create(personal, idTenant);
    }
}
