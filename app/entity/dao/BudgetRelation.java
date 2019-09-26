package entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

public class BudgetRelation {
  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue
  private long id;

  @Column(name = "budget_id", nullable = false)
  private long budgetId;

  @Column(name = "category_id", nullable = false)
  private long categoryId;

  @Column(name = "target_id", nullable = false)
  private long targetId;

  @Column(name = "target_type", nullable = false)
  private String targetType;

  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  @JsonIgnore
  private Date updatedAt;

  public BudgetRelation() {
  }

  public long getId() {
    return id;
  }

  public long getBudgetId() {
    return budgetId;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public long getTargetId() {
    return targetId;
  }

  public String getTargetType() {
    return targetType;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }
}
