package edu.oregonstate.engr.classwork.backend.service;
/*
 * Description: Service layer that is dedicated to handling business logic.
 */

import edu.oregonstate.engr.classwork.backend.model.DiagnosticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DiagnosticService {

    private final DiagnosticRepository diagnosticRepository;

    @Autowired // constructor injection
    public DiagnosticService(DiagnosticRepository diagnosticRepository) {
        this.diagnosticRepository = diagnosticRepository;
    }

    public List<Map<String, Object>> executeQueries() {
        diagnosticRepository.dropTable();
        diagnosticRepository.createTable();
        diagnosticRepository.insertData();
        return diagnosticRepository.fetchData();
    }
}