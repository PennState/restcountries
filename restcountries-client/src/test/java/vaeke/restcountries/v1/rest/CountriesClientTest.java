package vaeke.restcountries.v1.rest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import vaeke.restcountries.v1.domain.Country;
import vaeke.restcountries.v1.exception.RestClientException;

@Slf4j
public class CountriesClientTest {

  CountriesClient countriesClient;
  
  @Before
  public void setUp() {
    countriesClient = new CountriesClient();
  }
  
  @Test
  public void testGetAllCountries() {
    List<Country> countryList = null;
    
    try {
      countryList = countriesClient.getAllCountries();
    } catch (RestClientException e) {
      e.printStackTrace();
      fail(e.getMessage());
    } catch (Throwable t) {
      t.printStackTrace();
      fail(t.getMessage());
    }
    
    log.info(countryList.size() + " countries found");
    assertTrue(!countryList.isEmpty());
  }

//  @Test
//  public void testGetAllCountries() {
//    List<Country> countryList = null;
//    
//    try {
//      countryList = countriesClient.getAllCountries();
//    } catch (RestClientException e) {
//      e.printStackTrace();
//      fail(e.getMessage());
//    } catch (Throwable t) {
//      t.printStackTrace();
//      fail(t.getMessage());
//    }
//    
//    log.debug(countryList.size() + " countries found");
//    assertTrue(!countryList.isEmpty());
//  }
}
