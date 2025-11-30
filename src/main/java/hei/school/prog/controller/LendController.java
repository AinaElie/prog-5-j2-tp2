package hei.school.prog.controller;

import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.models.Lend;
import hei.school.prog.services.LendService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LendController {
    private final LendService lendService;

    @PostMapping("/{id}/lend/create/")
    public LendRest createLend(@RequestBody Lend lend, @PathVariable(name = "id") String idTenant) {
        return lendService.createLend(lend, idTenant);
    }

    @GetMapping("/lends")
    public List<LendRest> getAllLends() {
        return lendService.getAllLends();
    }

    @GetMapping("/{id}/lends")
    public List<LendRest> getLends(@PathVariable(name = "id") String idTenant) {
        return lendService.getAllBy(idTenant);
    }
}
