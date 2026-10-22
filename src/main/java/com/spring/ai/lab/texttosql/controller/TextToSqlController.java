package com.spring.ai.lab.texttosql.controller;

import com.spring.ai.lab.texttosql.dto.TextToSqlRequest;
import com.spring.ai.lab.texttosql.dto.TextToSqlResponse;
import com.spring.ai.lab.texttosql.service.TextToSqlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
class TextToSqlController {

    private final TextToSqlService textToSqlService;

    @PostMapping("/text-to-sql")
    public TextToSqlResponse textToSql(@RequestBody TextToSqlRequest request) {

        return textToSqlService.handle(request);
    }
}
