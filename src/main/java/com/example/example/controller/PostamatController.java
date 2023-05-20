package com.example.example.controller;

import com.example.example.model.PostamatDto;
import com.example.example.service.PostamatService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("{vendorId}/postamates")
@RequiredArgsConstructor
public class PostamatController {

    private final PostamatService postamatService;

    @Operation(description = "Создание постамата")
    @PostMapping()
    public PostamatDto create(
            @PathVariable("vendorId") UUID vendorId,
            @RequestBody PostamatDto postamatDto) {
        return this.postamatService.create(vendorId, postamatDto);
    }


    @Operation(description = "Обновление")
    @PatchMapping("{postamatId}")
    public PostamatDto update(
            @PathVariable("vendorId") UUID vendorId, @PathVariable("postamatId") UUID postamatId,
            @RequestBody PostamatDto postamatDto) {
        return this.postamatService.update(postamatId, postamatDto);
    }

    @Operation(description = "Получение всех постаматов от вендора")
    @GetMapping()
    public List<PostamatDto> postamates(
            @PathVariable("vendorId") UUID vendorId
    ) {
        return this.postamatService.getAll(vendorId);
    }

    @Operation(description = "Удаление постамата")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{postamatId}")
    public void delete(@PathVariable("vendorId") UUID vendorId, @PathVariable("postamatId") UUID postamatId) {
        this.postamatService.delete(postamatId);
    }


    @Operation(summary = "Получить Постамат вендора по его Коду")
    @GetMapping("/externalIds/{externalId}")
    public PostamatDto byCode(@PathVariable("vendorId") UUID vendorId, @PathVariable("externalId") String externalId) {
        return this.postamatService.getByExternalId(vendorId,externalId);
    }
}
