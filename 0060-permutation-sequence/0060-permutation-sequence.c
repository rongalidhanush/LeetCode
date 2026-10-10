#include <stdlib.h>

char * getPermutation(int n, int k) {
    // Factorial lookup table for up to 9!
    // fact[i] holds the value of i!
    int fact[10] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    // Array to keep track of available numbers from 1 to n
    char nums[10];
    for (int i = 0; i < n; i++) {
        nums[i] = (i + 1) + '0';
    }
    
    // Allocate memory for the resulting permutation string
    char* result = (char*)malloc((n + 1) * sizeof(char));
    result[n] = '\0'; // Null-terminate the string
    
    // Convert k to 0-indexed to make the math align with array indices
    k = k - 1;
    
    for (int i = 0; i < n; i++) {
        // Calculate the index of the digit to pick for the current position
        int idx = k / fact[n - 1 - i];
        
        // Append the selected digit to the result
        result[i] = nums[idx];
        
        for (int j = idx; j < n - 1 - i; j++) {
            nums[j] = nums[j + 1];
        }
        
        k = k % fact[n - 1 - i];
    }
 
    return result;
}