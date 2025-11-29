package hei.school.prog.repository;

import hei.school.prog.entity.JLend;
import hei.school.prog.entity.JTenant;
import hei.school.prog.models.Tenant;
import hei.school.prog.repository.jpa.JTenantRepository;
import hei.school.prog.repository.mapper.JTenantMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
@AllArgsConstructor
public class TenantRepository {
    private final JTenantRepository jTenantRepository;
    private final JTenantMapper jTenantMapper;

    public Tenant save(Tenant tenant) {
        return jTenantMapper.toDomain(jTenantRepository.save(jTenantMapper.toEntity(tenant, randomUUID().toString())));
    }

    public List<Tenant> findAll() {
        List<JTenant> jTenants = jTenantRepository.findAll();
        List<Tenant> allTenant = new ArrayList<>();

        for (JTenant jTenant : jTenants) {
            allTenant.add(jTenantMapper.toDomain(jTenant));
        }

        return allTenant;
    }
}
