package hei.school.prog.services;

import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.models.Lend;
import hei.school.prog.repository.LendRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LendService {
    private final LendRepository lendRepository;

    public LendRest createLend(Lend lend, String idTenant) {
        LendRest newLendRest = null;
        try{
            newLendRest = lendRepository.createLend(lend, idTenant);
        }catch(Exception e){
            e.printStackTrace();
        }
        return newLendRest;
    }

    public List<LendRest> getAllLends() {
        List<LendRest> lendRestList = new ArrayList<>();

        try{
            lendRestList = lendRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lendRestList;
    }

    public List<LendRest> getAllBy(String idTenant) {
        List<LendRest> lendRestList = new ArrayList<>();

        try {
            lendRestList = lendRepository.findAllBy(idTenant);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lendRestList;
    }
}
