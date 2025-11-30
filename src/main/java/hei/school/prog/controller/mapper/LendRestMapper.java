package hei.school.prog.controller.mapper;

import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.entity.JLend;
import hei.school.prog.models.Lend;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class LendRestMapper {
    public LendRest toEntity(JLend jLend) {
        return new LendRest(
                jLend.getId(),
                jLend.getIdTenant(),
                new Lend(jLend.getValue(), jLend.getDateOfLend(), jLend.getDateOfReturn(), jLend.getInterest())
        );
    }

    public List<LendRest> toEntity(List<JLend> jLends) {
        List<LendRest> lendRests = new ArrayList<>();

        for (JLend jLend : jLends) {
            lendRests.add(toEntity(jLend));
        }
        return lendRests;
    }
}
