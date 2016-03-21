package jpa101.entity;

import jpa101.dto.BasicEntityDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BASIC_ENTITY")
public class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STRING_VALUE")
    private String stringValue;

    @Column(name = "DATE_VALUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateValue;

    @Column(name = "BOOLEAN_VALUE")
    private Boolean booleanValue;

    @Column(name = "CURRENCY_VALUE")
    private BigDecimal currencyValue;

    @Transient
    //@Column(name = "ENUM_VALUE")
    private BasicEnum enumValue;

    public BasicEntity() {
        super();
    }

    public BasicEntity(BasicEntityDTO dto) {
        super();
        this.id = dto.getId();
        this.stringValue = dto.getStringValue();
        this.dateValue = dto.getDateValue();
        this.booleanValue = dto.getBooleanValue();
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