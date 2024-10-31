package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.service.HamburgerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public final class HamburgerController {

    private final HamburgerService hamburgerService;

    public HamburgerController(final HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping(value = "/lotteria")
    private String lotteria(final Model model) {
        final List<Hamburger> hamburgers = this.hamburgerService.getHamburgers();

        final List<Hamburger> recommendHamburgers = hamburgers.stream()
                .filter(Hamburger::isRecommended)
                .toList();

//        model.addAttribute("hamburgers", hamburgers);

        model.addAttribute("hamburgers", recommendHamburgers);

        return "lotteria";
    }

    @GetMapping(value = "/lotteria-example")
    private String lotteriaExample() {
        return "lotteria-example";
    }

}
