package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.Hamburger;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface HamburgerRepository {

    // 햄버거 데이터 전체 조회
    @Select("SELECT * FROM hamburger")
    Set<Hamburger> findHamburgers();

    // 햄버거 데이터 삭제
    @Delete("DELETE FROM hamburger WHERE name = #{name}")
    void deleteHamburger(Hamburger hamburger);

    // 햄버거 데이터 추가/수정
    @Insert("""
        INSERT INTO hamburger(name, price, image_path, is_new, is_recommended)
        VALUES(#{name}, #{price}, #{imagePath}, #{isNew}, #{isRecommended})
        ON DUPLICATE KEY
        UPDATE price = #{price}, image_path = #{imagePath}, is_new = #{isNew}, is_recommended = #{isRecommended}
   """)
    void saveHamburger(Hamburger hamburger);


}