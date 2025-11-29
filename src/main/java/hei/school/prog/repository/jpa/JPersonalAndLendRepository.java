package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JLend;
import hei.school.prog.entity.JPersonalAndLend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPersonalAndLendRepository extends JpaRepository<JPersonalAndLend, String> {
    List<JLend> findAllBy(String idPersonal);
}
