# Project AILA :rocket::full_moon:
This is a blockchain simulation project that demonstrates the creation and validation of a simple blockchain using Java and SHA-256 hashing algorithm. The goal of the project is to gain a basic understanding of how a blockchain works.

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
