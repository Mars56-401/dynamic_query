package at.ciit.dynamic_query.entities;

import at.ciit.dynamic_query.constants.State;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "FEATURE")
public class Feature {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;
}
