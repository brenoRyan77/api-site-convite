package com.br.brenoryan77.api_site_convite.mapper;

import com.br.brenoryan77.api_site_convite.model.Presente;
import com.br.brenoryan77.api_site_convite.vo.PresenteVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PresenteMapper {


        Presente mapToEntity(PresenteVO vo);

        PresenteVO mapToVO(Presente entity);

        void updateEntity(@MappingTarget Presente entity, PresenteVO vo);
}
