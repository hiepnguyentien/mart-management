package com.hiep.mart.controller;

import com.hiep.mart.domain.dto.BatchDTO;
import com.hiep.mart.domain.request.BatchRequest;
import com.hiep.mart.service.BatchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@Slf4j
@RequestMapping(path = "/batch")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BatchController {

    BatchService batchService;

    @GetMapping
    public ResponseEntity<List<BatchDTO>> getAllBatches() {
        List<BatchDTO> batches = batchService.getAllBatch();
        return ResponseEntity.ok(batches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatchDTO> getBatchById(@PathVariable Long id, Locale locale) {
        BatchDTO batch = batchService.getBatchById(id, locale);
        return ResponseEntity.ok(batch);
    }

    @PostMapping
    public ResponseEntity<BatchDTO> createBatch(@RequestBody BatchRequest request, Locale locale) {
        BatchDTO createdBatch = batchService.createBatch(request, locale);
        return ResponseEntity.ok(createdBatch);
    }

    @PutMapping("/{batchId}")
    public ResponseEntity<BatchDTO> updateBatch(
            @PathVariable Long batchId,
            @RequestBody BatchRequest request,
            Locale locale) {
        BatchDTO updatedBatch = batchService.updateBatch(batchId, request, locale);
        return ResponseEntity.ok(updatedBatch);
    }

    @GetMapping("/expiring-soon")
    public ResponseEntity<List<BatchDTO>> getExpiringIn7DaysBatches() {
        List<BatchDTO> expiringBatches = batchService.getExpiringIn7DaysBatches();
        return ResponseEntity.ok(expiringBatches);
    }

    @GetMapping("/expired")
    public ResponseEntity<List<BatchDTO>> getExpiredBatches() {
        List<BatchDTO> expiredBatches = batchService.getExpiredBatches();
        return ResponseEntity.ok(expiredBatches);
    }
}
