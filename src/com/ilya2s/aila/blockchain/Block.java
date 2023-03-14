package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Represents a block in the blockchain.
 */
public class Block {
    private final int id;
    private final long timestamp;
    private final String hash;
    private final String previousHash;
    private final int nonce;
    private final Duration generationTime;


    /** The zero hash value for the genesis block. */
    public static final String ZERO_HASH = "0".repeat(64);


    /**
     * Creates a new block with the given ID and previous block hash.
     *
     * @param id the block ID
     * @param previousHash the hash of the previous block in the blockchain
     * @param difficulty the number of leading zeros the block hash should have
     */
    public Block(int id, String previousHash, int difficulty) {
        this.id = id;
        this.previousHash = previousHash;
        timestamp = Instant.now().toEpochMilli();

        Instant startTime = Instant.now();
        nonce = findNonce(difficulty);
        Instant endTime = Instant.now();

        hash = makeHash();
        generationTime = Duration.between(startTime, endTime);
    }


    /**
     * Returns the hash of the previous block in the blockchain.
     *
     * @return the hash of the previous block
     */
    public String getPreviousHash() {
        return previousHash;
    }


    /**
     * Return the hash of this block.
     *
     * @return the hash of this block
     */
    public String getHash() {
        return hash;
    }


    /**
     * Computes the hash of this block.
     *
     * @return the hash of this block
     */
    public String makeHash() {
        return StringUtil.applySha256(previousHash + timestamp + id + nonce);
    }


    /**
     * Finds a nonce that, when added to the block data and hashed,
     * produces a hash with the given number of leading zeros.
     *
     * @param difficulty the number of leading zeros the hash should have
     * @return the nonce that produces a valid hash
     */
    private int findNonce(int difficulty) {
        String target = "0".repeat(difficulty);

        int nonce;
        String hash;

        do {
           nonce = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
           hash = StringUtil.applySha256(previousHash + timestamp + id + nonce);
        } while (!hash.startsWith(target));

        return nonce;
    }


    @Override
    public String toString() {
        return String.format(
                """
                        Block:
                        Id: %d
                        Timestamp: %d
                        Nonce: %d
                        Hash of the previous block:
                        %s
                        Hash of the block:
                        %s
                        Block was generating for %d seconds
                        """, id, timestamp, nonce, previousHash, hash, generationTime.toSeconds());
    }
}
