package com.hiep.mart.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionStatusDTO implements Serializable {
    private String status;
    private String message;
    private String data;
}
