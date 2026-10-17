package com.spring.ai.lab.rag.chunking;

import com.spring.ai.lab.rag.chunking.model.Chunk;
import com.spring.ai.lab.rag.services.ingestion.model.IngestedDocument;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseChunker {

    public List<Chunk> chunk(IngestedDocument document) {
        return List.of(
                new Chunk(
                        document.getSource(),
                        document.getContent(),
                        document.getMetadata(),
                        0
                ));
    }
}
