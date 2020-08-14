package at.ciit.dynamic_query.repositories;

import at.ciit.dynamic_query.entities.Feature;
import at.ciit.dynamic_query.entities.Task;
import at.ciit.dynamic_query.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TaskRepo extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {
}
