package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.service.HamburgerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HamburgerRestController {
    private final HamburgerService hamburgerService;

    public HamburgerRestController(HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping("/lotteria-menus")
    private List<Hamburger> lotteriaMenus(@RequestParam(defaultValue = "") String hamburgerName) {
        List<Hamburger> hamburgers = this.hamburgerService.getHamburgers();

        return hamburgers.stream().filter(hamburger -> hamburger.getName().contains(hamburgerName)).toList();
    }

}
