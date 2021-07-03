package de.iad.ef.model;

public class RollOverCounter extends LimitedCounter{
    public  RollOverCounter(){
        super();
    }
    public  RollOverCounter(Integer minCount, Integer maxCount){
        super(minCount,maxCount);
    }
    @Override
    public void count(){
        if(this.isMaximumReached()){
            this.setCount(this.minimumIs());
            return ;
        }
        super.count();
    }

    @Override
    public void uncount(){
        if(this.isMinimumReached()){
            this.setCount(this.maximumIs());
        }else{
            super.uncount();
        }
     }
}
