package hei.school.prog.controller.mapper;

import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.entity.JLend;
import hei.school.prog.entity.JRenting;
import hei.school.prog.models.Lend;
import hei.school.prog.models.Renting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class RentRestMapper {
    public RentRest toEntity(JRenting jRenting) {
        return new RentRest(
                jRenting.getId(),
                jRenting.getIdTenant(),
                new Renting(jRenting.getType(), jRenting.getValue(), jRenting.getRentStart(), jRenting.getRentEnd())
        );
    }

    public List<RentRest> toEntity(List<JRenting> allRenting) {
        List<RentRest> rentRests = new ArrayList<>();

        for (JRenting jRenting : allRenting) {
            rentRests.add(toEntity(jRenting));
        }
        return rentRests;
    }
}
