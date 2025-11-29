package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JRenting;
import hei.school.prog.models.Personal;
import hei.school.prog.models.Renting;
import hei.school.prog.models.Tenant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class JRentingMapper {
    private final JTenantMapper jTenantMapper;
    private final JPersonalMapper jPersonalMapper;

    public Renting toDomain(JRenting jRenting) {
        return new Renting(jRenting.getType(), jRenting.getValue(), jRenting.getRentStart(), jRenting.getRentEnd());
    }

    public List<Renting> toDomain(List<JRenting> allRenting) {
        List<Renting> newRenting = new ArrayList<>();

        for (JRenting jRenting : allRenting) {
            newRenting.add(toDomain(jRenting));
        }

        return newRenting;
    }

    public JRenting toEntity(Renting renting, String id, Tenant tenant, String idTenant, Personal personal, String idPersonal) {
        return new JRenting(id, renting.getType(), renting.getValue(), renting.getRentStart(), renting.getRentEnd(),
                jPersonalMapper.toEntity(personal, idPersonal),
                jTenantMapper.toEntity(tenant, idTenant)
        );
    }
}
