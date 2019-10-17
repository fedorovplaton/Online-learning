package _6_Collections.Generic;

import java.util.Objects;

class Pair<T1, T2> {
    final private T1 first;
    final private T2 second;

    private Pair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    public T1 getFirst(){
        return first;
    }

    public T2 getSecond(){
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, second);
    }

    public static <T1, T2> Pair <T1, T2> of(T1 f, T2 s){
        return new Pair<>(f, s);
    }
}
