package kr.hs.sdh.workbook2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.service.HamburgerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/lotteria-add-menu")
    private void lotteriaAddMenu(@RequestParam(value = "image") MultipartFile multipartFile, Hamburger hamburger, HttpServletResponse httpServletResponse) throws IOException {
        this.hamburgerService.setHamburger(hamburger, multipartFile);

        httpServletResponse.sendRedirect("lotteria-example");
    }

    @DeleteMapping("/lotteria-delete-menu")
    private Map<String, String> lotteriaDeleteMenu(@RequestParam() String hamburgerName) {
        this.hamburgerService.removeHamburger(hamburgerName);

        return Collections.singletonMap("message", hamburgerName + "이/가 메뉴에서 삭제되었습니다.");
    }

}
