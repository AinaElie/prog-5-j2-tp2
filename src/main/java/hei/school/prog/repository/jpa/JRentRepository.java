package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JRenting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JRentRepository extends JpaRepository<JRenting, String> {
    List<JRenting> findAllByIdTenant(String idTenant);
}
