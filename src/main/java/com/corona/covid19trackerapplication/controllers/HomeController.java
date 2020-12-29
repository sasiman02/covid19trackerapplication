package com.corona.covid19trackerapplication.controllers;

import com.corona.covid19trackerapplication.models.KoreaStat;
import com.corona.covid19trackerapplication.services.CoronaVirusDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/korea")
    public String korea(Model model) throws IOException {
        List<KoreaStat> koreaStatList = coronaVirusDataService.getKoreaCovidData();

        model.addAttribute("koreaStats", koreaStatList);

        return "korea";
    }
}
