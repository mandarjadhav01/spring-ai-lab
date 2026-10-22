package com.spring.ai.lab.texttosql.schema;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CachedSchemaProvider {

    private final List<TableSchema> tables;
    private final List<Relationship> relationships;
    private final String businessRules;

    public CachedSchemaProvider(final DynamicSchemaProvider dynamicSchemaProvider) {
        this.tables = dynamicSchemaProvider.getTables();
        this.relationships = dynamicSchemaProvider.getRelationships();
        this.businessRules = dynamicSchemaProvider.getBusinessRules();
    }


    public List<TableSchema> getTables() {
        return tables;
    }


    public List<Relationship> getRelationships() {
        return relationships;
    }


    public String getBusinessRules() {
        return businessRules;
    }
}
