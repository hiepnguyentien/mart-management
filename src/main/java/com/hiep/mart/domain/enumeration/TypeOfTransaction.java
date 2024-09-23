package com.hiep.mart.domain.enumeration;

public enum TypeOfTransaction {
    THU("Thu"),
    CHI("Chi");

    private final String typeOfTransaction;

    TypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    @Override
    public String toString() {
        return typeOfTransaction;
    }

    public static TypeOfTransaction fromString(String text) {
        for (TypeOfTransaction b : TypeOfTransaction.values()) {
            if (b.typeOfTransaction.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + text);
    }
}
