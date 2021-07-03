package de.iad.ef.model;

public class WarningCounter extends LimitedCounter {
    public WarningCounter(){
        super();
    }
    public WarningCounter(Integer minCount, Integer maxCount){
        super(minCount, maxCount);
    }
    @Override
    public void count(){
        if (!super.isMaximumReached()){
            super.count();
        }else{
            throw new CounterException("Maximum wurde erreicht");
        }
    }
    @Override
    public void uncount(){
        if(super.isMinimumReached()){
           throw new CounterException("Minimum wurde erreicht ");
        }
        super.uncount();
    }
}
