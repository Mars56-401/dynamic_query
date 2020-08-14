package at.ciit.dynamic_query.services;

import at.ciit.dynamic_query.dto.SearchDto;
import at.ciit.dynamic_query.repositories.FeatureRepo;
import at.ciit.dynamic_query.repositories.ProjectRepo;
import at.ciit.dynamic_query.repositories.TaskRepo;
import at.ciit.dynamic_query.repositories.UserRepo;
import at.ciit.dynamic_query.services.filter.FeatureFilterSearch;
import at.ciit.dynamic_query.services.filter.ProjectFilterSearch;
import at.ciit.dynamic_query.services.filter.TaskFilterSearch;
import at.ciit.dynamic_query.services.filter.UserFilterSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DynamicSearchService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserFilterSearch userFilterSearch;
    @Autowired
    private FeatureRepo featureRepo;
    @Autowired
    private FeatureFilterSearch featureFilterSearch;
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private TaskFilterSearch taskFilterSearch;
    @Autowired
    private ProjectRepo projectRepo;
    @Autowired
    private ProjectFilterSearch projectFilterSearch;

    public List<?> search(SearchDto searchDto) {
        switch (searchDto.getResultType()) {
            case FEATURE:
                return featureRepo.findAll(featureFilterSearch.createDynSpecification(searchDto));
            case PROJECT:
                return projectRepo.findAll(projectFilterSearch.createDynSpecification(searchDto));
            case TASK:
                return taskRepo.findAll(taskFilterSearch.createDynSpecification(searchDto));
            case USER:
                return userRepo.findAll(userFilterSearch.createDynSpecification(searchDto));
            default:
                throw new IllegalArgumentException("ResultType is not supported");
        }
    }
}
