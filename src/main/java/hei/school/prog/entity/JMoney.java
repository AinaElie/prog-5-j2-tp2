package hei.school.prog.entity;

import hei.school.prog.models.MoneyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "money")
public class JMoney {
    @Id
    @Column(name = "money_id")
    private String id;

    private String amount;

    @Enumerated(STRING)
    private MoneyType type;
}
