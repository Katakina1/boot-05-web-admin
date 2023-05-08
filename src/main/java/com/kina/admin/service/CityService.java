package com.kina.admin.service;

import com.kina.admin.bean.City;

public interface CityService {
    public City getById(Long id);

    public void saveCity(City city);
}
