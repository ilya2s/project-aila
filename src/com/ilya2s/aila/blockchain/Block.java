package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;

import java.time.Instant;

public class Block {
    private final int id;
    private final long timestamp;
    private final String hash;
    private final String previousHash;

    Block(int id, String previousHash) {
        this.id = id;
        this.timestamp = Instant.now().toEpochMilli();
        this.previousHash = previousHash;
        hash = makeHash();
    }


    String makeHash() {
        return StringUtil.applySha256(previousHash + timestamp + id);
    }

    public int getId() {
        return id;
    }

    public String getPreviousHash() {
        return previousHash;
    }


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
}
