# SudokuS
Sophia Chan

# Description
This is Java program that generates a full 9x9 Sudoku board with dividers showing each 3x3 grid. It uses Arrays and ArrayLists.  

# Logic Summary
The Sudoku board is generated using a recursive "generate(int row, int col)" method, and individual numbers (1-9) are validated through the "isValid(int row, int col, int num)" method. If a randomly picked number from the reference ArrayList is not valid, meaning it already exists in that same row, column, or 3x3 grid, then the generate functions removes it from the reference ArrayList. It then randomly picks another number from the reference ArrayList and checks again. This process repeats until a valid number is identified and placed in the slot. In some cases, the previous randomly generated elements create a situation where there are no possible valid values for a cell. In that situation, the generate method will backtrack, undoing already generated numbers and redoing until it finds a combination in which all of the 81 cells are filled with valid values. The generate method returns true when it reaches last column of the last row (base case).

# File List
1) README.md
2) sudoku.java