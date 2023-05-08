package com.kina.admin.service.impl;

import com.kina.admin.bean.Hero;
import com.kina.admin.mapper.HeroMapper;
import com.kina.admin.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HeroServiceImpl implements HeroService {

    @Autowired
    HeroMapper heroMapper;
    public Hero getHeroByNumber(int number) {
        return heroMapper.getHero(number);
    }
}
