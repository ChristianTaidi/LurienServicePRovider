### Compile smart contract .sol file into java file

     sudo docker run --rm -v '/home/indizenlabs/Escritorio/':'/contract' -w '/contract' ethereum/solc:stable '/contract/claimRequest.sol' --bin --abi --optimize -o '/contract'
     
     web3j solidity generate --binFile=HelloWorld.bin  --abiFile=HelloWorld.abi -p contract.model -o src/main/java/