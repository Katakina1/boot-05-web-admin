package com.kina.admin.mapper;

import com.kina.admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface CityMapper {
    @Select("select * from city where id = #{id}")
    public City getById(@Param("id") Long id);

    public void insert(City city);
}
