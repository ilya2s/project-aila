# Project AILA :rocket::full_moon:
This is a blockchain simulation project that demonstrates the creation and validation of a simple blockchain using Java and SHA-256 hashing algorithm. The goal of the project is to gain a basic understanding of how a blockchain works.

![image](https://user-images.githubusercontent.com/42526358/213894377-bff770d4-cf00-4534-9b8d-da75b51cd86e.png)

```text
=====================
BLOCKCHAIN IS VALID
=====================
Block:
Id: 1
Timestamp: 1678779695861
Hash of the previous block:
60e05bd1b195af2f94112fa7197a5c88289058840ce7c6df9693756bc6250f55
Hash of the block:
1941ceda6c7b27f948d9667b5718b25bf94e0c5666655203d30350500fe0710b
----------------------------------------------------------------
Block:
Id: 2
Timestamp: 1678779695872
Hash of the previous block:
1941ceda6c7b27f948d9667b5718b25bf94e0c5666655203d30350500fe0710b
Hash of the block:
de28b408eeeb0a83feeec0740b7c8c8d7205fe97827c59573e01cace8924dd26
----------------------------------------------------------------
Block:
Id: 3
Timestamp: 1678779695872
Hash of the previous block:
de28b408eeeb0a83feeec0740b7c8c8d7205fe97827c59573e01cace8924dd26
Hash of the block:
bff9c0c53f47a78c84adfc468bae3d72d977ab39162dfec449b0f331cc545e73
----------------------------------------------------------------
Block:
Id: 4
Timestamp: 1678779695873
Hash of the previous block:
bff9c0c53f47a78c84adfc468bae3d72d977ab39162dfec449b0f331cc545e73
Hash of the block:
3634e0b3f4fec77bc32a59ecfa6813c6284372c826fa829dedb55c9390c8a24d
----------------------------------------------------------------
Block:
Id: 5
Timestamp: 1678779695873
Hash of the previous block:
3634e0b3f4fec77bc32a59ecfa6813c6284372c826fa829dedb55c9390c8a24d
Hash of the block:
5be9e18a15b668c5ef38685d00a3bf2862926ea188267445f5a8e479fca79967
----------------------------------------------------------------
Block:
Id: 6
Timestamp: 1678779695873
Hash of the previous block:
5be9e18a15b668c5ef38685d00a3bf2862926ea188267445f5a8e479fca79967
Hash of the block:
2b2179f210f516ed4fb64cf2f8cc08936ef94a7e34c7fcd2c1fc989a7365f7ff
----------------------------------------------------------------
```

## Features
- Every block in the blockchain contains the hash of the previous block and a unique identifier.
- The first block in the chain, called `genesisBlock` serves as the starting point for the blockchain.
- the genesis block has an ID of 1 and a previous hash value of a zero hash.
- Every block also contains a timestamp representing the time the block was created.

## Usage
To run the project, you can follow these steps:
- Clone the repository to your local machine.
- Open the project in an IDE of your choice.
- Run the Aila.java file.

The project will generate 5 blocks and validate the blockchain. You can modify the NUMBER_OF_BLOCKS constant in the Aila.java file to generate more or fewer blocks.

## Conclusion
This is the first stage of the [Blockchain project from Jetbrains Academy](https://hyperskill.org/projects/50?track=15) and it aims to give a basic understanding of how a blockchain works. In the next stage, more advanced features will be added to the blockchain, such as transactions, mining, and consensus algorithms.
