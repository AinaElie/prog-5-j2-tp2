package hei.school.prog.repository.mapper;

import hei.school.prog.entity.JLend;
import hei.school.prog.models.Lend;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class JLendMapper {
    public JLend toEntity(Lend lend, String idTenant, String id) {
        return new JLend(
                id,
                lend.value(), lend.dateOfLend(), lend.dateOfReturn(), lend.interest(),
                idTenant
        );
    }
}
