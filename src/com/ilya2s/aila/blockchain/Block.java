package com.ilya2s.aila.blockchain;

import com.ilya2s.aila.util.StringUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class Block {
    protected static long idCount = 0;
    protected final long id;
    protected final long timestamp;
    protected final String previousHash;
    protected final String hash;

    public Block(String previousHash) {
        this.id = ++idCount;
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.hash = makeHash();
    }

    @NotNull
    protected String makeHash() {
        return StringUtil.applySha256((
                Long.toString(this.id)
                + this.timestamp
                + this.previousHash));
    }

    @Override
    public String toString() {
        return "Block:" + System.getProperty("line.separator") +
                "Id: " + this.id + System.getProperty("line.separator") +
                "Timestamp: " + this.timestamp + System.getProperty("line.separator") +
                "Hash of the previous block:" + System.getProperty("line.separator") +
                this.previousHash + System.getProperty("line.separator") +
                "Hash of the block:" + System.getProperty("line.separator") +
                this.hash;
    }


}
