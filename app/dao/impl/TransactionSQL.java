package dao.impl;

import dao.api.TransactionDAO;
import entity.dao.Transaction;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/*
 * Implementation of DAO layer of Transaction using SQL Database
 */

@Singleton
public class TransactionSQL implements TransactionDAO {
    private JPAApi jpaApi;

    @Inject
    public TransactionSQL(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Override
    public Transaction persist(Transaction transaction){
        return jpaApi.em().merge(transaction);
    }

    @Override
    public Optional<Transaction> getById(long id) {
        Query q = jpaApi.em().createQuery(
            "select transaction from Transaction transaction where transaction.id = :id");
        q.setParameter("id", id);

        try {
            return Optional.of((Transaction) q.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Transaction> getByUserId(long userId) {
        Query q = jpaApi.em().createQuery(
            "select transaction from Transaction transaction where transaction.userId = :userId");
        q.setParameter("userId", userId);

        return q.getResultList();
    }

    @Override
    public void deleteById(long id) {
        Query q = jpaApi.em().createQuery(
            "DELETE from Transaction transaction where transaction.id = :id");
        q.setParameter("id", id);
        q.executeUpdate();

        // Flush and clear to sync the local entity manager changes and clear its local em.
        // to make sure the entity we delete is deleted in the local EM too
        jpaApi.em().flush();
        jpaApi.em().clear();
    }
}
