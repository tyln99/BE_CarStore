package com.company.app.repositories;

import com.company.app.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {
    @Query(value = "SELECT * FROM model WHERE brand_id = :brandId", nativeQuery = true)
    List<Model> findAllByBrandId(@Param("brandId") Integer brandId);

    @Query(value = "SELECT * FROM model WHERE UPPER(name) LIKE %:testtest%", nativeQuery = true)
    List<Model> searchByName(@Param("testtest") String name);
}
