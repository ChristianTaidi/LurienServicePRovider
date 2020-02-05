package com.christian.lurien.demo.service.impl;

import com.christian.lurien.demo.service.ContractEventObserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;

public class ContractEventObserverServiceImpl implements ContractEventObserverService {

    @Autowired
    Web3j web3j;

    @Override
    public void manageContractEvent(Contract deployedContract) {


    }
}
