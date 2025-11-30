package hei.school.prog.services;

import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.models.Lend;
import hei.school.prog.repository.LendRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LendService {
    private static final Logger log = LoggerFactory.getLogger(LendService.class);
    private final LendRepository lendRepository;

    public LendRest createLend(Lend lend, String idTenant) {
        LendRest newLendRest;
        try{
            newLendRest = lendRepository.createLend(lend, idTenant);
            log.info("Creation New Lend");
        }catch(Exception e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return newLendRest;
    }

    public List<LendRest> getAllLends() {
        List<LendRest> lendRestList;

        try{
            lendRestList = lendRepository.findAll();
            log.info("Get Lends Successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return lendRestList;
    }

    public List<LendRest> getAllBy(String idTenant) {
        List<LendRest> lendRestList;

        try {
            lendRestList = lendRepository.findAllBy(idTenant);
            log.info("Get Lends by Id Successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return lendRestList;
    }
}
