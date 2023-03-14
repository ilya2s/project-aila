package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;
import java.util.Date;

public class Block {
    public static int idCount = 0;
    private final int id;
    private final long timestamp;
    private final String previousHash;
    private final String hash;
    private final long magic;

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    Block(String previousHash) {
        id = ++idCount;
        timestamp = new Date().getTime();
        this.previousHash = previousHash;
        hash = makeHash();
        magic = 0L;
    }

    String makeHash() {
        return StringUtil.applySha256((
                Long.toString(id)
                + timestamp
                + previousHash));
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
