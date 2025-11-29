package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JLend;
import hei.school.prog.entity.JTenantAndLend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JTenantAndLendRepository extends JpaRepository<JTenantAndLend, String> {
    List<JLend> findAllBy(String id);
}
