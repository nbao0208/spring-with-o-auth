package org.example.applicationwithoauth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.OffsetDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
  @Id
  private UUID id;

  @Column(name = "created")
  private OffsetDateTime created;

  @Column(name = "modified")
  private OffsetDateTime modified;

  @Column(name = "created_by")
  private String createdBy;

  @Column(name = "modified_by")
  private String modifiedBy;

  @Column(name = "is_deleted")
  private boolean isDeleted;

  @PrePersist
  protected void onCreate(){
    this.id = UUID.randomUUID();
    this.created = OffsetDateTime.now();
    this.modified = OffsetDateTime.now();
  }

  @PreUpdate
  protected void onUpdate(){
    this.modified = OffsetDateTime.now();
  }
}
