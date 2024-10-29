package kr.hs.sdh.toast;

public class Child extends Parent {
    @Override
    void whoAmI() {
        System.out.println("I'm child");
    }

    void hi() {
        System.out.println("hi");
    }
}
