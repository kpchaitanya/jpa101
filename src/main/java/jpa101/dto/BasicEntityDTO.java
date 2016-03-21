package jpa101.dto;

import jpa101.entity.BasicEntity;
import jpa101.entity.BasicEnum;

import java.math.BigDecimal;
import java.util.Date;

public class BasicEntityDTO {
    private Long id;
    private String stringValue;
    private Date dateValue;
    private Boolean booleanValue;
    private BigDecimal currencyValue;
    private BasicEnum enumValue;

    public BasicEntityDTO() {
        super();
    }

    public BasicEntityDTO(BasicEntity entity) {
        super();
        this.id = entity.getId();
        this.stringValue = entity.getStringValue();
        this.dateValue = entity.getDateValue();
        this.booleanValue = entity.getBooleanValue();
        this.currencyValue = entity.getCurrencyValue();
        this.enumValue = entity.getEnumValue();
    }


    @Override
    public String toString() {
        return "BasicEntityDTO{" +
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

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
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