package org.yourapp.shared.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, updatable = false, name = "created_by")
    String createdBy;

    @Column(nullable = false, updatable = false, name = "created_time")
    Instant createdTime;

    @Column(insertable = false, name = "modified_by")
    String modifiedBy;

    @Column(insertable = false, name = "modified_time")
    Instant modifiedTime;

    @PrePersist
    private void handlePrePersist() {
        createdBy = "system";
        createdTime = Instant.now();
    }

    @PreUpdate
    private void handlePreUpdate() {
        modifiedTime = Instant.now();
    }
}

