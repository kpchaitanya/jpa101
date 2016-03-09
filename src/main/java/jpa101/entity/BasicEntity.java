package jpa101.entity;

import jpa101.dto.BasicEntityDTO;

import java.math.BigDecimal;
import java.util.Date;

public class BasicEntity {
    private Long id;
    private String stringValue;
    private Date dateValue;
    private boolean booleanValue;
    private BigDecimal currencyValue;
    private BasicEnum enumValue;

    public BasicEntity() {
        super();
    }

    public BasicEntity(BasicEntityDTO dto) {
        super();
        this.id = dto.getId();
        this.stringValue = dto.getStringValue();
        this.dateValue = dto.getDateValue();
        this.booleanValue = dto.isBooleanValue();
        this.currencyValue = dto.getCurrencyValue();
        this.enumValue = dto.getEnumValue();
    }

    @Override
    public String toString() {
        return "BasicEntity{" +
                "id=" + id +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public BigDecimal getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(BigDecimal currencyValue) {
        this.currencyValue = currencyValue;
    }

    public BasicEnum getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(BasicEnum enumValue) {
        this.enumValue = enumValue;
    }
}