package com.hiep.mart.service.impl;

import com.hiep.mart.domain.mapper.PromotionMapper;
import com.hiep.mart.repository.PromotionRepository;
import com.hiep.mart.service.PromotionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PromotionServiceImpl implements PromotionService {

    PromotionRepository promotionRepository;
    PromotionMapper promotionMapper;

    @Override
    public void viewPromotion() {

    }

    @Override
    public void createPromotion() {

    }

    @Override
    public void updatePromotion() {

    }

    @Override
    public void deletePromotion() {

    }

    @Override
    public void viewPromotionStatus() {

    }

    @Override
    public void viewPromotionInvoice() {

    }

    @Override
    public void viewPromotionReceipt() {

    }
}
