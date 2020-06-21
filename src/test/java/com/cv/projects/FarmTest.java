package com.cv.projects;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class FarmTest {
	Farm farm;

	@BeforeEach
	void beforeEach(TestInfo info) {
		System.out.println("***** Checking " + info.getDisplayName() + " *****");
	}

	@Test
	@DisplayName ("For barren-land-areas {\"0 1 1 0\", \"0 5 3 5\"} get all fertile areas sorted in asccending order by area-size")
	void test_getAllFertileAreas_2BarrenLandsOn4x6Farm() {
		String[] barrens = {"0 1 1 0", "0 5 3 5"};
		assertEquals (Arrays.asList(20), (new Farm(4, 6, barrens)).getAllFertileAreas());
	}
	
	@Test
	@DisplayName ("For barren-land-areas {\"0 5 3 5\", \"2 2 2 2\", \"0 3 3 3\"} get all fertile areas sorted in asccending order by area-size")
	void test_getAllFertileAreas_3BarrenLandsOn4x6Farm() {
		String[] barrens = {"0 5 3 5", "2 2 2 2", "0 3 3 3"};
		assertEquals (Arrays.asList(4, 11), (new Farm(4, 6, barrens)).getAllFertileAreas());
	}
	
	@Test
	@DisplayName ("For barren-land-areas {\"0 0 1 1\", \"0 5 3 5\", \"2 2 2 2\", \"0 3 3 3\"} get all fertile areas sorted in asccending order by area-size")
	void test_getAllFertileAreas_4BarrenLandsOn4x6Farm() {
		String[] barrens = {"0 0 1 1", "0 5 3 5", "2 2 2 2", "0 3 3 3"};
		assertEquals (Arrays.asList(2, 4, 5), (new Farm(4, 6, barrens)).getAllFertileAreas());
	}
	
	@Test
	@DisplayName ("For barren-land-areas {\"0 0 1 1\", \"0 5 3 5\", \"1 1 2 2\", \"0 3 3 3\"}; get all fertile areas sorted in asccending order by area-size")
	void test_getAllFertileAreas_FourOverlappingBarrenLandsOn4x6Farm() {
		String[] barrens = {"0 0 1 1", "0 5 3 5", "1 1 2 2", "0 3 3 3"};
		assertEquals (Arrays.asList(1, 4, 4), (new Farm(4, 6, barrens)).getAllFertileAreas());
	}
	
	@Test
	@DisplayName ("For one barren-land-area {\"0 292 399 307\"} get all fertile areas sorted in asccending order by area-size")
	void test_getAllFertileAreas_OneBarrenLandOn400x600Farm() {
		String[] barrens = {"0 292 399 307"};
		assertEquals (Arrays.asList(116800, 116800), (new Farm(400, 600, barrens)).getAllFertileAreas());
	}
	
	@Test
	@DisplayName ("For nultiple barren-land-areas {\"48 192 351 207\", \"48 392 351 407\", \"120 52 135 547\", \"260 52 275 547\"} get all fertile areas sorted in asccending order by area-size")
	void test_getAllFertileAreas_MultipleBarrenLandOn400x600Farm() {
		String[] barrens = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
		assertEquals (Arrays.asList(22816, 192608), (new Farm(400, 600, barrens)).getAllFertileAreas());
	}

	@AfterEach
	void afterEach(TestInfo info) {
		System.out.println("===== End of test " + info.getDisplayName() + " =====");
		System.out.println();
	}

}
