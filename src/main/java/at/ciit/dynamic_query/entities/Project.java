package at.ciit.dynamic_query.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PROJECT")
public class Project {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne
    @JoinColumn(name = "LEADER_ID")
    private User leader;
}
