package com.christian.lurien.demo.repository;

import com.christian.lurien.demo.pojos.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Long> {

    List<Claim> findAll();
}
