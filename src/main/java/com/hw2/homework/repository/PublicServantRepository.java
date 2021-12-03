package com.hw2.homework.repository;

import com.hw2.homework.model.PublicServant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicServantRepository extends JpaRepository<PublicServant, String> {
}
