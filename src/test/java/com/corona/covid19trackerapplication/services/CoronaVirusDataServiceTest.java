package com.corona.covid19trackerapplication.services;

import com.corona.covid19trackerapplication.models.KoreaStat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoronaVirusDataServiceTest {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @Test
    void getKoreaCovidData_동작테스트() throws IOException {
        //given
        List<KoreaStat> coronaList = new ArrayList<>();
        //when
        coronaList = coronaVirusDataService.getKoreaCovidData();

        assertThat(coronaList.get(0).getCountry()).isEqualTo("합계");
        assertThat(coronaList.get(0).getTotal()).isGreaterThan(0);

    }
}