/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_fp_12_ex4;

/**
 *
 * @author Jéssica Beatriz
 */
public class Pair<T> {
    protected Pair<T> previous;
    protected T vertex;
    protected double cost;

    public Pair(Pair<T> previous, T vertex, double cost) {
        this.previous = previous;
        this.vertex = vertex;
        this.cost = cost;
    }

    public Pair<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(Pair<T> previous) {
        this.previous = previous;
    }

    public T getVertex() {
        return this.vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
