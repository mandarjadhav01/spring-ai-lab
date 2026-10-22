package com.spring.ai.lab.rag.retrieval;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.ai.lab.rag.model.RetrievalResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class KeywordSearchService {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public List<RetrievalResult> search(String query) {
        String sql = """
                SELECT content, metadata
                FROM vector_store
                WHERE to_tsvector('english', content)
                @@ plainto_tsquery('english', ?)
                LIMIT 3
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            RetrievalResult result = new RetrievalResult();

            result.setContent(rs.getString("content"));
            PGobject metadataObject = (PGobject) rs.getObject("metadata");

            Map<String, Object> metadata = null;
            try {
                metadata = objectMapper.readValue(metadataObject.getValue(), new TypeReference<>() {});
            } catch (JsonProcessingException e) {
                log.error("Error: {} ", e.getMessage());
            }
            result.setMetadata(metadata);

            result.setRetrievalType("KEYWORD");
            result.setFinalScore(0.7);

            return result;
        }, query);
    }
}
