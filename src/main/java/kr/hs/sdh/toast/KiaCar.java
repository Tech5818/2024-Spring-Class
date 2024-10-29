package kr.hs.sdh.toast;

public class KiaCar implements Car {
    @Override
    public void go() {
        System.out.println("간다 기아");
    }

    @Override
    public void back() {
        System.out.println("안간다 기아");
    }
}
