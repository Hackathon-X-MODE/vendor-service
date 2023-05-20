package com.example.example.controller;

import com.example.example.model.VendorDto;
import com.example.example.service.VendorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class VendorController {

    private final VendorService vendorService;

    @Operation(description = "Создание")
    @PostMapping()
    public VendorDto create(
            @RequestBody VendorDto vendorDto) {
        return this.vendorService.create(vendorDto);
    }


    @Operation(description = "Обновление")
    @PatchMapping("{vendorId}")
    public VendorDto create(
            @PathVariable("vendorId") UUID vendorId,
            @RequestBody VendorDto vendor) {
        return this.vendorService.update(vendorId, vendor);
    }

    @Operation(description = "Получение всех вендоров")
    @GetMapping
    public List<VendorDto> vendors() {
        return this.vendorService.getAll();
    }

    @Operation(description = "Удаление вендора")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{vendorId}")
    public void delete(@PathVariable("vendorId") UUID vendorId) {
        this.vendorService.delete(vendorId);
    }
}
