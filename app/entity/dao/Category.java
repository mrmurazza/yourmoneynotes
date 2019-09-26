package entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

public class Category {
  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue
  private long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "parent_id", nullable = false)
  private long parentId;

  @Column(name="description")
  private String description;

  @Column(name = "icon", nullable = false)
  private String icon;

  @Temporal(TemporalType.TIMESTAMP)
  @CreationTimestamp
  @Column(name = "created_at")
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at")
  private Date updatedAt;

  public Category() {
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public long getParentId() {
    return parentId;
  }

  public String getDescription() {
    return description;
  }

  public String getIcon() {
    return icon;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }
}
