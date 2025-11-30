package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JRenting;
import hei.school.prog.models.Renting;
import org.springframework.stereotype.Component;

@Component
public class JRentMapper {
    public JRenting toEntity(Renting renting, String idTenant, String id) {
        return new JRenting(
                id,
                renting.type(), renting.value(), renting.rentStart(), renting.rentEnd(),
                idTenant
        );
    }
}
