package DesignPattern.Singleton;

public final class DoubleCheckSingle {

    private volatile static DoubleCheckSingle doubleCheckSingle;

    private DoubleCheckSingle(){}

    public static DoubleCheckSingle getInstance(){
        if (doubleCheckSingle == null){
            synchronized (DoubleCheckSingle.class){
                if (doubleCheckSingle == null) doubleCheckSingle= new DoubleCheckSingle();
            }
        }
        return doubleCheckSingle;
    }

}
