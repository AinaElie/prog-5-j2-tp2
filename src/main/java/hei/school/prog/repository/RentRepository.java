package hei.school.prog.repository;

import hei.school.prog.controller.mapper.RentRestMapper;
import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.models.Renting;
import hei.school.prog.repository.jpa.JRentRepository;
import hei.school.prog.repository.mapper.JRentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
@AllArgsConstructor
public class RentRepository {
    private final JRentRepository jrentRepository;
    private final JRentMapper jRentMapper;
    private final RentRestMapper rentRestMapper;

    public RentRest createRent(Renting renting, String idTenant) {
        return rentRestMapper.toEntity(jrentRepository.save(jRentMapper.toEntity(renting, idTenant, randomUUID().toString())));
    }

    public List<RentRest> saveAll(List<Renting> AllRenting, String idTenant) {
        List<RentRest> rentRestList = new ArrayList<>();

        for (Renting renting : AllRenting) {
            rentRestList.add(createRent(renting, idTenant));
        }

        return rentRestList;
    }

    public List<RentRest> findAllBy(String idTenant) {
        return rentRestMapper.toEntity(jrentRepository.findAllByIdTenant(idTenant));
    }

    public List<RentRest> findAll() {
        return rentRestMapper.toEntity(jrentRepository.findAll());
    }
}
