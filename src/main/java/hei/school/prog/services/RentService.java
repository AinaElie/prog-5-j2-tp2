package hei.school.prog.services;

import hei.school.prog.controller.rest.RentRest;
import hei.school.prog.models.Renting;
import hei.school.prog.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RentService {
    private final RentRepository rentRepository;

    public RentRest create(Renting rent, String idTenant) {
        RentRest rentRest = null;

        try{
            rentRest = rentRepository.createRent(rent, idTenant);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentRest;
    }

    public List<RentRest> getAllRents() {
        List<RentRest> rentRests = new ArrayList<>();

        try{
            rentRests = rentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentRests;
    }

    public List<RentRest> getAllBy(String idTenant) {
        List<RentRest> rentRests = new ArrayList<>();

        try{
            rentRests = rentRepository.findAllBy(idTenant);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rentRests;
    }
}
