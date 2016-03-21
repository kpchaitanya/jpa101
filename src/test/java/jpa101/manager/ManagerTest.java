package jpa101.manager;

import jpa101.dto.BasicEntityDTO;
import jpa101.entity.BasicEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class ManagerTest {

    //SUT
    private Manager manager;

    protected abstract String getPersistenceUnitName();

    @Before
    public void setUp() {
        manager = new Manager(getPersistenceUnitName());
    }

    @Test
    public void saveBasicEntityShouldPersistNonNullValuesToNull() {

        final GregorianCalendar expectedDateValue = new GregorianCalendar();
        BasicEntityDTO dto = new BasicEntityDTO();
        dto.setBooleanValue(true);
        dto.setCurrencyValue(new BigDecimal("101.01"));
        dto.setDateValue(expectedDateValue.getTime());
        dto.setEnumValue(BasicEnum.SecondValue);
        dto.setStringValue("Original entity");

        dto = manager.saveBasicEntity(dto);

        BasicEntityDTO savedDTO = manager.getBasicEntity(dto.getId());

        Assert.assertNotNull("Entity should be found by id: " + dto, savedDTO);
        Assert.assertNotNull(savedDTO.getId());
        Assert.assertNotNull(savedDTO.getCurrencyValue());
        Assert.assertNotNull(savedDTO.getDateValue());
        //TODO Assert.assertNotNull(savedDTO.getEnumValue());
        Assert.assertNotNull(savedDTO.getStringValue());
        Assert.assertNotNull(savedDTO.getBooleanValue());

        Assert.assertEquals(new BigDecimal("101.01"), savedDTO.getCurrencyValue());
        final GregorianCalendar savedDateValue = new GregorianCalendar();
        savedDateValue.setTime(savedDTO.getDateValue());
        Assert.assertEquals(expectedDateValue.get(Calendar.YEAR), savedDateValue.get(Calendar.YEAR));
        Assert.assertEquals(expectedDateValue.get(Calendar.MONTH), savedDateValue.get(Calendar.MONTH));
        Assert.assertEquals(expectedDateValue.get(Calendar.DATE), savedDateValue.get(Calendar.DATE));
        //TODO Assert.assertEquals(BasicEnum.SecondValue.name(), savedDTO.getEnumValue().name());
        Assert.assertEquals(true, savedDTO.getBooleanValue());

        savedDTO.setBooleanValue(null);
        savedDTO.setCurrencyValue(null);
        savedDTO.setDateValue(null);
        savedDTO.setEnumValue(null);
        savedDTO.setStringValue(null);

        savedDTO = manager.saveBasicEntity(savedDTO);

        final BasicEntityDTO nulledDTO = manager.getBasicEntity(savedDTO.getId());

        Assert.assertNotNull("Updated entity should be found by id: " + savedDTO, nulledDTO);
        Assert.assertNotNull(nulledDTO.getId());
        Assert.assertNull(nulledDTO.getCurrencyValue());
        Assert.assertNull(nulledDTO.getDateValue());
        Assert.assertNull(nulledDTO.getEnumValue());
        Assert.assertNull(nulledDTO.getStringValue());
        Assert.assertNull(nulledDTO.getBooleanValue());

        Assert.assertEquals(savedDTO.getId(), nulledDTO.getId());
    }

}
