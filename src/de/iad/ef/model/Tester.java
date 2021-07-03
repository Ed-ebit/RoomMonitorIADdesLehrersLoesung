package de.iad.ef.model;

class TestSuiteApp {
      public static void main(String[] args) {
      //BasicCounterTest testUmgebung = new BasicCounterTest();
        //testStandardKonstruktor(testUmgebung);
        //testParameterKonstruktor(testUmgebung);
        //testSetUndReset(testUmgebung);
          //LimitedCounterTest testUmgebung = new LimitedCounterTest();
          //test_Standard_Konstruktor_MaximumIs_und_IsMaximumReached(testUmgebung);
         // LimitedCounterTest.Tester tester = testUmgebung.new Tester(-10, 42);
          //test_Parameter_Konstruktor_minimumIs_isMinimuReached(tester);
          //new RollOverCounterTest().start();
          //new StoppingCounterTest().start();
          WarningCounterTest wcounter = new WarningCounterTest();
          wcounter.allgemeineTest();
          //wcounter.maximumException();
          wcounter.minimumException();
      }

    private static void test_Parameter_Konstruktor_minimumIs_isMinimumReached(LimitedCounterTest.Tester tester) {
        System.out.println("Test Standard Konstruktor erwartet -10  "+
                (tester.currentCount()==-10 ? "ok":"fehler"));
        System.out.println("Test MinimumIs erwartet -10  "+
                (tester.minimumIs()==-10 ? "ok":"fehler"));
        System.out.println("Test isMinmunReached erwartet true "+
                (tester.isMinimumReached()==true ? "ok":"fehler"));
        tester.count();
        System.out.println("Test isMinimunReached erwartet false "+
                (tester.isMinimumReached()==false ? "ok":"fehler"));
    }

    private static void test_Standard_Konstruktor_MaximumIs_und_IsMaximumReached(LimitedCounterTest testUmgebung) {
        LimitedCounterTest.Tester tester = testUmgebung.new Tester();
        System.out.println("Test Standard Konstruktor erwartet 0 und geliefert wird 0 "+
                (tester.currentCount()==0 ? "ok":"fehler"));
        System.out.println("Test MaximumIs erwartet 999  "+
                (tester.maximumIs()==999 ? "ok":"fehler"));
        System.out.println("Test isMaximunReached erwartet false "+
                (tester.isMaximumReached()==false ? "ok":"fehler"));
        tester.setCount(999);
        System.out.println("Test isMaximunReached erwartet true "+
                (tester.isMaximumReached()==true ? "ok":"fehler"));
    }

}
class WarningCounterTest{
    private WarningCounter counter = new WarningCounter();
    public void allgemeineTest(){

        System.out.println("Test Standard Konstruktor erwartet 0  "+
                (counter.currentCount()==0 ? "ok":"fehler"));
        System.out.println("Test Standard Konstruktor erwartet 999  "+
                (counter.maximumIs()==999 ? "ok":"fehler"));
    }
    public void maximumException(){
        counter.setCount(999);
        System.out.println("Test Obergrenze erwartet 999  "+
                (counter.currentCount()==999 ? "ok":"fehler"));
        counter.count();

    }
    public void minimumException(){

        counter.uncount();

    }
}
class StoppingCounterTest{
    public void start(){
        StoppingCounter counter = new StoppingCounter();
        System.out.println("Test Standard Konstruktor erwartet 0  "+
                (counter.currentCount()==0 ? "ok":"fehler"));
        counter.setCount(999);
        System.out.println("Test Obergrenze erwartet 999  "+
                (counter.currentCount()==999 ? "ok":"fehler"));
        counter.count();
        System.out.println("Test Stopp  erwartet 999  "+
                (counter.currentCount()==999? "ok":"fehler"));
        counter.setCount(1);
        System.out.println("Test Ruckwaertszaehlen erwartet 1  "+
                (counter.currentCount()==1 ? "ok":"fehler"));
        counter.uncount();
        counter.uncount();
        System.out.println("Test Untergrenze Stopp erwartet 0 "+
                (counter.currentCount()==0 ? "ok":"fehler"));
    }
}
class RollOverCounterTest{
    public void start(){
        RollOverCounter counter = new RollOverCounter();
        System.out.println("Test Standard Konstruktor erwartet 0  "+
                (counter.currentCount()==0 ? "ok":"fehler"));
        counter.setCount(999);
        System.out.println("Test Obergrenze erwartet 999  "+
                (counter.currentCount()==999 ? "ok":"fehler"));
        counter.count();
        System.out.println("Test Ueberlauf erwartet 0  "+
                (counter.currentCount()==0 ? "ok":"fehler"));
        counter.count();
        System.out.println("Test Vorwaetszaeheln erwartet 1  "+
                (counter.currentCount()==1 ? "ok":"fehler"));
        counter.uncount();
        counter.uncount();
        System.out.println("Test Untergrenze Ueberlauf erwartet 999  "+
                (counter.currentCount()==999 ? "ok":"fehler"));
    }
}

class LimitedCounterTest{
    class Tester extends LimitedCounter{
        public Tester(){
                super();
        }

        public Tester(Integer min, Integer max){
            super(min,max);
        }
    }
}

class BasicCounterTest {
    class Tester extends BasicCounter{

        public Tester(){
            super(); // Konstruktoraufruf ind der Basisklasse
        }
        public Tester(Integer initVal){
            super(initVal);
        }
        @Override
        public Integer currentCount() {
            return super.currentCount();
        }
        @Override
        public void reset() {
            super.reset();
        }
        @Override
        public void setCount(Integer count) {
            super.setCount(count);
        }
    }
    private static void testSetUndReset(BasicCounterTest testUmgebung) {
        Tester tester = testUmgebung.new Tester(42);
        System.out.println("Test Paramter Konstruktor erwartet 42 und geliefert wird 42 "+
                (tester.currentCount()==42 ? "ok":"fehler"));
        tester.setCount(4711);
        System.out.println("Set Count auf 4711 erwartet 4711 und geliefert wird 4711 "+
                (tester.currentCount()==4711 ? "ok":"fehler"));
        tester.reset();
        System.out.println("Test Reset erwartet 42 und geliefert wird 42 "+
                (tester.currentCount()==42 ? "ok":"fehler"));
    }

    private static void testParameterKonstruktor(BasicCounterTest testUmgebung) {
        Tester tester = testUmgebung.new Tester(4711);
        System.out.println("Test Paramter Konstruktor erwartet 4711 und geliefert wird 4711 "+
                (tester.currentCount()==4711 ? "ok":"fehler"));
    }

    private static void testStandardKonstruktor(BasicCounterTest testUmgebung) {
        Tester tester = testUmgebung.new Tester();
        System.out.println("Test Std Konstruktor erwartet 0 und geliefert wird 0 "+
                (tester.currentCount()==0 ? "ok":"fehler"));
    }
}
