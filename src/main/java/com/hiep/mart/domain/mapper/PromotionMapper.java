package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.PromotionDTO;
import com.hiep.mart.domain.entity.Promotion;
import com.hiep.mart.domain.request.PromotionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PromotionMapper {
    Promotion toPromotion(PromotionRequest promotionRequest);
    PromotionDTO toPromotionDTO(Promotion promotion);
    void updatePromotion(@MappingTarget Promotion promotion, PromotionRequest promotionRequest);
}
