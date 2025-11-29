package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JTenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JTenantRepository extends JpaRepository<JTenant, String> {
}
