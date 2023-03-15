# Project AILA :rocket::full_moon:
A simple, proof-of-work-based blockchain implementation in Java.

```text
=====================
BLOCKCHAIN IS VALID
=====================
Block:
Id: 1
Timestamp: 1678848304009
Nonce: 1966636975
Hash of the previous block:
60e05bd1b195af2f94112fa7197a5c88289058840ce7c6df9693756bc6250f55
Hash of the block:
00000083ea47926e683e406257a71665c2c65e9fcad1e9873df292c06f96d140
Block was generating for 3 seconds
----------------------------------------------------------------
Block:
Id: 2
Timestamp: 1678848307013
Nonce: 2030444268
Hash of the previous block:
00000083ea47926e683e406257a71665c2c65e9fcad1e9873df292c06f96d140
Hash of the block:
000000af5815c38e3086a18db913fdb67423f4718bc97c84b6e3dd31da4ac4e0
Block was generating for 35 seconds
----------------------------------------------------------------
Block:
Id: 3
Timestamp: 1678848342336
Nonce: 2018625516
Hash of the previous block:
000000af5815c38e3086a18db913fdb67423f4718bc97c84b6e3dd31da4ac4e0
Hash of the block:
000000e79bf07f3025687afbe37c09896306db5ad23b72c9476bbf9278359d89
Block was generating for 3 seconds
----------------------------------------------------------------
```

## Description
This is a simulation of a basic blockchain system. It demonstrates how to create blocks with a specified difficulty and validate the integrity of the blockchain. The project consists of a proof-of-work mechanism, where each block contains a `nonce` that satisfies a certain number of leading zeros in the resulting hash.

The project is divided into the following components:
- `StringUtil`: A utility class for handling strings and hashing.
- `Block`: Represents a block in the blockchain.
- `BlockFactory`: An interface for creating blocks.
- `AilaBlockFactory`: A concrete implementation of the `BlockFactory` interface.
- `Blockchain`: A simple implementation of a blockchain with basic validation.
- `Aila`: The main class that demonstrates the usage of the blockchain.

## Features
- Creation of a genesis block.
- Generation of new blocks with a specified difficulty.
- A simple blockchain validation mechanism.
- A proof-of-work mechanism that requires finding a nonce to satisfy the required difficulty.

## Installation
1. Clone the repository:
```bash
git clone https://github.com/ilya2s/project-aila.git
```
2. Import the project into your favorite Java IDE.
3. Ensure that your IDE is configured to use Java 11 or higher.

## Usage
- Run the `Aila` class as the main class.
- By default, the blockchain will generate five blocks with a difficulty level of 5. You can modify the `NUMBER_OF_BLOCKS` and `DIFFICULTY` constants in the `Aila` class to change the number of blocks or the difficulty level.
- The console output will show the generated blocks and their respective information, as well as the validity of the blockchain.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Acknowledgements
This project was inspired by [JetBrains Academy project Blockchain](https://hyperskill.org/projects/50?track=15)
