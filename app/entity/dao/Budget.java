package entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

public class Budget {
  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue
  private long id;

  @Column(name = "name", nullable = false)
  private long name;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "amount", nullable = false)
  private long amount;

  @Column(name = "start_date", nullable = false)
  private Date startDate;

  @Column(name="end_date")
  private Date endDate;

  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  @JsonIgnore
  private Date updatedAt;

  public Budget() {
  }

  public long getId() {
    return id;
  }

  public long getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public long getAmount() {
    return amount;
  }

  public Date getStartDate() {
    return startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }
}
