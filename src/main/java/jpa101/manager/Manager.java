package jpa101.manager;

import jpa101.dto.BasicEntityDTO;
import jpa101.entity.BasicEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {

    private EntityManagerFactory entityManagerFactory;

    public Manager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa101");
    }

    public BasicEntityDTO saveBasicEntity(BasicEntityDTO dto) {
        BasicEntity entity = new BasicEntity(dto);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        } finally {
            entityManager.close();
        }
        return new BasicEntityDTO(entity);
    }

    public BasicEntityDTO getBasicEntity(Long id) {
        return null;
    }

    public void deleteBasicEntity(Long id) {
    }
}