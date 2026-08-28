parts :: [a] -> [[a]]
parts [] = [[]]
parts (x:xs) = parts xs ++ [x : ys | ys <- parts xs]

sumaSubConjuntos :: [[Int]] -> [Int]
sumaSubConjuntos = map sum

tieneN :: [Int] -> Int -> Bool
tieneN [] _ = False
tieneN xs n
  |  n `elem` sumaSubConjuntos (parts xs) = True
  | otherwise = False


-- Ejercicio 1.2
split2 :: [Int] -> [([Int], [Int])]
split2 xs = [(take i xs, drop i xs) | i <- [0.. length xs]]

filtrarSumaIgual :: [([Int], [Int])] -> [([Int], [Int])]
filtrarSumaIgual xs = [x | x <- xs, sum (fst x) == sum (snd x)]

tieneMitadesIguales :: [Int] -> Bool
tieneMitadesIguales [] = False
tieneMitadesIguales xs
  | length (filtrarSumaIgual (split2 xs)) > 0 = True
  | otherwise = False
