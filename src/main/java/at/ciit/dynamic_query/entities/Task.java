package at.ciit.dynamic_query.entities;

import at.ciit.dynamic_query.constants.State;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "STATE")
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(name = "title")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne
    @JoinColumn(name = "ASSIGNEE_ID")
    private User assignee;
    @ManyToOne
    @JoinColumn(name = "FEATURE_ID")
    private Feature feature;
}
