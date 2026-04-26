# 「SELECTION-SORT」Análisis de Complejidad: SELECTION-SORT


## Pseudocódigo

```
SELECTION-SORT(A, n)
1  for i = 1 to n - 1
2      min-index = i
3      for j = i + 1 to n
4          if A[j] < A[min-index]
5              min-index = j
6      A[i] ↔ A[min-index]
```

## Análisis de Tiempo de Ejecución

### Tabla de Costos

|Línea | Operación | Costo | Repeticiones |
|-------|-----------|-------|--------------|
| 1 | `for i = 1 to n-1` | - | - |
| 2 | `min-index = i` | $c_1$ | $n-1$ |
| 3 | `for j = i+1 to n` | - | - |
| 4 | `if A[j] < A[min-index]` | $c_2$ | $\sum_{i=1}^{n-1}(n-i)$ |
| 5 | `min-index = j` | $c_3$ | $\leq \sum_{i=1}^{n-1}(n-i)$ |
| 6 | `A[i] ↔ A[min-index]` | $c_4$ | $n-1$ |

### Cálculo de $T(n)$

$$T(n) = (n-1)c_1 + \sum_{i=1}^{n-1}(n-i)c_2 + \sum_{i=1}^{n-1}(n-i)c_3 + (n-1)c_4$$

Evaluamos la sumatoria $\sum_{i=1}^{n-1}(n-i)$:

$$\sum_{i=1}^{n-1}(n-i) = (n-1) + (n-2) + \cdots + 1 = \frac{(n-1)n}{2}$$


Entonces:

$$T(n) = (n-1)c_1 + \frac{(n-1)n}{2}c_2 + \frac{(n-1)n}{2}c_3 + (n-1)c_4$$

$$T(n) = (n-1)c_1 + \frac{(n-1)n}{2}(c_2 + c_3) + (n-1)c_4$$



### Forma simplificada

$$T(n) = \frac{(c_2 + c_3)}{2}n^2 + \left(c_1 + c_4 - \frac{c_2 + c_3}{2}\right)n - (c_1 + c_4)$$

El término dominante es $\frac{(c_2 + c_3)}{2}n^2$.

## Conclusión

$$\boxed{T(n) \in \Theta(n^2)}$$

Selection sort tiene complejidad cuadrática, tanto en el mejor como en el peor caso.

---

## Comparación con otros algoritmos

| Algoritmo | Mejor caso | Peor caso | Promedio |
|----------------|-----------|-----------|----------|
| Selection Sort | $\Theta(n^2)$ | $\Theta(n^2)$ | $\Theta(n^2)$ |
| Insertion Sort | $\Theta(n)$ | $\Theta(n^2)$ | $\Theta(n^2)$ |
| Merge Sort | $\Theta(n\log n)$ | $\Theta(n\log n)$ | $\Theta(n\log n)$ |
| Quick Sort | $\Theta(n\log n)$ | $\Theta(n^2)$ | $\Theta(n\log n)$ |

