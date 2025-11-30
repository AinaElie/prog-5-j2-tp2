package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JPersonal;
import hei.school.prog.models.Personal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JPersonalMapper {
    public JPersonal toEntity(Personal personal, String idTenant, String id) {
        return new JPersonal(id, personal.getName(), idTenant);
    }
}
