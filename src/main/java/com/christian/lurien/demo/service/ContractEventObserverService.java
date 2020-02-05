package com.christian.lurien.demo.service;

import com.christian.lurien.demo.contracts.TestLurien;
import org.web3j.tx.Contract;

public interface ContractEventObserverService {
    void manageContractEvent(TestLurien deployedContract);
}
