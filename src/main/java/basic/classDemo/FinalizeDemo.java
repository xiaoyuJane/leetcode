package basic.classDemo;

class FinalizeDemo {
   private String name;

    public FinalizeDemo(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("对象已被销毁");
        System.out.println("释放了资源");
        super.finalize();
    }
}
