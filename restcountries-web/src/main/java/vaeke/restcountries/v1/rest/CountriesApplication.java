package vaeke.restcountries.v1.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest/v1")
public class CountriesApplication extends Application {

  private static Set<Class<?>> clazzez = new HashSet<>();
  
  static {
    clazzez.add(CountryRest.class);
  }
  
  public Set<Class<?>> getClasses() {
    return clazzez;
  }
}
