package com.base.model;

import javax.persistence.AttributeConverter;

public  class MoneyConverter
        implements AttributeConverter<Money, Long> {
    @Override
    public Long convertToDatabaseColumn(Money attribute) {
        return attribute == null ? null : attribute.getCents();
    }

    @Override
    public Money convertToEntityAttribute(Long dbData) {
        return dbData == null ? null : new Money( dbData );
    }
}

