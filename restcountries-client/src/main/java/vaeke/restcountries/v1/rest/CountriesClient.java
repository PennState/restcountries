package vaeke.restcountries.v1.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.extern.slf4j.Slf4j;
import vaeke.restcountries.v1.domain.Country;
import vaeke.restcountries.v1.exception.RestClientException;

@Slf4j
public class CountriesClient {
  
  public static final String BASE_URL = "http://restcountries.eu/rest/v1/";
  
  public List<Country> getAllCountries() throws RestClientException {
    Client client = ClientBuilder.newClient();
    String url = BASE_URL + "all";
    log.info(url);
    WebTarget target = client.target(url);

    Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
    
    log.info("Status return " + response.getStatus());
    
    checkForSuccess(response);
    
    List<Country> countryList = response.readEntity(new GenericType<List<Country>>() {});
    
    return countryList;
  }

  public List<Country> getCountriesByCountryCode(String countryCode) throws RestClientException {
    Client client = ClientBuilder.newClient();

    String url = BASE_URL + "alpha";
    log.info(url);
    WebTarget target = client.target(url).queryParam("codes", countryCode);

    Response response = target.request().accept(MediaType.APPLICATION_JSON).get();
    
    log.info("Status return " + response.getStatus());
    
    checkForSuccess(response);
    
    List<Country> countryList = response.readEntity(new GenericType<List<Country>>() {});
    
    return countryList;
  }
  
  public static void checkForSuccess(Response response) throws RestClientException {
    Response.Status.Family responseFamily = response.getStatusInfo().getFamily();
    
    if (responseFamily.equals(Response.Status.Family.CLIENT_ERROR)||
        responseFamily.equals(Response.Status.Family.SERVER_ERROR))
    {
      throw new RestClientException(response);
    }
  }
}
