package hei.school.prog.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal_lend")
public class JPersonalAndLend {
    @Id
    @Column(name = "personal_lend_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private JPersonal personal;

    @ManyToOne
    @JoinColumn(name = "lend_id")
    private JLend lend;
}
