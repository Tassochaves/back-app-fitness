package com.dev.app_fitness.service.meta;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import com.dev.app_fitness.dto.MetaDTO;
import com.dev.app_fitness.entity.Meta;
import com.dev.app_fitness.repository.MetaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetaServiceImpl implements MetaService{

    private final MetaRepository metaRepository;

    public MetaDTO postarMeta(MetaDTO metaDTO){
        Meta meta = new Meta();
        meta.setDescricao(metaDTO.getDescricao());
        meta.setDataInicio(metaDTO.getDataInicio());
        meta.setDataFim(metaDTO.getDataFim());
        meta.setAlcancada(false);

        return metaRepository.save(meta).obterMetaDTO();
    }

    @Override
    public List<MetaDTO> listarMetas() {
        List<Meta> metas = metaRepository.findAll();

        return metas.stream().map(Meta::obterMetaDTO).collect(Collectors.toList());
    }
}
