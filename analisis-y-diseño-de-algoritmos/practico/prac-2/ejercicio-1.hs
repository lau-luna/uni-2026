-- Resolver por fuerza bruta / busqueda exhaustiva

--  Dado un conjunto s y un valor n, decidir si existe un subconjunto de s cuya suma sea n.
--
-- 1. Calcular todos los subconjuntos del conjunto s
-- 2. hacer la suma de los subconjuntos
-- 3. revisar si la suma de alguno de los subconjuntos es igual a n
--

subsets :: [Int] -> [[Int]]
subsets [] = [[]]
subsets (x:xs) = subsets xs ++ map (x:) (subsets xs)

sumarSubconjuntos :: [[Int]] -> [Int]
sumarSubconjuntos = map sum

sumaIgualAN :: [Int] -> Int -> Bool
sumaIgualAN [] _ = False
sumaIgualAN xs n
    | length (filter (== n) (sumarSubconjuntos (subsets xs))) > 0 = True
    | otherwise = False

--  Decidir si un conjunto de enteros se puede particionar en dos conjuntos de igual suma.
--
--  1. calcular todas las formas de partir un cojunto en dos mitades
--  2. calcular la suma de las mitades
--  3. fijarse si alguna mitad es igual a la otra

split :: [Int] -> [([Int], [Int])]
split xs = [(take i xs, drop i xs) | i <- [0 .. length xs]]

sumarMitades :: [([Int], [Int])] -> [(Int, Int)]
sumarMitades xs = [(sum (fst m), sum (snd m)) | m <- xs]

filtrarMitadesIguales :: [(Int, Int)] -> [(Int, Int)]
filtrarMitadesIguales [] = []
filtrarMitadesIguales xs = [n | n <- xs, fst n == snd n]

mitadesIguales :: [Int] -> Bool
mitadesIguales [] = False
mitadesIguales xs
    | length (filtrarMitadesIguales (sumarMitades (split xs))) > 0 = True
    | otherwise = False

-- Dadas dos cadenas, decidir si las mismas son anagramas (una es permutación de la otra).
--
-- 1. calcular todas las permutaciones de la primera cadena
-- 2. comprobar si alguna de esas permutaciones es igual a la segunda cadena
--
-- Una optimizacion podria ser que si las cadenas tienen longitudes distintas, automaticamente es False


permute :: [a] -> [[a]]
permute [] = [[]]
permute (x:xs) = [ take i y ++ [x] ++ drop i y | y <- permute xs, i <- [0..length xs]] 

esAnagrama :: [Char] -> [Char] -> Bool
esAnagrama s t
    | s `elem` permute t = True
    | otherwise = False



-- Dadas dos cadenas p y s, decida si p es subsecuencia de s (los elementos no necesariamente tienen que aparecer contiguos en s)
--
-- para cada elemento de p, remover su primera aparicion en s, y el propio elemento de p
-- si s se queda sin elementos, entonces si es subsecuencia

remove :: Eq a => a -> [a] -> [a]
remove _ [] = []
remove x (y:ys)
  | x == y = ys
  | otherwise = y: remove x ys

esSubsecuencia :: Eq a => [a] -> [a] -> Bool
esSubsecuencia [] _ = True
esSubsecuencia (x:xs) ys
  | x `elem` ys = esSubsecuencia xs (remove x ys) 
  | otherwise = False


-- Dada una secuencia s de números, encontrar el k-ésimo elemento más grande en s.
--
-- 1. ordenar la lista de manera descendiente
-- 2. devolver el k-esimo elemento, por ej: k=2 debe devolver el segundo elemento mas grande de la lista

selectionSort :: Ord a => [a] -> [a]
selectionSort [] = []
selectionSort [x] = [x]
selectionSort xs = m : selectionSort (remove m xs)
  where m = minimum xs

selectionSortInv :: Ord a => [a] -> [a]
selectionSortInv [] = []
selectionSortInv [x] = [x]
selectionSortInv xs = m : selectionSortInv (remove m xs)
  where m = maximum xs

kLargestElem :: Ord a => Int -> [a] -> a
kLargestElem n xs = selectionSortInv xs !! (n-1)
