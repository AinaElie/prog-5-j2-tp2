package hei.school.prog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lend")
public class JLend {
    @Id
    @Column(name = "lend_id")
    private String id;

    @Column(name = "date_of_lend")
    private LocalDateTime dateOfLend;

    @Column(name = "date_of_return")
    private LocalDateTime dateOfReturn;

    private double interest;

    @ManyToOne
    @JoinColumn(name = "money_id")
    private JMoney money;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private JPersonal personal;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private JTenant tenant;
}
