package hei.school.prog.entity;

import hei.school.prog.models.RentingType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rent")
public class JRenting {
    @Id
    @Column(name = "rent_id")
    private String id;

    @Enumerated(STRING)
    private RentingType type;

    @Column(name = "value")
    private double value;

    @Column(name = "rent_start")
    private LocalDateTime rentStart;

    @Column(name = "rent_end")
    private LocalDateTime rentEnd;

    @Column(name = "tenant_id", nullable = false, unique = true)
    private String idTenant;
}
