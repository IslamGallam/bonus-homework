package com.hw2.homework.repository;

import com.hw2.homework.model.Record;
import com.hw2.homework.model.RecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, RecordId> {
}
