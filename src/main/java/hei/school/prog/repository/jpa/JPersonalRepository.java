package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPersonalRepository extends JpaRepository<JPersonal, String> {
}
