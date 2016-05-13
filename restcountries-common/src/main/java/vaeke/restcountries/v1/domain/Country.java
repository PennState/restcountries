/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package vaeke.restcountries.v1.domain;

import java.util.List;

import lombok.Data;

@Data
public class Country {
	
	private String name;
	
	//@JsonProperty("topLevelDomain")
	//@XmlElementWrapper(name="topLevelDomain")
	private List<String> topLevelDomain;
	
	//@JsonProperty("alpha2Code")
	private String alpha2Code;
	
	//@JsonProperty("alpha3Code")
	private String alpha3Code;
	
	//@JsonProperty("currencies")
	private List<String> currencies;
	
	//@JsonProperty("callingCodes")
	private List<String> callingCodes;
	
	private String capital;
	
	private List<String> altSpellings;
	
	private String relevance;
	
	private String region;
	
	private String subregion;
	
	//@JsonProperty("languages")
	private List<String> languages;
	
	private CountryTranslations translations;
	
	private Integer population;
	
	private List<Double> latlng;
	
	private String demonym;
	
	private Double area;

	private Double gini;

	private List<String> timezones;
	
	private List<String> borders;
	
	private String nativeName;

}
