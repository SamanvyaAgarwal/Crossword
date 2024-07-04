# Crossword Puzzle Solver
*This project contains a Java implementation of a crossword puzzle solver. The solution attempts to place a given set of words into a predefined crossword grid using a backtracking algorithm to ensure that all words fit correctly.*                    

## Project Structure
*The main class contains several static methods to solve the crossword puzzle, check word placement, and manage word placement and removal on the crossword grid.*

### Methods
1.  **solution(char[][] arr, String[] words, int num):**

    * *This is the main method that solves the crossword puzzle.*
    * *It recursively tries to place words horizontally and vertically in the grid.*
    * *It prints the grid when a solution is found and returns **'true'**.*
    * *If no solution is found, it returns **'false'**.*

2.  **canPlaceHorizontally(char[][] arr, String word, int i, int j):**

    * *Checks if a word can be placed horizontally at position **'(i, j)'** in the grid.*
    * *Ensures the word fits within the grid boundaries and does not conflict with existing words or blocked cells.*

3.  **placeWordHorizontally(char[][] arr, String word, int i, int j):**

    * *Places a word horizontally at position **'(i, j)'** in the grid.*
    * *Returns a boolean array indicating which positions were newly occupied by the word.*

4.  **unPlaceWordHorizontally(char[][] arr, boolean[] wePlaced, int i, int j):**

    * *Removes a word that was placed horizontally at position **'(i, j)'** in the grid.*
    * *Uses the boolean array returned by **'placeWordHorizontally'** to reset positions to the empty state.*

5.  **canPlaceVertically(char[][] arr, String word, int i, int j):**

    * *Checks if a word can be placed vertically at position **'(i, j)'** in the grid.*
    * *Ensures the word fits within the grid boundaries and does not conflict with existing words or blocked cells.*

6.  **placeWordVertically(char[][] arr, String word, int i, int j):**

     * *Places a word vertically at position **'(i, j)'** in the grid.*
     * *Returns a boolean array indicating which positions were newly occupied by the word.*

7.  **unPlaceWordVertically(char[][] arr, boolean[] wePlaced, int i, int j):**

     * *Removes a word that was placed vertically at position **'(i, j)'** in the grid.*
     * *Uses the boolean array returned by **'placeWordVertically'** to reset positions to the empty state.*
