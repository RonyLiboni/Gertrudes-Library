package br.com.gers_library.util;

import java.util.List;

import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HighestIncidenceCepProjectionTestUtil implements HighestIncidenceCepProjection{
	private String cep;
	private String street;
	private String district;
	private Integer cepCount;
	
	public static List<HighestIncidenceCepProjection> buildListWithOneCepCountAsTheHighest() {
		return List.of(
				HighestIncidenceCepProjectionTestUtil.builder()
					.cep("01001000")
					.cepCount(5)
					.build(),
					
				HighestIncidenceCepProjectionTestUtil.builder()
					.cep("02002000")
					.cepCount(4)
					.build(),
					
				HighestIncidenceCepProjectionTestUtil.builder()
					.cep("03003000")
					.cepCount(4)
					.build()
					);					
	}
	
	public static List<HighestIncidenceCepProjection> buildListWithTwoCepCountAsTheHighest() {
		return List.of(					
				HighestIncidenceCepProjectionTestUtil.builder()
					.cep("01001000")
					.cepCount(4)
					.build(),
					
				HighestIncidenceCepProjectionTestUtil.builder()
					.cep("02002000")
					.cepCount(4)
					.build(),
					
				HighestIncidenceCepProjectionTestUtil.builder()
					.cep("03003000")
					.cepCount(3)
					.build()
					);
	}
}
