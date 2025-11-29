package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JPersonal;
import hei.school.prog.entity.JPersonalAndTenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPersonalAndTenantRepository extends JpaRepository<JPersonalAndTenant, String> {
    List<JPersonal> findAllBy(String id);
}
