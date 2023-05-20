package com.example.example.service;

import com.example.example.domain.PostamatEntity;
import com.example.example.exception.EntityNotFoundException;
import com.example.example.mapper.PostamatMapper;
import com.example.example.model.PostamatDto;
import com.example.example.repository.PostamatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostamatService {

    private final VendorService vendorService;
    private final PostamatRepository postamatRepository;

    private final PostamatMapper postamatMapper;


    @Transactional
    public PostamatDto create(UUID vendorId, PostamatDto postamatDto) {
        return this.postamatMapper.toDto(this.postamatRepository.save(
                        this.postamatMapper.toEntity(postamatDto)
                                .setVendor(this.vendorService.get(vendorId))
                )
        );
    }

    @Transactional(readOnly = true)
    public List<PostamatDto> getAll(UUID vendorId) {
        return this.postamatRepository.findAllByVendor_Id(vendorId)
                .stream().map(this.postamatMapper::toDto)
                .toList();
    }


    @Transactional
    public PostamatDto update(UUID id, PostamatDto dto) {
        final var postamat = this.get(id);

        this.postamatMapper.update(postamat, dto);

        return this.postamatMapper.toDto(postamat);
    }

    @Transactional(readOnly = true)
    public PostamatEntity get(UUID id) {
        return this.postamatRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find postamat " + id)
        );
    }

    @Transactional
    public void delete(UUID id) {
        this.postamatRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public PostamatDto getByExternalId(UUID vendorId, String externalId) {
        return this.postamatMapper.toDto(
                this.postamatRepository.findByVendor_IdAndExternalId(vendorId, externalId).orElseThrow(
                        () -> new EntityNotFoundException("Can't find postamat by externalId " + externalId + " at " + vendorId)
                )
        );
    }
}
