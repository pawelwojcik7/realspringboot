package real.spring.realspringboot.API;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import real.spring.realspringboot.model.Country;
import real.spring.realspringboot.service.CountryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/country/continent/{continent}")
    public ResponseEntity<List<Country>> getCountriesFromContinent(@PathVariable String continent){

        return ResponseEntity.ok(countryService.getCountriesFromContinent(continent));
    }

    @GetMapping("/country/population/{minPopulation}/{maxPopulation}")
    public ResponseEntity<List<Country>> getCountriesByPopulation(@PathVariable Long minPopulation, @PathVariable Long maxPopulation){

        return ResponseEntity.ok(countryService.getCountriesByPopulation(minPopulation, maxPopulation));
    }

    @GetMapping("/country/area/{minArea}/{maxArea}")
    public ResponseEntity<List<Country>> getCountriesByArea(@PathVariable Long minArea, @PathVariable Long maxArea){

        return ResponseEntity.ok(countryService.getCountriesByArea(minArea, maxArea));
    }

    @GetMapping("/HTML/country/continent/{continent}")
    public ResponseEntity<String> getCountriesFromContinentHTML(@PathVariable String continent){

        return ResponseEntity.ok(countryService.getCountriesFromContinentToString(continent));
    }

    @GetMapping("/HTML/country/population/{minPopulation}/{maxPopulation}")
    public ResponseEntity<String> getCountriesByPopulationHTML(@PathVariable Long minPopulation, @PathVariable Long maxPopulation){

        return ResponseEntity.ok(countryService.getCountriesByPopulationToString(minPopulation, maxPopulation));
    }

    @GetMapping("/HTML/country/area/{minArea}/{maxArea}")
    public ResponseEntity<String> getCountriesByAreaHTML(@PathVariable Long minArea, @PathVariable Long maxArea){

        return ResponseEntity.ok(countryService.getCountriesByAreaToString(minArea, maxArea));
    }




}
