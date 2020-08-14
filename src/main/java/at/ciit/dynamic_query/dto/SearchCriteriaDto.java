package at.ciit.dynamic_query.dto;

import at.ciit.dynamic_query.constants.search.CriteriaOperation;
import at.ciit.dynamic_query.constants.search.FieldJunction;
import lombok.Data;

@Data
public class SearchCriteriaDto {
    private String fieldName;
    private CriteriaOperation operation;
    private FieldJunction fieldJunction = FieldJunction.AND;
    private String filterValue;
}
