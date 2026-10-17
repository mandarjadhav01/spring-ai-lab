package com.spring.ai.lab.rag.prompt;

import com.spring.ai.lab.rag.chunking.model.Chunk;
import com.spring.ai.lab.rag.prompt.model.PromptContext;
import com.spring.ai.lab.rag.retrieval.model.RetrievalResult;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component 
public class ContextBuilder {

    public PromptContext build(RetrievalResult retrievalResult) {
        StringBuilder sb = new StringBuilder();

        int index = 1;
        for (Chunk chunk : retrievalResult.getChunks()) {
            sb.append("Context ").append(index++).append(":\n");
            appendCitation(sb, chunk);
            sb.append(chunk.getContent());
            sb.append("\n\n");
        }

        return new PromptContext(sb.toString().trim());
    }

    private void appendCitation(StringBuilder sb, Chunk chunk) {
        // [PDF:HR_Leave_policy.pdf]
        // [DB:faqs#5]

        Map<String, Object> metadata = chunk.getMetadata();
        String source = metadata.get("source").toString();

        switch(source) {
            case "PDF":
            case "WIKI":
                sb.append("[")
                        .append(source)
                        .append(": ").append(metadata.get("fileName"))
                        .append("]\n");
                break;
            case "DB":
                sb.append("[DB: ")
                        .append(metadata.get("table")).append("#")
                        .append(metadata.get("id"))
                        .append("]\n");
                break;
        }

    }
}
