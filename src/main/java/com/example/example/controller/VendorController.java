package com.example.example.controller;

import com.example.example.model.VendorDto;
import com.example.example.service.VendorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @Operation(description = "Создание")
    @PostMapping
    public VendorDto create(
            @RequestBody VendorDto vendorDto) {
        return this.vendorService.create(vendorDto);
    }


    @Operation(description = "Обновление")
    @PatchMapping("{vendorId}")
    public VendorDto update(
            @PathVariable("vendorId") UUID vendorId,
            @RequestBody VendorDto vendor) {
        return this.vendorService.update(vendorId, vendor);
    }

    @Operation(description = "Получение по ID")
    @GetMapping("{vendorId}")
    public VendorDto get(
            @PathVariable("vendorId") UUID vendorId) {
        return this.vendorService.getDto(vendorId);
    }

    @Operation(description = "Получение по списку ID")
    @PostMapping("/list")
    public List<VendorDto> get(
            @RequestBody Set<UUID> vendorIds) {
        return this.vendorService.getDto(vendorIds);
    }

    @Operation(description = "Получение всех вендоров")
    @GetMapping
    public List<VendorDto> vendors() {
        return this.vendorService.getAll();
    }

    @Operation(summary = "Получить вендора по его Коду")
    @GetMapping("/codes/{code}")
    public VendorDto byCode(@PathVariable("code") String code) {
        return this.vendorService.getByCode(code);
    }

    @Operation(description = "Удаление вендора")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{vendorId}")
    public void delete(@PathVariable("vendorId") UUID vendorId) {
        this.vendorService.delete(vendorId);
    }
}
