package services.transaction;

import javax.inject.Inject;
import javax.inject.Singleton;

import dao.api.TransactionDAO;
import services.api.TransactionManager;

@Singleton
public class TransactionManagerImpl implements TransactionManager {
    private TransactionDAO transactionDAO;

    @Inject
    public TransactionManagerImpl(TransactionDAO transactionDAO){
        this.transactionDAO = transactionDAO;
    }
}
