package edu.oregonstate.engr.classwork.backend.web;
/*
 * Description: Control layer that is dedicated to handling HTTP requests.
 */

import edu.oregonstate.engr.classwork.backend.service.DiagnosticService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/*
@Controller is a marker annotation in Spring that signals Spring that your class contains methods
that can return something HTTP related (HTML, JSON, XML) to the end-user or a browser.
@ResponseBody tells Spring, that you want to write JSON or XML or plain text directly
to the HttpServletOutputstream, but without going through an HTML templating framework
 */

@RestController //combines Controller + ResponseBody annotations
public class DiagnosticController {
    
    private final JdbcTemplate jdbcTemplate;
    private final DiagnosticService diagnosticService;

    @Autowired // constructor injection
    public DiagnosticController(JdbcTemplate jdbcTemplate, DiagnosticService diagnosticService) {
        this.jdbcTemplate = jdbcTemplate;
        this.diagnosticService = diagnosticService;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*") // enables requests to be sent from any origin
    @ResponseBody //ensures the return value is converted to JSON
    public List<Map<String, Object>> executeQueries() {
        return diagnosticService.executeQueries();
    }
}
