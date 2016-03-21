package jpa101.manager;

import org.junit.Ignore;

//@Ignore
public class HibernateTest extends ManagerTest {
    @Override
    protected String getPersistenceUnitName() {
        return "jpa101-hibernate";
    }
}
