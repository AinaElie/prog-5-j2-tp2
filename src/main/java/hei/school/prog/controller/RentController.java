package hei.school.prog.controller;

import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.models.Renting;
import hei.school.prog.services.RentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RentController {
    private final RentService rentService;

    @PostMapping("/{id}/rent/create")
    public RentRest createLend(@RequestBody Renting renting, @PathVariable(name = "id") String idTenant) {
        return rentService.create(renting, idTenant);
    }

    @GetMapping("/rents")
    public List<RentRest> getAll() {
        return rentService.getAllRents();
    }

    @GetMapping("/{id}/rents")
    public List<RentRest> getRents(@PathVariable(name = "id") String idTenant) {
        return rentService.getAllBy(idTenant);
    }
}
