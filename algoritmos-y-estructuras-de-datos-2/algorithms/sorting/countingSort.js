function countingSort(A, B, k) {
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
    // Sort
    for (let i = A.length - 1; i >= 0; i--) {
        B[C[A[i]] - 1] = A[i];
        C[A[i]] = C[A[i]] - 1;
    }
    return B;
}


let A = [2, 0, 2, 3, 5, 9];
let B = [];

console.log(countingSort(A, B, 10));
