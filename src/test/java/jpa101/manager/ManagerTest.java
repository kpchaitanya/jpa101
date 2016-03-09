package jpa101.manager;

import jpa101.dto.BasicEntityDTO;
import jpa101.entity.BasicEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class ManagerTest {

    //SUT
    private Manager manager;

    @Before
    public void setUp() {
        manager = new Manager();
    }

    @Test
    public void saveBasicEntityPersistNonNullValuesToNull() {

        final Date dateValue = new Date();
        final BasicEntityDTO dto = new BasicEntityDTO();
        dto.setBooleanValue(true);
        dto.setCurrencyValue(new BigDecimal("101.01"));
        dto.setDateValue(dateValue);
        dto.setEnumValue(BasicEnum.SecondValue);
        dto.setStringValue("Original entity");

        final BasicEntityDTO savedDTO = manager.saveBasicEntity(dto);

        Assert.assertNotNull(savedDTO);
        Assert.assertNotNull(savedDTO.getId());
        Assert.assertNotNull(savedDTO.getCurrencyValue());
        Assert.assertNotNull(savedDTO.getDateValue());
        Assert.assertNotNull(savedDTO.getEnumValue());
        Assert.assertNotNull(savedDTO.getStringValue());
        Assert.assertNotNull(savedDTO.isBooleanValue());

        Assert.assertEquals(new BigDecimal("101.01"), savedDTO.getCurrencyValue());
        Assert.assertEquals(dateValue, savedDTO.getDateValue());
        Assert.assertEquals(BasicEnum.SecondValue.name(), savedDTO.getEnumValue().name());
        Assert.assertEquals(true, savedDTO.isBooleanValue());

        savedDTO.setBooleanValue(false);
        savedDTO.setCurrencyValue(null);
        savedDTO.setDateValue(null);
        savedDTO.setEnumValue(null);
        savedDTO.setStringValue(null);

        final BasicEntityDTO nulledDTO = manager.saveBasicEntity(savedDTO);

        Assert.assertNotNull(nulledDTO);
        Assert.assertNotNull(nulledDTO.getId());
        Assert.assertNull(nulledDTO.getCurrencyValue());
        Assert.assertNull(nulledDTO.getDateValue());
        Assert.assertNull(nulledDTO.getEnumValue());
        Assert.assertNull(nulledDTO.getStringValue());
        Assert.assertNull(nulledDTO.isBooleanValue());

        Assert.assertEquals(savedDTO.getId(), nulledDTO.getId());
        Assert.assertEquals(false, nulledDTO.isBooleanValue());

    }

}
