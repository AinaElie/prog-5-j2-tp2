package hei.school.prog.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal_tenant")
public class JPersonalAndTenant {
    @Id
    @Column(name = "personal_tenant_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private JTenant tenant;

    @ManyToOne
    @JoinColumn(name = "personal_id")
    private JPersonal personal;
}
