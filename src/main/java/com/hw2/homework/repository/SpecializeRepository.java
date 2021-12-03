package com.hw2.homework.repository;

import com.hw2.homework.model.Specialize;
import com.hw2.homework.model.SpecializeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializeRepository extends JpaRepository<Specialize, SpecializeId> {
}
