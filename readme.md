### Required accounts
- Firebase
- Infura
- Metamask

### Compile smart contract .sol file into java file

     sudo docker run --rm -v '/home/indizenlabs/Escritorio/':'/contract' -w '/contract' ethereum/solc:stable '/contract/claimRequest.sol' --bin --abi --optimize -o '/contract'
     
     web3j solidity generate --binFile=HelloWorld.bin  --abiFile=HelloWorld.abi -p contract.model -o src/main/java/
     
 #Importante versión 4.5.6 de web3j.core
 
 ### Useful links
 
 - [Listening to smart contract events](https://medium.com/iobuilders/listen-smart-contract-events-is-easy-as-a-pie-5780e66eab8a)
 - [Signing and verifying ethereum signatures](https://dzone.com/articles/signing-and-verifying-ethereum-signatures)]
 - [Listening for ethereum smart contract events](https://kauri.io/listening-for-ethereum-smart-contract-events-in-java/760f495423db42f988d17b8c145b0874/a)
 - [Intro to blockchain with ethereum, web3j and sprint](https://piotrminkowski.com/2018/07/25/intro-to-blockchain-with-ethereum-web3j-and-spring-boot-smart-contracts/)