package hei.school.prog.controller;

import hei.school.prog.controller.rest.CompanyRest;
import hei.school.prog.models.Company;
import hei.school.prog.services.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TenantController {
    private final TenantService tenantService;

    @PostMapping("/company/create")
    public CompanyRest create(@RequestBody Company company) {
        return tenantService.create(company);
    }

    @GetMapping("/{id}/company")
    public CompanyRest getOne(@PathVariable(name = "id") String idTenant) {
        return tenantService.getById(idTenant);
    }
}
