package at.ciit.dynamic_query.dto;

import at.ciit.dynamic_query.constants.search.SearchResults;
import lombok.Data;

import java.util.List;

@Data
public class SearchDto {
    private SearchResults resultType;
    private List<SearchCriteriaDto> filters;
}
