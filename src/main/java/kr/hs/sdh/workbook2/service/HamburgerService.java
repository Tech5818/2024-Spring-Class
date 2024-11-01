package kr.hs.sdh.workbook2.service;

import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.repository.HamburgerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public final class HamburgerService {
    private static final String ABSOLUTE_PATH = "C:\\Users\\309\\Desktop\\Workspace\\2024-SpringBootClass\\workbook2\\src\\main\\resources\\static\\images\\";


    // 햄버거 데이터 저장소
    private final HamburgerRepository hamburgerRepository;

    // "HamburgerService" 클래스의 생성자
    public HamburgerService(HamburgerRepository hamburgerRepository) {
        this.hamburgerRepository = hamburgerRepository;
    }

    // 햄버거 데이터를 조회하고 금액 순서로 정렬하여 반환
    public List<Hamburger> getHamburgers() {
        return this.hamburgerRepository.findHamburgers()
            .stream()
            .sorted(
                Comparator.comparing(Hamburger::getPrice)
            )
            .toList();
    }

    // HamburgerRepository의 saveHamburger 메소드를 호출해서 저장하는 메소드를 작성하세요~
    // 메소드 이름은 "setHamburger"입니다.(접근 제어 지시자는 "public", 리턴 타입은 "void"
    public void setHamburger(Hamburger hamburger, MultipartFile multipartFile) {
        final String fileName = multipartFile.getOriginalFilename();

        if (fileName != null && !fileName.isEmpty()) {
            try {
                final File file = new File(ABSOLUTE_PATH + fileName);
                multipartFile.transferTo(file);
                hamburger.setImagePath("/images/" + fileName);
                this.hamburgerRepository.saveHamburger(hamburger);
            } catch (final IOException exception) {
                throw new RuntimeException(exception);
            }
        }

    }
}