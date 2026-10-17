package com.spring.ai.lab.rag.services.ingestion.wiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.spring.ai.lab.rag.services.ingestion.model.IngestedDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class WikiIngestionService {
   
    private static final String WIKI_DIRECTORY = "data/wiki";

    public List<IngestedDocument> ingest(String fileName) throws IOException {
        File pdfFile = new File(WIKI_DIRECTORY + "/" + fileName);
        return Collections.singletonList(ingestSingleFile(pdfFile));
    }

    public List<IngestedDocument> ingestWikiFiles() throws Exception {
        File[] markdownFiles = new File(WIKI_DIRECTORY).listFiles();

        List<IngestedDocument> docs = new ArrayList<>();
        for(File file: markdownFiles){
            docs.add(ingestSingleFile(file));
        }
        return docs;
    }

    private IngestedDocument ingestSingleFile(File file) throws IOException {
        String content = Files.readString(file.toPath());

        return new IngestedDocument(
                "WIKI",
                content,
                Map.of("fileName", file.getName(),
                        "identity", "WIKI#" + file.getName())
        );
    }

}
