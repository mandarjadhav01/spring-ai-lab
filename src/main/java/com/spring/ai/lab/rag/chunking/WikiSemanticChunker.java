package com.spring.ai.lab.rag.chunking;

import com.spring.ai.lab.rag.chunking.model.Chunk;
import com.spring.ai.lab.rag.services.ingestion.model.IngestedDocument;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WikiSemanticChunker {

    public List<Chunk> chunk(IngestedDocument document) {
        List<Chunk> chunks = new ArrayList<>();

        String content = document.getContent();

        // Split by Markdown headings (##, ###, etc.)
        String[] sections = content.split("\n(?=#+\\s)");

        int chunkIndex = 0;

        for (String section : sections) {
            String trimmed = section.trim();
            if (trimmed.isEmpty()) {
                continue;
            }

            Map<String, Object> chunkMetadata = new HashMap<>(document.getMetadata());
            chunkMetadata.put("chunkIndex", chunkIndex);
            chunkMetadata.put("chunkType", "WIKI_SECTION");

            chunks.add(new Chunk(
                    document.getSource(),
                    trimmed,
                    chunkMetadata,
                    chunkIndex
            ));
            chunkIndex++;
        }

        return chunks;
    }
}
