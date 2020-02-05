package com.christian.lurien.demo.contracts;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.12.
 */
@SuppressWarnings("rawtypes")
public class TestLurien extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b0319163317815560028054600181018255915260408051808201909152600380825262646e6960e81b6020929092019182526100699260008051602061066e833981519152019190610173565b5060028054600181018255600091909152604080518082019091526004808252636e616d6560e01b60209092019182526100b49260008051602061066e833981519152019190610173565b50600280546001810182556000919091526040805180820190915260158082527f616363657373546573744365727469666963617465000000000000000000000060209092019182526101189260008051602061066e833981519152019190610173565b506002805460018101825560009190915260408051808201909152600e8082526d616363657373546573744d61726b60901b602090920191825261016d9260008051602061066e833981519152019190610173565b5061020e565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106101b457805160ff19168380011785556101e1565b828001600101855582156101e1579182015b828111156101e15782518255916020019190600101906101c6565b506101ed9291506101f1565b5090565b61020b91905b808211156101ed57600081556001016101f7565b90565b6104518061021d6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063379607f514610046578063844a8c691461006f578063a2e81fac14610084575b600080fd5b610059610054366004610305565b610099565b60405161006691906103c5565b60405180910390f35b61007761013f565b6040516100669190610365565b61009761009236600461026a565b610217565b005b600281815481106100a657fe5b600091825260209182902001805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152935090918301828280156101375780601f1061010c57610100808354040283529160200191610137565b820191906000526020600020905b81548152906001019060200180831161011a57829003601f168201915b505050505081565b60606002805480602002602001604051908101604052809291908181526020016000905b8282101561020e5760008481526020908190208301805460408051601f60026000196101006001871615020190941693909304928301859004850281018501909152818152928301828280156101fa5780601f106101cf576101008083540402835291602001916101fa565b820191906000526020600020905b8154815290600101906020018083116101dd57829003601f168201915b505050505081526020019060010190610163565b50505050905090565b600180546001600160a01b03191633179055604051610237908290610349565b604051908190038120907fc98ba1d12613485c6f4a30edf54eafb43335a703ad007012da5fd8b06a34702a90600090a250565b60006020828403121561027b578081fd5b813567ffffffffffffffff80821115610292578283fd5b81840185601f8201126102a3578384fd5b80359250818311156102b3578384fd5b604051601f8401601f1916810160200183811182821017156102d3578586fd5b6040528381528184016020018710156102ea578485fd5b6102fb8460208301602085016103df565b9695505050505050565b600060208284031215610316578081fd5b5035919050565b600081518084526103358160208601602086016103eb565b601f01601f19169290920160200192915050565b6000825161035b8184602087016103eb565b9190910192915050565b6000602080830181845280855180835260408601915060408482028701019250838701855b828110156103b857603f198886030184526103a685835161031d565b9450928501929085019060010161038a565b5092979650505050505050565b6000602082526103d8602083018461031d565b9392505050565b82818337506000910152565b60005b838110156104065781810151838201526020016103ee565b83811115610415576000848401525b5050505056fea26469706673582212209691d5690c42f29c77022a8a68d8ea14933465bb854e04ebad73224683d68f6d64736f6c63430006020033405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace";

    public static final String FUNC_CLAIM = "claim";

    public static final String FUNC_CLAIMFILLED = "claimFilled";

    public static final String FUNC_GETCLAIM = "getClaim";

    public static final Event CLAIMFILLED_EVENT = new Event("ClaimFilled", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(true) {}));
    ;

    @Deprecated
    protected TestLurien(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected TestLurien(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected TestLurien(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected TestLurien(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ClaimFilledEventResponse> getClaimFilledEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CLAIMFILLED_EVENT, transactionReceipt);
        ArrayList<ClaimFilledEventResponse> responses = new ArrayList<ClaimFilledEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ClaimFilledEventResponse typedResponse = new ClaimFilledEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._filledClaim = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ClaimFilledEventResponse> claimFilledEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ClaimFilledEventResponse>() {
            @Override
            public ClaimFilledEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CLAIMFILLED_EVENT, log);
                ClaimFilledEventResponse typedResponse = new ClaimFilledEventResponse();
                typedResponse.log = log;
                typedResponse._filledClaim = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ClaimFilledEventResponse> claimFilledEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CLAIMFILLED_EVENT));
        return claimFilledEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> claim(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLAIM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> claimFilled(String _claimJson) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CLAIMFILLED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_claimJson)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getClaim() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETCLAIM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static TestLurien load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestLurien(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static TestLurien load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new TestLurien(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static TestLurien load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new TestLurien(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static TestLurien load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new TestLurien(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<TestLurien> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestLurien.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<TestLurien> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(TestLurien.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TestLurien> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestLurien.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<TestLurien> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(TestLurien.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ClaimFilledEventResponse extends BaseEventResponse {
        public byte[] _filledClaim;
    }
}
