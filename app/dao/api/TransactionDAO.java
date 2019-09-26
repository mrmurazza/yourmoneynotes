package dao.api;

import com.google.inject.ImplementedBy;

import java.util.List;
import java.util.Optional;
import entity.dao.Transaction;
import dao.impl.TransactionSQL;

@ImplementedBy(TransactionSQL.class)
public interface TransactionDAO {
    Transaction persist(Transaction transaction);
    Optional<Transaction> getById(long id);
    List<Transaction> getByUserId(long userId);
    void deleteById(long id);
}
