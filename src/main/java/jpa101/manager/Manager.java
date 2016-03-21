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
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            entityManager.close();
        }
        return new BasicEntityDTO(entity);
    }

    public BasicEntityDTO getBasicEntity(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        BasicEntity entity = entityManager.find(BasicEntity.class, id);
        if (entity != null) {
            return new BasicEntityDTO(entity);
        }
        return null;
    }

    public void deleteBasicEntity(Long id) {
    }
}