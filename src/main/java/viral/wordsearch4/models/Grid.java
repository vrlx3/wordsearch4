package viral.wordsearch4.models;

import java.awt.BufferCapabilities.FlipContents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import viral.wordsearch4.service.GridHelper;

public class Grid {
	private int width;
	private int height;

	public HashMap<Coordinate, String> grid = new HashMap<>();

	@Autowired
	private GridHelper gridHelper;

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;

		for (int w = 1; w <= width; w++) {
			for (int h = 1; h <= height; h++) {
				Coordinate coordinate = new Coordinate(w, h);
				grid.put(coordinate, new String());

			}
		}
	}

	public void fillGrid(List<String> words) {

		// Pick a random starting coordinate
		List<Coordinate> shuffledCoordinates = new ArrayList<>();

		for (int w = 1; w <= width; w++) {
			for (int h = 1; h <= height; h++) {
				Coordinate coordinate = new Coordinate(w, h);
				shuffledCoordinates.add(coordinate);

			}
		}

		Collections.shuffle(shuffledCoordinates);

		// Check if word can fit
		for (int i = 0; i < words.size(); i++) {

			String word = words.get(i);
			int wordLength = word.length();

			boolean nextWord = false;

			while (!shuffledCoordinates.isEmpty() && !nextWord) {
				// We try and find a place
				Coordinate tryCoordinate = shuffledCoordinates.remove(0);

				boolean nextCoordinate = false;

				List<Direction> shuffledDirections = Arrays.asList(Direction.values());
				Collections.shuffle(shuffledDirections);

				while (!shuffledDirections.isEmpty() && !nextCoordinate) {
					Direction tryDirection = shuffledDirections.remove(0);
					boolean didFit = gridHelper.doesFit(word, tryDirection, tryCoordinate, this.width, this.height);
					if (didFit) {
						this.grid = gridHelper.populateWord(word, tryDirection, tryCoordinate, grid);
						nextCoordinate = true;
						nextWord = true;
					}
				}
				
			}

		}

	}
}
