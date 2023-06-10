package com.example.example.controller;

import com.example.example.model.PostamatDto;
import com.example.example.model.PostamatFilter;
import com.example.example.model.stats.PostamatStat;
import com.example.example.service.PostamatService;
import com.example.example.service.PostamatStatsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("postamates")
@RequiredArgsConstructor
public class SpecialPostamatController {

    private final PostamatService postamatService;

    private final PostamatStatsService postamatStatsService;

    @Operation(description = "Получение постамата по его ID")
    @GetMapping("{postamatId}")
    public PostamatDto get(@PathVariable("postamatId") UUID postamatId) {
        return this.postamatService.getDto(postamatId);
    }

    @Operation(description = "Получение всех постаматов")
    @GetMapping
    public List<PostamatDto> get(PostamatFilter filter) {
        return this.postamatService.getDto(filter);
    }


    @Operation(description = "Получение постамата по его ID")
    @GetMapping("{postamatId}/stats")
    public PostamatStat getStats(@PathVariable("postamatId") UUID postamatId) {
        return this.postamatStatsService.getStats(postamatId);
    }
}
