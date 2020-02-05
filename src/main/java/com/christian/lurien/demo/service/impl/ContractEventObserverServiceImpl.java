package com.christian.lurien.demo.service.impl;

import com.christian.lurien.demo.contracts.TestLurien;
import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.repository.ClaimRepository;
import com.christian.lurien.demo.service.ContractEventObserverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.Contract;

import java.util.Map;

public class ContractEventObserverServiceImpl implements ContractEventObserverService {

    @Autowired
    Web3j web3j;

    @Autowired
    private ClaimRepository claimRepository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void manageContractEvent(TestLurien deployedContract) {
        deployedContract.claimFilledEventFlowable(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST)
                .subscribe(event ->{
                    final String claimData = String.valueOf(event._filledClaim);
                    Map<String, Claim> map = mapper.readValue(claimData, Map.class);
                });
    }
}
