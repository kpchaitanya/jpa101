package jpa101.manager;

import org.junit.Ignore;

//@Ignore
public class EclipseLinkTest extends ManagerTest {
    @Override
    protected String getPersistenceUnitName() {
        return "jpa101-eclipselink";
    }
}
