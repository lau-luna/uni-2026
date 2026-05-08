# QUICK-SORT

## Pseudocódigo
CLRS
```
QUICK-SORT(A, p, r)
1   if p >= r
2       return
3   i = p-1, j = p
4   while j < r
5       if A[j] < A[r]
6           i = i + 1
7           A[i] <-> A[j]
10      j = j + 1
11  q = i + 1
12  A[q] <-> A[r]
13  QUICK-SORT(A, p, q-1)
14  QUICK-SORT(A, q+1, r)
```


## Análisis de Tiempo de Ejecución
### Tabla de costos
| Linea | Costo | 
| ------| ------|
| 1 | $c_1$|
| 2 | $c_2$|
| 3 | $c_3$|



## Cálculo de tiempo de Ejecución
$$T(n) = c_1 + c_2 + c_3$$
$$T(n) = c_4$$

Por lo tanto:
$$T(n) \in \theta(1)$$

