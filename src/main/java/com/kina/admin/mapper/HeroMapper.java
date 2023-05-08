package com.kina.admin.mapper;

import com.kina.admin.bean.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper
public interface HeroMapper {
    public Hero getHero(@Param("number") int number);
}
