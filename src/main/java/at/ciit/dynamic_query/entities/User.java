package at.ciit.dynamic_query.entities;

import at.ciit.dynamic_query.constants.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "REL_USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_REL_ID"))
    @Column(name = "ROLE")
    @Enumerated(value = EnumType.STRING)
    private Set<Role> role;

}
