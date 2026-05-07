function mergeSort(A) {
    // Base case
    if (A.length < 2) {
        return A;
    }
    
    // Split array in half
    let mid = Math.floor(A.length / 2);
    let left = A.slice(0, mid);
    let right = A.slice(mid);
    
    // Sort both of the sides
    left = mergeSort(left);
    right = mergeSort(right);
    
    // Merge
    let sorted = [];
    while (left.length && right.length) {
        if (left[0] < right[0]) {
            sorted.push(left.shift());
        } else {
            sorted.push(right.shift());
        }
    }
    
    // If one of the sides empties, concat to the end of sorted
    if (left.length) { sorted = [...sorted, ...left] }
    if (right.length) { sorted = [...sorted, ...right] }
    
    return sorted;
}

let A = [1, 0, -4, 25, 32, 7, -2, 1];

console.log(mergeSort(A));
