package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;
import java.util.Date;

public class Block {
    static int idCount = 0;
    final int id;
    final long timestamp;
    final String previousHash;
    final String hash;

    Block(String previousHash) {
        id = ++idCount;
        timestamp = new Date().getTime();
        this.previousHash = previousHash;
        hash = makeHash();
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
