# 「BUBBLE-SORT」Análisis de Complejidad


## Pseudocódigo

```
BUBBLE-SORT(A, n)
1  for i = n downto 2
2      for j = 1 to i-1
3           if A[j] < A[j+1]
4               A[j] ↔ A[j+1]
```

## Análisis de Tiempo de Ejecución

Recordemos que SWAP es de orden constante $O(1)$.

#### Tabla de Costos

|Línea | Operación | Costo | Worst case | Best case |
|------|-----------|-------|------------|-----------|
| 1 | `for i = n downto 2` | -| n | n |
| 2 | `for j = 1 to i-1` | - | $\sum_{i = 2}^{n} (i-1)$ | $\sum_{i = 2}^{n} (i-1)$ |
| 3 | `if A[j] < A[j+1]` | - | $\sum_{i = 2}^{n} (i-1)$ | $\sum_{i = 2}^{n} (i-1)$ |
| 4 | `A[j] ↔ A[j+1]` | $c_1$ | $\sum_{i = 2}^{n} (i-1)$ | 0 |


### Worst Case

En el peor caso, siempre se hace el SWAP. Sería el caso en que el arreglo esté ordenado de manera descendiente (de mayor a menor).



#### Cálculo de $T(n)$

$$
\begin{align*}
    T(n) &= \sum_{i=2}^{n} \sum_{j=1}^{i-1} 1 \\
         &= \sum_{i=2}^{n} (i-1) - (1) + 1 \\
         &= \sum_{i=2}^{n} (i-1) \\
         &= (2-1) + (3-1) +  \dots + (n-1-1) + (n-1) \\
         &= 1 + 2 +  \dots + (n-2) + (n-1) \\
         &= \sum_{i=1}^{n-1} i \\
         &= \frac{(n-1)((n-1)+1)}{2} \\
         &= \frac{(n-1)n}{2} \\
         &= \frac{n^2-n}{2} \\
    T(n) &= \frac{n^2}{2} - \frac{n}{2}\\
\end{align*}
$$

<br>

El término dominante es $\frac{n^2}{2}$.

$$T(n) \in \Theta(n^2)$$

<br>

### Best Case
En el mejor caso, el arreglo ya está ordenado de menor a mayor,
por lo que el `if` de la línea 3 **nunca se cumple** y el SWAP nunca se ejecuta.

Sin embargo, los dos `for` siguen ejecutándose completos igual que en el peor caso,
ya que no hay ninguna condición que corte los loops antes.

#### Cálculo de $T(n)$
$$
\begin{align*}
    T(n) &= \sum_{i=2}^{n} \sum_{j=1}^{i-1} 1 \\
         & \dots \\
    T(n) &= \frac{n^2}{2} - \frac{n}{2}
\end{align*}
$$

El término dominante es $\frac{n^2}{2}$.
$$T(n) \in \Theta(n^2)$$

## Conclusión

$$\boxed{T(n) \in \Theta(n^2)}$$

Bubble Sort tiene complejidad cuadrática, tanto en el mejor como en el peor caso.

---

## Comparación con otros algoritmos

| Algoritmo | Mejor caso | Peor caso |
|----------------|-----------|-----------|
| Bubble Sort | $\Theta(n^2)$ | $\Theta(n^2)$ |
| Selection Sort | $\Theta(n^2)$ | $\Theta(n^2)$ |
| Insertion Sort | $\Theta(n)$ | $\Theta(n^2)$ |
| Merge Sort | $\Theta(n\log n)$ | $\Theta(n\log n)$ |
| Quick Sort | $\Theta(n\log n)$ | $\Theta(n^2)$ |
