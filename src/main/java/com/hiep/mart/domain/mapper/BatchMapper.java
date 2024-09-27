package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.BatchDTO;
import com.hiep.mart.domain.entity.Batch;
import com.hiep.mart.domain.request.BatchRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BatchMapper {
    @Mapping(source = "productId", target = "products.productId")
    Batch toBatch(BatchRequest batchRequest);
    @Mapping(source = "products.productId", target = "productId")
    BatchDTO toBatchDTO(Batch batch);
    void updateBatch(@MappingTarget Batch batch, BatchRequest request1);
}
