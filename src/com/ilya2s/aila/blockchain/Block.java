package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;

import java.time.Instant;

/**
 * Represents a block in the blockchain.
 */
public class Block {
    private final int id;
    private final long timestamp;
    private final String hash;
    private final String previousHash;


    /** The zero hash value for the genesis block. */
    public static final String ZERO_HASH = "0".repeat(64);


    /**
     * Creates a new block with the given ID and previous block hash.
     *
     * @param id the block ID
     * @param previousHash the hash of the previous block in the blockchain
     */
    public Block(int id, String previousHash) {
        this.id = id;
        this.timestamp = Instant.now().toEpochMilli();
        this.previousHash = previousHash;
        hash = makeHash();
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


    @Override
    public String toString() {
        return String.format(
                """
                        Block:
                        Id: %d
                        Timestamp: %d
                        Hash of the previous block:
                        %s
                        Hash of the block:
                        %s
                        """, id, timestamp, previousHash, hash);
    }


    /**
     * Computes the hash of this block.
     *
     * @return the hash of this block
     */
    public String makeHash() {
        return StringUtil.applySha256(previousHash + timestamp + id);
    }
}
