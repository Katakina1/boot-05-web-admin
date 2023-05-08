package com.kina.admin.service.impl;

import com.kina.admin.bean.City;
import com.kina.admin.mapper.CityMapper;
import com.kina.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityServiceImpl implements CityService {
    @Autowired
    CityMapper cityMapper;

    public City getById(Long id) {
        return cityMapper.getById(id);
    }

    public void saveCity(City city) {
        cityMapper.insert(city);
    }
}
