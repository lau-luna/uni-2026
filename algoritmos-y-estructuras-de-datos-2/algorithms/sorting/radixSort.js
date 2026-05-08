function countingSortByDigit(A, d, digitPos) {
    let k = d;
    let C = [];

    for (let i = 0; i < k; i++) {
        C[i] = 0;
    }
    // Count
    for (let j = 0; j < A.length; j++) {
        C[A[j]] = C[A[j]] + 1;
    }
    // Accumulate
    for (let i = 1; i < k; i++) {
        C[i] = C[i] + C[i-1];
    }
    let B = [];
    // Sort
    for (let i = A.length - 1; i >= 0; i--) {
        B[C[A[i]] - 1] = A[i];
        C[A[i]] = C[A[i]] - 1;
    }
    return B;
}

function radixSort(A, d) {
  for (let i = 0; i < d; i++) {
    
  }
}

let A = [2, 0, 2, 3, 5, 9];

console.log(countingSort(A, B, 10));
