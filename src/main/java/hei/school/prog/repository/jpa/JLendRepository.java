package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JLend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JLendRepository extends JpaRepository<JLend, String> {
    List<JLend> findAllByIdTenant(String idTenant);
}
