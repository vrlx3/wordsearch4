package viral.wordsearch4.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import viral.wordsearch4.models.Coordinate;
import viral.wordsearch4.models.Direction;
import viral.wordsearch4.models.Grid;

@Service
public class GridHelper {

	public boolean doesFit(String word, Direction tryDirection, Coordinate tryCoordinate, int width, int height) {
		int wordLength = word.length();
		
		switch (tryDirection) {

		/*
		 * LeftRight CrossLeftUpRightDown, UpDown, CrossRightUpLeftDown, RightLeft,
		 * CrossRightDownLeftUp, DownUp, CrossLeftDownRightUp,
		 */

		case LeftRight -> {
			if((tryCoordinate.y +wordLength-1)<=width)return true;

		}
		case CrossLeftUpRightDown -> {
			if ( (tryCoordinate.y +wordLength-1)<=width && (tryCoordinate.x + wordLength - 1) <= height) {
				return true;
			}

		}
		case UpDown -> {
			if ((tryCoordinate.x + wordLength - 1) <= height) return true;

		}
		case CrossRightUpLeftDown -> {
			if (tryCoordinate.y >= wordLength && (tryCoordinate.x + wordLength - 1) <= height) {
				return true;
			}
			
		}
		case RightLeft -> {
			if (tryCoordinate.y >= wordLength) return true;
			
		}
		case CrossRightDownLeftUp -> {
			if (tryCoordinate.y >= wordLength && tryCoordinate.x >= wordLength) return true;
			
		}
		case DownUp -> {
			if (tryCoordinate.x >= wordLength) return true;
		}
		case CrossLeftDownRightUp -> {
			if ((tryCoordinate.y +wordLength-1)<=width && tryCoordinate.x >= wordLength ) {
				return true;
			}
		}
		
		

		}
		return false;

	}

	public Grid populateWord(String word, Direction tryDirection, Coordinate tryCoordinate, HashMap<Coordinate, String> grid) {
		switch (tryDirection) {

		/*
		 * LeftRight CrossLeftUpRightDown, UpDown, CrossRightUpLeftDown, RightLeft,
		 * CrossRightDownLeftUp, DownUp, CrossLeftDownRightUp,
		 */

		case LeftRight -> {
			for (int i = 0; i < word.length(); i++) {
				Coordinate insertCoordinate = new Coordinate(tryCoordinate.x, tryCoordinate.y + i);
				String insertString = word.substring(i, +1);
				String currentString = grid.get(insertCoordinate);
				
				
			}

		}
		case CrossLeftUpRightDown -> {
			if ( (tryCoordinate.y +wordLength-1)<=width && (tryCoordinate.x + wordLength - 1) <= height) {
				return true;
			}

		}
		case UpDown -> {
			if ((tryCoordinate.x + wordLength - 1) <= height) return true;

		}
		case CrossRightUpLeftDown -> {
			if (tryCoordinate.y >= wordLength && (tryCoordinate.x + wordLength - 1) <= height) {
				return true;
			}
			
		}
		case RightLeft -> {
			if (tryCoordinate.y >= wordLength) return true;
			
		}
		case CrossRightDownLeftUp -> {
			if (tryCoordinate.y >= wordLength && tryCoordinate.x >= wordLength) return true;
			
		}
		case DownUp -> {
			if (tryCoordinate.x >= wordLength) return true;
		}
		case CrossLeftDownRightUp -> {
			if ((tryCoordinate.y +wordLength-1)<=width && tryCoordinate.x >= wordLength ) {
				return true;
			}
		}
		
		

		}
		
	}
}
