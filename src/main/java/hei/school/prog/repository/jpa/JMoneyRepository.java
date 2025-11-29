package hei.school.prog.repository.jpa;

import hei.school.prog.entity.JMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JMoneyRepository extends JpaRepository<JMoney, String> {
}
