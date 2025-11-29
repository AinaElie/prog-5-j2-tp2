package hei.school.prog.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal")
public class JPersonal {
    @Id
    @Column(name = "personal_id")
    private String id;

    @Column(name = "personal_name")
    private String name;
}
