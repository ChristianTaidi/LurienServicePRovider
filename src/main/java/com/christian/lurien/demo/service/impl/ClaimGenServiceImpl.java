package com.christian.lurien.demo.service.impl;

import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.service.ClaimGenService;
import com.christian.lurien.demo.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class ClaimGenServiceImpl implements ClaimGenService {

    @Autowired
    private ClaimRepository repository;

    @Override
    public Claim generateClaim() {

        Claim claim = new Claim("URJC_Claim","DefaultJSON");
        claim = repository.save(claim);
        return claim;
        //ToDo generate new Claim and persist it in the repository
    }
}
