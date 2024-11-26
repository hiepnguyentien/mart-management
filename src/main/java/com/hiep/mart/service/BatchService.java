package com.hiep.mart.service;

import java.util.List;
import java.util.Locale;

import com.hiep.mart.domain.dto.BatchDTO;
import com.hiep.mart.domain.request.BatchRequest;

public interface BatchService {
    List<BatchDTO> getAllBatch();
    BatchDTO getBatchById(Long batchId, Locale locale);
    BatchDTO createBatch(BatchRequest request, Locale locale);
    BatchDTO updateBatch(Long batchId, BatchRequest request, Locale locale);
    List<BatchDTO> getExpiringIn7DaysBatches();
    List<BatchDTO> getExpiredBatches();
}
