package kr.hs.sdh.workbook2.service;

import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.repository.HamburgerRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public final class HamburgerService {

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

}