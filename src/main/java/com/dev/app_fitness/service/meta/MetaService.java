package com.dev.app_fitness.service.meta;

import com.dev.app_fitness.dto.MetaDTO;
import java.util.List;

public interface MetaService {

    MetaDTO postarMeta(MetaDTO metaDTO);

    List<MetaDTO> listarMetas();
}
