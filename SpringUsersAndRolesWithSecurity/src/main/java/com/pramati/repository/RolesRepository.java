package com.pramati.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pramati.model.Authority;

@Repository
public interface RolesRepository extends JpaRepository<Authority, Long>{

}
