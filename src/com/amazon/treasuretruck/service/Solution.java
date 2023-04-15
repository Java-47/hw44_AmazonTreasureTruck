package com.amazon.treasuretruck.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	int treasureTrucksCount = 0;

	public int numberAmazonTreasureTrucks(int rows, int column, List<List<Integer>> grid) {

		search(grid, rows, column);
		return treasureTrucksCount;
	}

	private void search(List<List<Integer>> grid, int rows, int column) {

		List<List<Integer>> gridCopy = grid.stream().map(ArrayList::new).collect(Collectors.toList()); //копия грида

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				if (gridCopy.get(i).get(j) == 1) {
					treasureTrucksCount++;
					searchRecursive(gridCopy, i, j);
				}
			}
		}
	}

	private void searchRecursive(List<List<Integer>> gridCopy, int i, int j) {

		if (i < 0 || i >= gridCopy.size() || j < 0 || j >= gridCopy.get(i).size() || gridCopy.get(i).get(j) == 0) {
			return;
		}
		gridCopy.get(i).set(j, 0); // ставим 0 на клетку если находим

		searchRecursive(gridCopy, i + 1, j); // проверка cправа
		searchRecursive(gridCopy, i - 1, j); // проверка слева
		searchRecursive(gridCopy, i, j + 1); // проверка вверху
		searchRecursive(gridCopy, i, j - 1); // проверка внизу

	}
}
