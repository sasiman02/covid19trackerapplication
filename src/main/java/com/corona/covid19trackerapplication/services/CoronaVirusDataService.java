package com.corona.covid19trackerapplication.services;

import com.corona.covid19trackerapplication.models.KoreaStat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusDataService {
    private static String KOREA_COVID_DATA_URL = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13";

    @PostConstruct
    public List<KoreaStat> getKoreaCovidData() throws IOException {
        List<KoreaStat> koreaStatList = new ArrayList<>();
        Document doc = Jsoup.connect(KOREA_COVID_DATA_URL).get();
        Elements contents = doc.select("table tbody tr");

        for (Element content : contents) {
            Elements tdContents = content.select("td");

            KoreaStat koreaStats = KoreaStat.builder()
                    .country(content.select("th").text())
                    .diffFromPrevDay(Integer.parseInt(tdContents.get(0).text().replace(",", "")))
                    .total(Integer.parseInt(tdContents.get(1).text().replace(",", "")))
                    .death(Integer.parseInt(tdContents.get(2).text().replace(",", "")))
                    .incidence(Double.parseDouble(tdContents.get(3).text().replace(",", "")))
                    .inspection(Integer.parseInt(tdContents.get(4).text().replace(",", "")))
                    .build();

            koreaStatList.add(koreaStats);
        }

        return koreaStatList;
    }
}
