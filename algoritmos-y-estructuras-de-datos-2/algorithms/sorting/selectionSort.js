function selectionSort(A) {
    for (let i = 0; i < A.length-1; i++) {
        let minIndex = i; 
        
        for (let j = i+1; j < A.length; j++) {
            if (A[j] < A[minIndex]) {
                minIndex = j
            }   
        }
        
        let aux = A[i];
        A[i] = A[minIndex];
        A[minIndex] = aux;
    }
    return A;
}


let A = [2, 0, 2, 1, 3, 5];

console.log(selectionSort(A));
