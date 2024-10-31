package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.Hamburger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class LotteriaHamburgerRepositoryTest {

//    private final List<Hamburger> hamburgers = new ArrayList<>();

//
//    @Test
//    void euqalsTest() {
//        Hamburger compareHamburger = new Hamburger(
//                "테스트용 햄버거",
//                1000,
//                "/none",
//                true,
//                true
//        );
//
//        assertEquals(this.hamburgers.indexOf(compareHamburger), 0, "테스트용 햄버거가 무조건 있어야 한다.");
//
//    }
//
//    @BeforeEach
//    void beforeEach() {
//        Hamburger testHamburger = new Hamburger(
//                "테스트용 햄버거",
//                100,
//                "/none",
//                true,
//                true
//        );
//
//        this.hamburgers.add(testHamburger);
//    }

    private final Set<Hamburger> hamburgers = new HashSet<>();

    @Test
    void saveHamburger() {
        Hamburger hamburger = new Hamburger(
                "사과 햄버거",
                4500,
                "/",
                true,
                false
        );

        this.hamburgers.add(hamburger);
    }

    @Test
    void deleteHamburger() {
        Hamburger hamburger = new Hamburger(
                "사과 햄버거",
                4500,
                "/",
                true,
                false
        );
        if (this.hamburgers.contains(hamburger)) {
            this.hamburgers.remove(hamburger);
        }
    }

    @BeforeEach
    void beforeEach() {
        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거",
                4500,
                "/",
                true,
                false
        );

        this.hamburgers.add(appleHamburger);
    }

}