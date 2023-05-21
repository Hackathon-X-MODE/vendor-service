package com.example.example.controller;

import com.example.example.model.PostamatDto;
import com.example.example.service.PostamatService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("postamats")
@RequiredArgsConstructor
public class SpecialPostamatController {

    private final PostamatService postamatService;

    @Operation(description = "Получение постамата по его ID")
    @GetMapping("{postamatId}")
    public PostamatDto get(@PathVariable("postamatId") UUID postamatId) {
        return this.postamatService.getDto(postamatId);
    }
}
