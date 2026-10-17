package com.spring.ai.lab.rag.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.ai.lab.rag.lifecycle.KnowledgeLifecycleService;
import com.spring.ai.lab.rag.lifecycle.model.KnowledgeRequest;

@RestController
@RequestMapping("/api/admin/lifecycle")
@RequiredArgsConstructor
class LifecycleController {

    private final KnowledgeLifecycleService knowledgeLifecycleService;

    @PostMapping("/ingest")
    public ResponseEntity<Object> ingest(@RequestBody KnowledgeRequest request) throws Exception {
        knowledgeLifecycleService.ingest(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody KnowledgeRequest request) throws Exception {
        knowledgeLifecycleService.delete(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ingest-all")
    public ResponseEntity<Object> ingestAll() throws Exception {
        knowledgeLifecycleService.ingestAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Object> deleteAll() {
        knowledgeLifecycleService.deleteAll();
        return ResponseEntity.ok().build();
    }

}
