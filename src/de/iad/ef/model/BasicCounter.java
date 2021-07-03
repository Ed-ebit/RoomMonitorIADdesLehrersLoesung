package de.iad.ef.model;

public abstract class BasicCounter {
    // Attribute oder Daten
    private  Integer counted;
    private Integer initialCount;
    /* Methoden */
    // Konstruktoren
    protected BasicCounter(){
            this(0);
    }
    protected BasicCounter(Integer initialCount){
            this.counted=initialCount;
            this.initialCount=initialCount;
    }
    // Getter und Setter
    protected void setCount(Integer count){
            this.counted=count;
    }
    // Normale Methoden
    protected void count(){
            ++this.counted;
    }
    protected void uncount(){
            --this.counted;
    }
    public Integer currentCount(){
        return this.counted;
    }
    public void reset(){
        this.counted=this.initialCount;
    }
}
