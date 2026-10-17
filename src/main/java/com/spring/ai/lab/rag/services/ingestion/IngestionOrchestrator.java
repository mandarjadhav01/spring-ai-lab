package com.spring.ai.lab.rag.services.ingestion;

import com.spring.ai.lab.rag.lifecycle.model.KnowledgeRequest;
import com.spring.ai.lab.rag.lifecycle.model.SourceType;
import com.spring.ai.lab.rag.services.ingestion.db.DatabaseIngestionService;
import com.spring.ai.lab.rag.services.ingestion.model.IngestedDocument;
import com.spring.ai.lab.rag.services.ingestion.wiki.WikiIngestionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngestionOrchestrator {

    private final PdfIngestionService  pdfIngestionService;
    private final WikiIngestionService  wikiIngestionService;
    private final DatabaseIngestionService   databaseIngestionService;

    public List<IngestedDocument> ingest(KnowledgeRequest request) throws Exception{
        SourceType source = request.getSourceType();
        if (source.equals(SourceType.PDF)) {
            return pdfIngestionService.ingest(request.getName());
        }
        if (source.equals(SourceType.WIKI)) {
            return wikiIngestionService.ingest(request.getName());
        }
        if (source.equals(SourceType.DATABASE)) {
            return databaseIngestionService.ingest(request.getName());
        }
        return Collections.emptyList();
    }

    public List<IngestedDocument> ingestAll() throws  Exception {
        List<IngestedDocument> docs = new ArrayList<>();
        docs.addAll(pdfIngestionService.ingestPdfs());
        docs.addAll(wikiIngestionService.ingestWikiFiles());
        docs.addAll(databaseIngestionService.ingestDatabaseContent());
        return docs;
    }

}
