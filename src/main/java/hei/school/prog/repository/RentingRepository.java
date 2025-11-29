package hei.school.prog.repository;

import hei.school.prog.entity.JLend;
import hei.school.prog.entity.JRenting;
import hei.school.prog.models.Personal;
import hei.school.prog.models.Renting;
import hei.school.prog.models.Tenant;
import hei.school.prog.repository.jpa.JRentingRepository;
import hei.school.prog.repository.mapper.JRentingMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
@AllArgsConstructor
public class RentingRepository {
    private final JRentingRepository jRentingRepository;
    private final JRentingMapper jRentingMapper;

    public Renting save(Renting renting, Tenant tenant, Personal personal) {
        return jRentingMapper.toDomain(jRentingRepository.save(jRentingMapper.toEntity(
                renting,
                randomUUID().toString(),
                tenant,
                randomUUID().toString(),
                personal,
                randomUUID().toString()
        )));
    }

    public List<Renting> findAll() {
        List<JRenting> jAllRenting = jRentingRepository.findAll();
        List<Renting> allRenting = new ArrayList<>();

        for (JRenting jRenting : jAllRenting) {
            allRenting.add(jRentingMapper.toDomain(jRenting));
        }

        return allRenting;
    }
}
