package hei.school.prog.services;

import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.models.Renting;
import hei.school.prog.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RentService {
    private static final Logger log = LoggerFactory.getLogger(LendService.class);
    private final RentRepository rentRepository;

    public RentRest create(Renting rent, String idTenant) {
        RentRest rentRest;

        try{
            rentRest = rentRepository.createRent(rent, idTenant);
            log.info("Creation new rent");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return rentRest;
    }

    public List<RentRest> getAllRents() {
        List<RentRest> rentRests;

        try{
            rentRests = rentRepository.findAll();
            log.info("Get Rents Successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return rentRests;
    }

    public List<RentRest> getAllBy(String idTenant) {
        List<RentRest> rentRests;

        try{
            rentRests = rentRepository.findAllBy(idTenant);
            log.info("Get Rents by Id Successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return rentRests;
    }
}
