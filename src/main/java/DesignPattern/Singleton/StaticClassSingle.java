package DesignPattern.Singleton;

public final class StaticClassSingle {
    private StaticClassSingle(){}

    private static class Instance{
        private static final StaticClassSingle SINGLE = new StaticClassSingle();
    }

    public static StaticClassSingle getInstance(){
        return Instance.SINGLE;
    }
}
