package com.model.impl;

import com.config.SpringTestContext;
import com.config.WebConfig;
import com.model.GenreService;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, SpringTestContext.class})
class CachedGenreServiceImplTest {
    @Autowired
    @Qualifier("cachedGenreServiceImpl")
    private GenreService cachedGenreService;

    @Autowired
    @Qualifier("genreServiceImpl")
    private GenreService genreService;

    @Test
    public void testCountOfQueryToDbShouldBe1() {
        for (int i = 0; i < 10000; i++) {
            cachedGenreService.getAllGenreDto();
        }
        assertEquals(1, QueryCountHolder.getGrandTotal().getTotal());
        QueryCountHolder.clear();
    }

    @Test
    public void testCountOfQueryToDbShouldBe5() {
        for (int i = 0; i < 5; i++) {
            genreService.getAllGenreDto();
        }
        assertEquals(5, QueryCountHolder.getGrandTotal().getTotal());
        QueryCountHolder.clear();
    }
}
