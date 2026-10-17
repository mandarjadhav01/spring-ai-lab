package com.spring.ai.lab.rag.services.ingestion;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.ParagraphPdfDocumentReader;
import org.springframework.stereotype.Service;

import com.spring.ai.lab.rag.services.ingestion.model.IngestedDocument;

@Service
public class PdfIngestionService {

    private static final String PDF_DIRECTORY = "data/pdfs";

    public List<IngestedDocument> ingest(String fileName) throws IOException {
        File pdfFile = new File(PDF_DIRECTORY + "/" + fileName);

        return ingestSinglePdf(pdfFile);
    }

    public List<IngestedDocument> ingestPdfs() throws Exception {
        File[] pdfFiles = new File(PDF_DIRECTORY).listFiles();

        List<IngestedDocument> docs = new ArrayList<>();

        for (File pdfFile : pdfFiles) {
            docs.addAll(ingestSinglePdf(pdfFile));
        }

        return docs;
    }

    private List<IngestedDocument> ingestSinglePdf(File pdfFile) throws IOException {

        ParagraphPdfDocumentReader pdfReader = new ParagraphPdfDocumentReader(pdfFile.getPath());
        List<Document> paragraphs = pdfReader.get();
        List<IngestedDocument> ingestedDocuments = new ArrayList<>();
        for (Document paragraph : paragraphs) {
            ingestedDocuments.add(new IngestedDocument(
                    "PDF",
                    paragraph.getText(),
                    Map.of("fileName", pdfFile.getName(),
                            "identity", "PDF#" + pdfFile.getName())));
        }
        return ingestedDocuments;

    }
}
