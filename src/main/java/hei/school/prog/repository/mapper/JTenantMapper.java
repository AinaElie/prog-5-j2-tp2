package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JTenant;
import hei.school.prog.models.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JTenantMapper {
    public JTenant toEntity(Tenant tenant, String id) {
        return new JTenant(id, tenant.getName());
    }
}
