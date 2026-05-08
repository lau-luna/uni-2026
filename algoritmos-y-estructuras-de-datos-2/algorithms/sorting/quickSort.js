function quickSort(arr, p, r) {
    if (p >= r) { return; }
    
    let i = -1, j = 0;
    
    // Partition
    while (j < r)  {
        if (arr[j] < arr[r]) {
            i++;
            swap(arr, i, j);
            j++;
        } else {
            j++;
        }
    }
    let q = i+1;
    swap(arr, q, r);
    
    quickSort(arr, p, q-1);
    quickSort(arr, q+1, r)
} 

function swap (arr, i, j) {
    let aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
}

let a = [1, 0, 4, -3, 5];
quickSort(a, 0, a.length - 1);

console.log(a)
