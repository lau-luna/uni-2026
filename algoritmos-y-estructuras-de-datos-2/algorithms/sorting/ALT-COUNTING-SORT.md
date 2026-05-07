# Counting Sort
Es un algoritmo de ordenamiento que no hace comparaciones.
Tiene el requerimiento de conocer previemente el rango que engloba a todos los elementos del arreglo.

Será eficiente para rangos pequeños, sin  importar el tamaño del arreglo a ordenar.

Sea $R$ el rango.
Llamaremos $k$ a la cantidad de elementos del rango. Formalmente $r = \#R$

<br>

Un ejemplo es ordenar un arreglo de n números con números dentro del rango $[1..10]$.

## Pseudocódigo
CLRS
```
COUNTING-SORT(A, B, k)
1   let C[0..k] be a new array
2   for i = 0 to k
3       C[i] = 0
4   for j = 1 to A.length
5       C[A[j]] = C[A[j]] + 1
    counter = 1
8   for i = 1 to C.length
        for j = counter to C[i]
9           B[j] = i
            counter = counter + 1
11  return B
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

