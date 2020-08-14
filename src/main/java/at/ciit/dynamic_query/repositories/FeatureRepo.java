package at.ciit.dynamic_query.repositories;

import at.ciit.dynamic_query.entities.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FeatureRepo extends JpaRepository<Feature, Long> , JpaSpecificationExecutor<Feature> {
}
