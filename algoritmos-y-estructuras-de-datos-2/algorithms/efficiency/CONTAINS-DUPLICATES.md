# Análisis de Complejidad: CONTAINS-DUPLICATES

## Pseudocódigo CLRS

```
CONTAINS-DUPLICATES(A, n)
1  for i = 1 to n - 1
2      for j = i + 1 to n
3          if A[i] == A[j]
4              return TRUE
5  return FALSE
```


## Análisis de Tiempo de Ejecución
### Tabla de costos
| Linea | Costo | 
| ------| ------|
| 1 | -|
| 2 | -|
| 3 | $c_1$|
| 4 | $c_2$|
| 5 | $c_3$|



## Cálculo de tiempo de Ejecución
### WORST CASE

$$\begin{align*}
T(n) &= \sum_{i=1}^{n-1} \left(\sum_{j=i+1}^{n}c_1\right) + c_3 \\
&= \sum_{i=1}^{n-1} \left(\sum_{j=i+1}^{n}c_1 \cdot 1\right) + c_3 \\
&= \sum_{i=1}^{n-1} \left(c_1 \cdot \sum_{j=i+1}^{n}1\right) + c_3 \\
&= \sum_{i=1}^{n-1} \left(c_1 \cdot (n-(i+1)+1)\right) + c_3 \\
&= \sum_{i=1}^{n-1} \left(c_1 \cdot (n-i)\right) + c_3 \\
&= c_1 \sum_{i=1}^{n-1} (n-i) + c_3 \\
&= c_1 \cdot \frac{n(n-1)}{2} + c_3 \\
&= c_1 \cdot \frac{n^2-n}{2} + c_3 \\
&= \frac{n^2c_1 - nc_1}{2} + c_3 \\
&= \frac{c_1 n^2}{2} - \frac{c_1 n}{2} + c_3
\end{align*}$$

Por lo tanto:
$$T(n) \in \Theta(n^2)$$


### BEST CASE

$$\begin{align*}
T(n) = c_1 + c_2
\end{align*}$$
Por lo tanto:
$$T(n) \in \Theta(1)$$


## Resumen

| Caso | Complejidad |
|------|------------|
| **Mejor caso** (duplicado temprano) | $\Theta(1)$ |
| **Peor caso** (sin duplicados) | $\Theta(n^2)$ |


