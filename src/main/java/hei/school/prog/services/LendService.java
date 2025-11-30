package hei.school.prog.services;

import hei.school.prog.controller.rest.LendRest;
import hei.school.prog.models.Lend;
import hei.school.prog.repository.LendRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LendService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LendService.class);
    private final LendRepository lendRepository;

    public LendRest createLend(Lend lend, String idTenant) {
        LendRest newLendRest;
        try{
            newLendRest = lendRepository.createLend(lend, idTenant);
            LOGGER.info("Creation New Lend");
        }catch(Exception e){
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return newLendRest;
    }

    public List<LendRest> getAllLends() {
        List<LendRest> lendRestList;

        try{
            lendRestList = lendRepository.findAll();
            LOGGER.info("Get Lends Successfully");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return lendRestList;
    }

    public List<LendRest> getAllBy(String idTenant) {
        List<LendRest> lendRestList;

        try {
            lendRestList = lendRepository.findAllBy(idTenant);
            LOGGER.info("Get Lends by Id Successfully");
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return lendRestList;
    }
}
