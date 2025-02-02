package com.christian.lurien.demo.service.impl;

import com.christian.lurien.demo.contracts.TestLurien;
import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.repository.ClaimRepository;
import com.christian.lurien.demo.service.ContractEventObserverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Bool;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.tx.Contract;

import java.util.Arrays;
import java.util.Map;

@Service
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
                    //ToDo test the event listening and do it in a separate thread after contract is deployed
                    final String claimData = event._filledClaim;
                    Map<String, Map<String,Object>> map = mapper.readValue(claimData, Map.class);

                    Map<String,Object> data = map.get("data");
                    for(String key:data.keySet()){
                        if(data.get(key).getClass().equals(Boolean.class)){
                            Boolean value = (Boolean) data.get(key);
                        }else if(data.get(key).getClass().equals(Double.class)) {
                            Double testMark = (Double)data.get(key);
                        }else{
                            String value = (String) data.get(key);
                        }
                        System.out.println(key+":"+data.get(key));

                    }
                    System.out.println(map.get("signature"));
                });
    }
}
