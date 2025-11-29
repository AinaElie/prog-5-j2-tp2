package hei.school.prog.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenant_lend")
public class JTenantAndLend {
    @Id
    @Column(name = "tenant_lend_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private JTenant tenant;

    @ManyToOne
    @JoinColumn(name = "lend_id")
    private JLend lend;
}
