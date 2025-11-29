package hei.school.prog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tenant")
public class JTenant {
    @Id
    @Column(name = "tenant_id")
    private String id;

    @Column(name = "tenant_name")
    private String name;
}
