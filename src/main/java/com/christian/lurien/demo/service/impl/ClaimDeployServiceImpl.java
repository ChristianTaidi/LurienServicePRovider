package com.christian.lurien.demo.service.impl;

import antlr.Token;
import com.christian.lurien.demo.contracts.HelloWorld;
import com.christian.lurien.demo.pojos.Claim;
import com.christian.lurien.demo.service.ClaimDeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.web3j.crypto.*;
import org.web3j.ens.Contracts;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.tx.Contract;

import javax.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;

@Service
@Configurable
public class ClaimDeployServiceImpl implements ClaimDeployService {

    Credentials credentials;
    @Autowired
    private Web3j web3j;

    private static final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    private static final BigInteger GAS_LIMIT = BigInteger.valueOf(6722975L);

    @PostConstruct
    public void init() throws IOException, CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {
        BigInteger privateKeyInBT = new BigInteger("AAC4EA9967D456C9B77209534799B7B158F78372C6E7603A3871CB4CA192A56C", 16);
        ECKeyPair aPair = ECKeyPair.create(privateKeyInBT);
        credentials = Credentials.create(aPair);
        //credentials = WalletUtils.loadBip39Credentials(null,"twice require display resemble execute suffer celery digital ignore tackle chicken soldier");
        LOGGER.info("Credentials created: file={}, address={"+credentials.getAddress()+"}");

    }

    @Override
    public String deployClaim(Claim claim) throws Exception {

        HelloWorld contract = HelloWorld.deploy(web3j,credentials,GAS_PRICE, GAS_LIMIT).send();
        Contract getContract =  ;
        return contract.getContractAddress();

    }

}
