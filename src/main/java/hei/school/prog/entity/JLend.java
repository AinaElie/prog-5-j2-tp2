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

    @Column(name = "value")
    private double value;

    @Column(name = "date_of_lend")
    private LocalDateTime dateOfLend;

    @Column(name = "date_of_return")
    private LocalDateTime dateOfReturn;

    private double interest;

    @Column(name = "tenant_id", nullable = false, unique = true)
    private String idTenant;
}
