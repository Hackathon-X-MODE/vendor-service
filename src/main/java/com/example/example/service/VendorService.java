package com.example.example.service;

import com.example.example.domain.VendorEntity;
import com.example.example.exception.EntityNotFoundException;
import com.example.example.mapper.VendorMapper;
import com.example.example.model.VendorDto;
import com.example.example.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    private final VendorMapper vendorMapper;

    @Transactional
    public VendorDto create(VendorDto vendorDto) {
        return this.vendorMapper.toDto(
                this.vendorRepository.save(
                        this.vendorMapper.toEntity(vendorDto)
                )
        );
    }


    @Transactional
    public VendorDto update(UUID id, VendorDto vendorDto) {
        final var vendor = this.get(id);
        this.vendorMapper.update(vendor, vendorDto);

        return this.vendorMapper.toDto(vendor);
    }

    @Transactional
    public void delete(UUID id) {
        this.vendorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public VendorEntity get(UUID id) {
        return this.vendorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find vendor " + id)
        );
    }


    @Transactional(readOnly = true)
    public VendorDto getDto(UUID id) {
        return this.vendorMapper.toDto(
                this.get(id)
        );
    }

    @Transactional(readOnly = true)
    public List<VendorDto> getDto(Collection<UUID> ids) {
        return this.vendorRepository.findAllById(ids).stream().map(this.vendorMapper::toDto).toList();
    }


    @Transactional(readOnly = true)
    public List<VendorDto> getAll() {
        return this.vendorRepository.findAll()
                .stream().map(this.vendorMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public VendorDto getByCode(String code) {
        return this.vendorMapper.toDto(this.vendorRepository.findByCode(code)
                .orElseThrow(
                        () -> new EntityNotFoundException("Can't find vendor by code " + code)
                )
        );
    }
}
