package com.christian.lurien.demo.service;

import org.web3j.tx.Contract;

public interface ContractEventObserverService {
    void manageContractEvent(Contract deployedContract);
}
