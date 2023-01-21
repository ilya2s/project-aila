# Project AILA :rocket::full_moon: A blockchain simulation project

This is the first stage of the project. In this stage, the goal is to implement a simple blockchain that can store a sequence of data in the form of blocks.

## Getting Started
The project is implemented in Java and utilizes the SHA-256 hashing algorithm for secure block creation. The following are the key features of the first stage:
- Every block in the blockchain contains the hash of the previous block and a unique identifier.
- The first block in the chain has id = 1 and the hash of the previous block is 0.
- Every block also contains a timestamp representing the time the block was created.
- The class `Blockchain` has at least two methods: `generateBlock()` to generate a new block and `validate()` to validate the entire blockchain.
- The `validate()` method checks that the hash of the previous block matches the previous hash stored in the current block.

## Usage
To use the project, you can clone the repository and open it in an IDE of your choice. You can then run the `Aila.java` file and use the methods to generate and validate blocks. The project includes a `StringUtil` class that can be used to hash the blocks using the SHA-256 algorithm.

You should create 5 blocks in this stage. After the creation, validate the created blockchain using your validation method.

## Conclusion
This is the first stage of the Blockchain project from Jetbrains Academy and it aims to give a basic understanding of how a blockchain works
