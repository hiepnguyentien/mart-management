package com.hiep.mart.service;

import java.util.List;

import com.hiep.mart.domain.dto.BatchDTO;
import com.hiep.mart.domain.request.BatchRequest;

public interface BatchService {
    List<BatchDTO> getAllBatch();
    BatchDTO getBatchById(Long batchId);
    BatchDTO createBatch(BatchDTO batchDTO);
    BatchDTO updateBatch(BatchRequest request);
    BatchDTO getExpiringBatches();
    BatchDTO getExpiredBatches();
}
