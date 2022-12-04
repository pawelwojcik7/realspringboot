package real.spring.realspringboot.repository;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import real.spring.realspringboot.model.Country;

import java.util.List;

@Repository
@AllArgsConstructor
public class CountryRepository {

  private final JdbcTemplate jdbcTemplate;

  // language=SQL
  private static final String SELECT_COUNTRY_BY_CONTINENT =
      "SELECT * FROM `country` WHERE Continent = ?";
  // language=SQL
  private static final String SELECT_COUNTRY_BY_POPULATION =
      "SELECT * FROM `country` WHERE Population BETWEEN ? AND ? ";
  // language=SQL
  private static final String SELECT_COUNTRY_BY_AREA =
      "SELECT * FROM `country` WHERE SurfaceArea BETWEEN ? AND ? AND Continent = ? ";

  public List<Country> selectByContinent(String continent) throws DataAccessException {

    return jdbcTemplate.query(
        SELECT_COUNTRY_BY_CONTINENT,
        ps -> ps.setString(1, continent),
        new BeanPropertyRowMapper<>(Country.class));
  }

  public List<Country> selectByPopulation(Long minPopulation, Long maxPopulation)
      throws DataAccessException {

    return jdbcTemplate.query(
        SELECT_COUNTRY_BY_POPULATION,
        ps -> {
          ps.setLong(1, minPopulation);
          ps.setLong(2, maxPopulation);
        },
        new BeanPropertyRowMapper<>(Country.class));
  }

    public List<Country> selectByArea(Long minArea, Long maxArea, String continent)
            throws DataAccessException {

        return jdbcTemplate.query(
                SELECT_COUNTRY_BY_AREA,
                ps -> {
                    ps.setLong(1, minArea);
                    ps.setLong(2, maxArea);
                    ps.setString(3, continent);
                },
                new BeanPropertyRowMapper<>(Country.class));
    }
}
