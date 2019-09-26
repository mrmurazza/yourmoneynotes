package entity.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import utils.Utils;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private long id;

    @Column(name = "account_id", nullable = false)
    private long accountId;

    @Column(name = "category_id", nullable = false)
    private long categoryId;

    @Column(name = "currency_id", nullable = false)
    private long currencyId;

    @Column(name = "category_type", nullable = false)
    private String categoryType;

    @Column(name="amount")
    private long amount;

    @Column(name="description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "debt_target")
    private String debtTarget;

    public Transaction(){
    }

    public Transaction(long accountId, long categoryId, long currencyId, String categoryType,
        long amount, String description, String debtTarget) {
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.currencyId = currencyId;
        this.categoryType = categoryType;
        this.amount = amount;
        this.description = description;
        this.debtTarget = debtTarget;
    }

    public long getId() {
        return id;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public long getCurrencyId() {
        return currencyId;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getDebtTarget() {
        return debtTarget;
    }

    @JsonProperty("created_at")
    public String getPrettyCreatedAt(){
        return Utils.formatToPrettyDate(createdAt);
    }

    @JsonProperty("updated_at")
    public String getPrettyUpdatedAt(){
        return Utils.formatToPrettyDate(updatedAt);
    }
}
