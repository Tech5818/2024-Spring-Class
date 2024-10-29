package kr.hs.sdh.toast;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExampleService {

    public ExampleService() {
    }

    public String[] getFruits() {
        return new String[]{"사과", "바나나", "멜론", "수박"};
    }

    public void driveCar(Car car) {
        car.go();
    }

    public void test() {
        KiaCar kiaCar = new KiaCar();
        HyundaiCar hyundaiCar = new HyundaiCar();

        Parent parent = (Parent) new Child();

        driveCar(kiaCar);
        driveCar(hyundaiCar);
    }

    public Menu getMenu() {
        Menu subMenu1 = new Menu("서브 메뉴1", true);
        Menu subMenu2 = new Menu("서브 메뉴2", false);
        Menu subMenu3 = new Menu("서브 메뉴3", false);
        Menu subMenu4 = new Menu("서브 메뉴4", false);

        List<Menu> subMenus = new ArrayList<Menu>(4);
        subMenus.add(subMenu1);
        subMenus.add(subMenu2);
        subMenus.add(subMenu3);
        subMenus.add(subMenu4);

        Menu rootMenu = new Menu("대메뉴", subMenus);

        return rootMenu;
    }
}
