package com.company.app.model;

import com.company.app.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false, name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "logo")
    String logo;

    @Column(name = "description")
    String description;

    @Column(name = "status")
    Status status;

    @Column(name = "release_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Timestamp releaseDate;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    Timestamp updatedAt;
}
