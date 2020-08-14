package at.ciit.dynamic_query.rest;

import at.ciit.dynamic_query.dto.SearchDto;
import at.ciit.dynamic_query.services.DynamicSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/rest/search")
public class DynamicSearchRestController {

    @Autowired
    private DynamicSearchService dynamicSearchService;

    @PostMapping()
    public ResponseEntity<?> search(@RequestBody SearchDto searchDto) {
        List<?> search = dynamicSearchService.search(searchDto);
        return ResponseEntity.ok(search);
    }
}
