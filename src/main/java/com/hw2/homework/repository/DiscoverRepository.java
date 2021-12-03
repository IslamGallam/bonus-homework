package com.hw2.homework.repository;

import com.hw2.homework.model.Discover;
import com.hw2.homework.model.DiscoverId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscoverRepository extends JpaRepository<Discover, DiscoverId> {
}
