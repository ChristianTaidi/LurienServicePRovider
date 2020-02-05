package com.christian.lurien.demo.service.impl;

import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.service.ClaimDeployService;
import com.christian.lurien.demo.service.ClaimGenService;
import com.christian.lurien.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;


@Service
@Configurable
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    ClaimGenService claimGenerator;

    @Autowired
    ClaimDeployService claimDeployer;

    @Override
    public String register() {
        //ToDo generate claim, deploy smart contract and generate qr for the user
        Claim newClaim = claimGenerator.generateClaim();
        String contractAddress = null;
        try {
            contractAddress = claimDeployer.deployClaim(newClaim);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contractAddress;
    }

}
