package kr.hs.sdh.toast;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class MenuService {

    private final List<Menu> rootMenus;

    public MenuService() {
        this.rootMenus = new ArrayList<>(4);
    }

    public List<Menu> getRootMenus() {
        return this.rootMenus;
    }

    @PostConstruct
    private void construct() {
        final Menu rootMenu1 = new Menu(
            "학교소개",
            this.toMenus("설립정신", "교육철학")
        );
        final Menu rootMenu2 = new Menu(
            "알림마당",
            this.toMenus("공지사항", "가정통신문", "일정달력", "자유게시판")
        );
        final Menu rootMenu3 = new Menu(
            "학교생활",
            this.toMenus("학생회", "자율동아리", "행사사진")
        );
        final Menu rootMenu4 = new Menu(
            "행정공개",
            this.toMenus("학교운영위원회", "행정소식")
        );

        this.rootMenus.add(rootMenu1);
        this.rootMenus.add(rootMenu2);
        this.rootMenus.add(rootMenu3);
        this.rootMenus.add(rootMenu4);
    }

    private List<Menu> toMenus(String... menuNames) {
        return Stream.of(menuNames)
                .map(Menu::new)
                .toList();
    }

}
