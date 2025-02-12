package com.example.demo.repositories;

import com.example.demo.models.PageVisit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageVisitRepository extends JpaRepository<PageVisit, String> {
}