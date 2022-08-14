package br.com.gers_library.repositories.projections;

public interface HighestIncidenceCepProjection {
	String getCep();
	String getStreet();
	String getDistrict();
	Integer getCepCount();
}
