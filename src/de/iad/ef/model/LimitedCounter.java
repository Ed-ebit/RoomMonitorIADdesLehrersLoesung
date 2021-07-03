package de.iad.ef.model;

public abstract class LimitedCounter extends BasicCounter {
   private final Integer DEFAULT_MAXIMUM = Integer.MAX_VALUE ;
   private final Integer DEFAULT_MINIMUM = Integer.MIN_VALUE ;

    private  Integer minimumCount;
    private Integer maximumCount;
    /* Methoden  */
    //Konstruktoren
    protected  LimitedCounter(){
       /* super();
        this.maximumCount=999;
        this.minimumCount=0;*/
        this(0,999);
    }
    protected  LimitedCounter(Integer min, Integer max){
        super(min);
        this.maximumCount=max;
        this.minimumCount=min;
    }
    // Getter und Setter
    public Integer getDEFAULT_MAXIMUM() {
        return DEFAULT_MAXIMUM;
    }

    public Integer getDEFAULT_MINIMUM() {
        return DEFAULT_MINIMUM;
    }

    public Integer minimumIs() {
        return minimumCount;
    }

    public Integer maximumIs() {
        return maximumCount;
    }
    // Methoden
    public Boolean isMaximumReached(){
        if(this.currentCount().equals(this.maximumCount)){
            return true;
        }
        return false;
        //return this.currentCount()==maximumCount; // Achtung noch Fehlerhaft, das Adressvergleich!!!
    }
    public Boolean isMinimumReached(){
        if((int)this.currentCount()==(int)minimumCount){
            return true;
        }
        return false;
    }
}
