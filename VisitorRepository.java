package com.aai.visitorcheck.repository;

import com.aai.visitorcheck.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
