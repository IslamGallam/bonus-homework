package com.hw2.homework.repository;

import com.hw2.homework.model.DiseaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseTypeRepository extends JpaRepository<DiseaseType, Integer> {
}
