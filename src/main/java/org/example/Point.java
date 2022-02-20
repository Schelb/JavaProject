package org.example;

import java.util.Objects;

public class Point<T> implements Printable {
    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    private T x;
    private T y;

    public Point(T x , T y){
        this.x = x;
        this.y = y;
    }
    public Point(){
    }
    @Override
    public void print() {
        System.out.printf("%f", x);
        System.out.printf("%f", y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point<?> point = (Point<?>) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
