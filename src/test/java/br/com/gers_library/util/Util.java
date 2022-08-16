package br.com.gers_library.util;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class Util {	
	
	public static Pageable buildPageable() {
		return new PageImpl<>(List.of("")).getPageable();
	}
			


}