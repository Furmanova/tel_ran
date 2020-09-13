package com.telran;


import java.util.Objects;

public class Transaction {
    private String id;
    private State state;
    private long sum;
    private long created;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return sum == that.sum &&
                created == that.created &&
                id.equals(that.id) &&
                state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, sum, created);
    }

    public Transaction(String id, State state, long sum, long created) {
        this.id = id;
        this.state = state;
        this.sum = sum;
        this.created = created;
    }
    public State getState() {
        return state;
    }
    public long getSum() {
        return sum;
    }


}