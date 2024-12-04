package com.hiep.mart.service.impl;

import com.hiep.mart.domain.dto.BatchDTO;
import com.hiep.mart.domain.entity.Batch;
import com.hiep.mart.domain.enumeration.TypeOfTransaction;
import com.hiep.mart.domain.mapper.BatchMapper;
import com.hiep.mart.domain.request.BatchRequest;
import com.hiep.mart.domain.request.FinanceRequest;
import com.hiep.mart.exception.AppException;
import com.hiep.mart.exception.ErrorCode;
import com.hiep.mart.repository.BatchRepository;
import com.hiep.mart.repository.ProductRepository;
import com.hiep.mart.service.BatchService;
import com.hiep.mart.service.FinanceService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BatchServiceImpl implements BatchService {

    BatchRepository batchRepository;
    BatchMapper batchMapper;
    MessageSource messageSource;
    ProductRepository productRepository;
    FinanceService financeService;

    @Override
    @PreAuthorize("hasAuthority('GET_ALL_BATCH')")
    public List<BatchDTO> getAllBatch() {
        return batchRepository.findAll().stream()
                .filter(b -> b.getBatchStatus().equals("Active"))
                .map(batchMapper::toBatchDTO)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAuthority('GET_BATCH_BY_ID')")
    public BatchDTO getBatchById(Long id, Locale locale) {
        return batchRepository.findById(id)
                .filter(b -> b.getBatchStatus().equals("Active"))
                .map(batchMapper::toBatchDTO)
                .orElseThrow(() -> new AppException(ErrorCode.BATCH_NOT_FOUND, messageSource, locale));
    }

    @Override
    @Transactional
    @PreAuthorize("hasAuthority('CREATE_BATCH')")
    public BatchDTO createBatch(BatchRequest request, Locale locale) {
        productRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND, messageSource, locale));

        FinanceRequest financeRequest = new FinanceRequest();
        financeRequest.setTypeOfTransaction(TypeOfTransaction.CHI);
        financeRequest.setTransactionDate(LocalDate.now());
        financeRequest.setTransactionPrice(request.batchPrice);
        System.out.println("FinanceRequest: " + financeRequest);
        financeService.addFinance(financeRequest);

        Batch batch = batchMapper.toBatch(request);
        batch.setBatchStatus("Active");
        batch.setImportDate(LocalDate.now());
        batchRepository.save(batch);

        return batchMapper.toBatchDTO(batch);
    }

    @Override
    @PreAuthorize("hasAuthority('UPDATE_BATCH')")
    public BatchDTO updateBatch(Long batchId, BatchRequest request, Locale locale) {
        Batch batch = batchRepository.findById(batchId)
                .orElseThrow(() -> new AppException(ErrorCode.BATCH_NOT_FOUND, messageSource, locale));

        productRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND, messageSource, locale));

        batchMapper.updateBatch(batch, request);

        batchRepository.save(batch);
        return batchMapper.toBatchDTO(batch);
    }

    @Override
    @PreAuthorize("hasAuthority('GET_EXPIRING_IN_7_DAYS_BATCH')")
    public List<BatchDTO> getExpiringIn7DaysBatches() {
        return batchRepository.getExpireIn7DaysProducts();
    }

    @Override
    @PreAuthorize("hasAuthority('GET_EXPIRED_BATCH')")
    public List<BatchDTO> getExpiredBatches() {
        return batchRepository.getExpiredProducts();
    }
}
