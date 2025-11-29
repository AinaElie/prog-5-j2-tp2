package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JTenant;
import hei.school.prog.models.Tenant;
import hei.school.prog.repository.jpa.JPersonalAndTenantRepository;
import hei.school.prog.repository.jpa.JRentingRepository;
import hei.school.prog.repository.jpa.JTenantAndLendRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JTenantMapper {
    private final JRentingRepository jRentingRepository;
    private final JRentingMapper jRentingMapper;
    private final JTenantAndLendRepository jTenantAndLendRepository;
    private final JLendMapper jLendMapper;
    private final JPersonalAndTenantRepository jPersonalAndTenantRepository;
    private final JPersonalMapper jPersonalMapper;

    public Tenant toDomain(JTenant jTenant) {
        return new Tenant(jTenant.getName(),
                jRentingMapper.toDomain(jRentingRepository.findAllBy(jTenant.getId())),
                jPersonalMapper.toDomain(jPersonalAndTenantRepository.findAllBy(jTenant.getId())),
                jLendMapper.toDomain(jTenantAndLendRepository.findAllBy(jTenant.getId()))
        );
    }

    public JTenant toEntity(Tenant tenant, String id) {
        return new JTenant(id, tenant.getName());
    }
}
