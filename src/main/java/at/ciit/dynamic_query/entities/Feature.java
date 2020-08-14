package at.ciit.dynamic_query.entities;

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
    private String state;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;
}
