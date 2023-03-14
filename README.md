# Project AILA :rocket::full_moon:
This is a blockchain simulation project that demonstrates the creation and validation of a simple blockchain using Java and SHA-256 hashing algorithm. The goal of the project is to gain a basic understanding of how a blockchain works.

![image](https://user-images.githubusercontent.com/42526358/213894377-bff770d4-cf00-4534-9b8d-da75b51cd86e.png)

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
