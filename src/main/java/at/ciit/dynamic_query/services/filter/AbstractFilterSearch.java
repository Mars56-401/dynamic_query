package at.ciit.dynamic_query.services.filter;


import at.ciit.dynamic_query.constants.search.FieldJunction;
import at.ciit.dynamic_query.dto.SearchCriteriaDto;
import at.ciit.dynamic_query.dto.SearchDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class AbstractFilterSearch<T> {

    //region CREATE DYN FILTER SPEC
    //region PUBLIC
    public Specification<T> createDynSpecification(SearchDto searchDto) {
        Specification<T> spec = Specification.where(null);
        if (!CollectionUtils.isEmpty(searchDto.getFilters())) {
            for (SearchCriteriaDto searchCriteria : searchDto.getFilters()) {
                if (!StringUtils.isEmpty(searchCriteria.getFilterValue())) {
                    spec = createSingleDynFilter(spec, searchCriteria);
                }
            }
        }
        return spec;
    }
    //endregion PUBLIC

    //region PRIVATE
    private Specification<T> createSingleDynFilter(Specification<T> spec, SearchCriteriaDto searchCriteria) {
        if (searchCriteria != null && searchCriteria.getFieldName() != null) {
            switch (searchCriteria.getOperation()) {
                case EQUALS:
                    return addToSpec(spec, specEqual(searchCriteria.getFieldName(), searchCriteria.getFilterValue()), searchCriteria.getFieldJunction());
                case LIKE:
                    return addToSpec(spec, specLike(searchCriteria.getFieldName(), searchCriteria.getFilterValue()), searchCriteria.getFieldJunction());
                case GREATER:
                    return addToSpec(spec, specGreater(searchCriteria.getFieldName(), searchCriteria.getFilterValue()), searchCriteria.getFieldJunction());
                case GREATER_OR_EQUALS:
                    return addToSpec(spec, specGreaterOrEquals(searchCriteria.getFieldName(), searchCriteria.getFilterValue()), searchCriteria.getFieldJunction());
                case LESS:
                    return addToSpec(spec, specLess(searchCriteria.getFieldName(), searchCriteria.getFilterValue()), searchCriteria.getFieldJunction());
                case LESS_OR_EQUALS:
                    return addToSpec(spec, specLessOrEquals(searchCriteria.getFieldName(), searchCriteria.getFilterValue()), searchCriteria.getFieldJunction());
                default:
                    throw new IllegalArgumentException(String.format("Filter operation '%s' is not supported yet.", searchCriteria.getOperation()));
            }
        }
        return spec;
    }

    private Specification<T> addToSpec(Specification<T> spec, Specification<T> filterCondition, FieldJunction condition) {
        if (spec == null) return Specification.where(filterCondition);
        if (filterCondition == null) return spec;
        switch (condition) {
            case OR:
                return spec.or(filterCondition);
            case AND:
            default:
                return spec.and(filterCondition);
        }
    }
    //endregion
    //endregion

    //region Specifications
    protected Specification<T> specLike(String field, String filterValue) {
        if (field == null || filterValue == null) return Specification.where(null);
        return (root, query, criteriaBuilder) -> toPredicateLike(root, criteriaBuilder, field, filterValue);
    }

    protected Specification<T> specEqual(String field, String filterValue) {
        if (field == null || filterValue == null) return Specification.where(null);
        return (root, query, criteriaBuilder) -> toPredicateEqual(root, criteriaBuilder, field, filterValue);
    }

    protected Specification<T> specLess(String field, String filterValue) {
        if (field == null || filterValue == null) return Specification.where(null);
        return (root, query, criteriaBuilder) -> toPredicateLess(root, criteriaBuilder, field, filterValue);
    }

    protected Specification<T> specLessOrEquals(String field, String filterValue) {
        if (field == null || filterValue == null) return Specification.where(null);
        return (root, query, criteriaBuilder) -> toPredicateLessOrEquals(root, criteriaBuilder, field, filterValue);
    }

    protected Specification<T> specGreater(String field, String filterValue) {
        if (field == null || filterValue == null) return Specification.where(null);
        return (root, query, criteriaBuilder) -> toPredicateGreater(root, criteriaBuilder, field, filterValue);
    }

    protected Specification<T> specGreaterOrEquals(String field, String filterValue) {
        if (field == null || filterValue == null) return Specification.where(null);
        return (root, query, criteriaBuilder) -> toPredicateGreaterOrEquals(root, criteriaBuilder, field, filterValue);
    }
    //endregion

    //region Predicates
    Predicate toPredicateLike(Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String filterValue) {
        return criteriaBuilder.like(root.get(fieldName), "%" + filterValue + "%");
    }

    Predicate toPredicateEqual(Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String filterValue) {
        return criteriaBuilder.equal(root.get(fieldName), filterValue);
    }

    Predicate toPredicateLess(Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String filterValue) {
        return criteriaBuilder.lessThan(root.get(fieldName), filterValue);
    }

    Predicate toPredicateLessOrEquals(Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String filterValue) {
        return criteriaBuilder.lessThanOrEqualTo(root.get(fieldName), filterValue);
    }

    Predicate toPredicateGreater(Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String filterValue) {
        return criteriaBuilder.greaterThan(root.get(fieldName), filterValue);
    }

    Predicate toPredicateGreaterOrEquals(Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String filterValue) {
        return criteriaBuilder.greaterThanOrEqualTo(root.get(fieldName), filterValue);
    }
    //endregion
}
