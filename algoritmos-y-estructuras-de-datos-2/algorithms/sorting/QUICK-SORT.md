# QUICK-SORT

## Pseudocódigo
CLRS
```
QUICK-SORT(A, p, r)
1   if p < r
2       i = p-1
3       for j = p to r-1
4           if A[j] <= A[r]
5               i = i + 1
6               A[i] ↔ A[j]
7      q = i + 1
8      A[q] ↔ A[r]
9      QUICK-SORT(A, p, q-1)
10     QUICK-SORT(A, q+1, r)
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

