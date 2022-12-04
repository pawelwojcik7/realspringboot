package real.spring.realspringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import real.spring.realspringboot.model.Country;
import real.spring.realspringboot.repository.CountryRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

  private final CountryRepository countryRepository;

  public List<Country> getCountriesFromContinent(String continent) {

    try {
      return countryRepository.selectByContinent(continent);
    } catch (DataAccessException e) {
      return Collections.emptyList();
    }
  }

  public List<Country> getCountriesByPopulation(Long minPopulation, Long maxPopulation) {

    try {
      return countryRepository.selectByPopulation(minPopulation, maxPopulation);
    } catch (DataAccessException e) {
      return Collections.emptyList();
    }
  }

  public List<Country> getCountriesByArea(Long minArea, Long maxArea, String continent) {

    try {
      return countryRepository.selectByArea(minArea, maxArea, continent);
    } catch (DataAccessException e) {
      return Collections.emptyList();
    }
  }

  public String getCountriesFromContinentToString(String continent) {
    StringBuilder stringBuilder = new StringBuilder();
    List<Country> list = new ArrayList<>();
    try {
      list = countryRepository.selectByContinent(continent);
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    if (list.isEmpty()) {
      return "";
    } else {
      list.forEach(e -> stringBuilder.append(e.toString()).append("<br>"));
      return stringBuilder.toString();
    }
  }

  public String getCountriesByPopulationToString(Long minPopulation, Long maxPopulation) {
    StringBuilder stringBuilder = new StringBuilder();
    List<Country> list = new ArrayList<>();
    try {
      list = countryRepository.selectByPopulation(minPopulation, maxPopulation);
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    if (list.isEmpty()) {
      return "";
    } else {
      list.forEach(e -> stringBuilder.append(e.toString()).append("<br>"));
      return stringBuilder.toString();
    }
  }

  public String getCountriesByAreaToString(Long minArea, Long maxArea, String continent) {
    StringBuilder stringBuilder = new StringBuilder();
    List<Country> list = new ArrayList<>();
    try {
      list = countryRepository.selectByArea(minArea, maxArea, continent);
    } catch (DataAccessException e) {
      e.printStackTrace();
    }
    if (list.isEmpty()) {
      return "";
    } else {
      list.forEach(e -> stringBuilder.append(e.toString()).append("<br>"));
      return stringBuilder.toString();
    }
  }
}
