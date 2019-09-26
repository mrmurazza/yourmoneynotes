package services.transaction;

import dao.api.TransactionDAO;
import entity.dao.Transaction;
import entity.exceptions.ListException;
import org.apache.commons.lang3.StringUtils;
import entity.request.ProductRequest;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import services.api.TransactionManager;

@Singleton
public class TransactionManagerImpl implements TransactionManager {
    private TransactionDAO transactionDAO;

    @Inject
    public TransactionManagerImpl(TransactionDAO transactionDAO){
        this.transactionDAO = transactionDAO;
    }
}
