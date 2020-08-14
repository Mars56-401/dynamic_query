package at.ciit.dynamic_query.repositories;

import at.ciit.dynamic_query.entities.Project;
import at.ciit.dynamic_query.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProjectRepo extends JpaRepository<Project, Long>, JpaSpecificationExecutor<Project> {
}
