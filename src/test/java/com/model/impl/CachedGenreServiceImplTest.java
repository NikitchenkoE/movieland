package com.model.impl;

import com.config.RootConfig;
import com.config.WebConfig;
import com.model.GenreService;
import com.testConfig.SpringTestContext;
import net.ttddyy.dsproxy.QueryCountHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Import(SpringTestContext.class)
class CachedGenreServiceImplTest {
    @Autowired
    @Qualifier("cachedGenreServiceImpl")
    private GenreService cachedGenreService;

    @Autowired
    @Qualifier("genreServiceImpl")
    private GenreService genreService;

    @BeforeEach
    void cleanCount() {
        QueryCountHolder.clear();
    }

    @Test
    public void testCountOfQueryToDbShouldBe1() {
        for (int i = 0; i < 10000; i++) {
            cachedGenreService.getAllGenreDto();
        }
        assertEquals(0, QueryCountHolder.getGrandTotal().getTotal());
    }

    @Test
    public void testCountOfQueryToDbShouldBe5() {
        for (int i = 0; i < 5; i++) {
            genreService.getAllGenreDto();
        }
        assertEquals(5, QueryCountHolder.getGrandTotal().getTotal());
    }
}
