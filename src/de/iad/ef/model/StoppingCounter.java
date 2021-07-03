package de.iad.ef.model;

public class StoppingCounter extends LimitedCounter{
    public StoppingCounter(){
        super();
    }
    public StoppingCounter(Integer minCount, Integer maxCount){
        super(minCount, maxCount);
    }
    @Override
    public void count(){
        if (!super.isMaximumReached()){
            super.count();
        }
    }
    @Override
    public void uncount(){
        if(!super.isMinimumReached()){
            super.uncount();
        }
    }
}
