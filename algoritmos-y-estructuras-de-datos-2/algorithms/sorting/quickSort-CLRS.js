function quickSort(A, p, r) {
    if (p >= r)
        return;
    let q = partition(A, p, r);
    quickSort(A, p, q-1);
    quickSort(A, q+1, r);
}

function partition(A, p, r) {
    let x = A[r];
    let i = p-1;
    for (let j = p; j < r; j++) {
        if (A[j] <= x) {
            i++;
            exchange(A, i, j);
        }
    }
    exchange(A, i+1, r);
    return i+1;
}

function exchange(A, i, j) {
    let aux = A[i];
    A[i] = A[j];
    A[j] = aux;
}

let arr = [1, 3, 0, -20, -50, 20, -1, 0, 0, 42];
quickSort(arr, 0, arr.length-1);
console.log(arr);
