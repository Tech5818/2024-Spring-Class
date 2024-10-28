package kr.hs.sdh.toast;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("list");
        String[] fruits = new String[]{"사과", "바나나", "멜론", "수박"};

        modelAndView.addObject("fruits", fruits);
        return modelAndView;
    }
}
