import DesignPattern.TemplateMode.BlankMethod.AbstractMethod;
import DesignPattern.TemplateMode.BlankMethod.ImplMethod;

public class test {
    public static void main(String[] args) {
        AbstractMethod method = new ImplMethod();
        method.tell();

        /**
         * hello world!
         * this is default say
         */
    }
}
