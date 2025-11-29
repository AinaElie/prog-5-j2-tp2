package hei.school.prog.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "\"user\"")
public class JUser {
    @Id
    @Column(name = "id_User", unique=true, nullable=false)
    private String id;

    @Column(name = "user_name", nullable=false)
    private String name;

    @Column(name = "user_mail", nullable=false)
    private String email;
}
