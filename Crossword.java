import java.util.Scanner;

public class Crossword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = sc.next();
            arr[i] = str.toCharArray();
        }
        int n = sc.nextInt();
        String[] word = new String[n];
        for (int i = 0; i < word.length; i++) {
            word[i] = sc.next();
        }
        solution(arr, word, 0);
        sc.close();
    }

    static void print(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean solution(char[][] arr, String[] word, int vidx){
        if (vidx == word.length) {
            print(arr);
            return true;
        }
        String words = word[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '_' || arr[i][j] == words.charAt(0)) {
                    if (canPlaceHorizontally(arr, words, i, j)) {
                        boolean[] wePlaced = placeWordHorizontally(arr, words, i, j);
                        if (solution(arr, word, vidx + 1)) {
                            return true;
                        }
                        unPlaceWordHorizontally(arr, wePlaced, i, j);
                    }

                    if (canPlaceVertically(arr, words, i, j)) {
                        boolean[] wePlaced = placeWordVertically(arr, words, i, j);
                        if (solution(arr, word, vidx + 1)) {
                            return true;
                        }
                        unPlaceWordVertically(arr, wePlaced, i, j);
                    }
                    print(arr);
                }
            }
        }
        return false;
    }

// Method to check if a word can be placed horizontally at a specific position
    static boolean canPlaceHorizontally(char[][] arr, String word, int i, int j){
        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() > arr[0].length) {
            return false;
        }

        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[0].length) {
                return false;
            }
            if (arr[i][j + jj] == '_' || arr[i][j + jj] == word.charAt(jj)) {
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

// Method to place a word horizontally in the crossword grid 
    static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        for (int jj = 0; jj < wePlaced.length; jj++) {
            if (arr[i][j + jj] == '_') {
                arr[i][j + jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
      
        return wePlaced;
    }
// Method to remove a horizontally placed word from the crossword grid
    static void unPlaceWordHorizontally(char[][] arr, boolean[] wePlaced, int i, int j){
        for (int jj = 0; jj < wePlaced.length; jj++){
            if (wePlaced[jj]) {
                arr[i][j + jj] = '_';
            }
        }
        
    }

// Method to check if a word can be placed vertically at a specific position
    static boolean canPlaceVertically(char[][] arr, String word, int i, int j){
        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;
        } else if (i + word.length() > arr.length) {
            return false;
        }

        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length) {
                return false;
            }
            if (arr[i + ii][j] == '_' || arr[i + ii][j] == word.charAt(ii)) {
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


    // Method to place a word vertically in the crossword grid 
    static boolean[] placeWordVertically(char[][] arr, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        for (int ii = 0; ii < wePlaced.length; ii++) {
            if (arr[i + ii][j] == '_') {
                arr[i + ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
       
        return wePlaced;
    }
    
// Method to remove a vertically placed word from the crossword grid
    static void unPlaceWordVertically(char[][] arr, boolean[] wePlaced, int i, int j){
        for (int ii = 0; ii < wePlaced.length; ii++){
            if (wePlaced[ii] == true) {
                arr[i + ii][j] = '_';
            }
        }
        
    }
}




