package f_samp.database.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbstractDAO {

    protected final EntityManager entityManager;
    protected final EntityTransaction entityTransaction;

    public AbstractDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = this.entityManager.getTransaction();
    }

    protected void beginTransaction() {
        try {
            entityTransaction.begin();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    protected void commitTransaction() {
        try {
            entityTransaction.commit();
        } catch (IllegalStateException e) {
            rollbackTransaction();
        }
    }

    protected void rollbackTransaction() {
        try {
            entityTransaction.rollback();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }


}
