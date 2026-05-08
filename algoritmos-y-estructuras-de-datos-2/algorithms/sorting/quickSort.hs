main :: IO()
main = do 
  print (quickSort unordered)

unordered = [3, -2, 50, 30, 21, -2, 3, 0, 0]

isSorted :: Ord a => [a] -> Bool
isSorted []     = True
isSorted [x]    = True
isSorted (x:y:ys)
  | x < y     = isSorted (y:ys)
  | otherwise = False
  

quickSort :: Ord a => [a] -> [a]
quickSort []      = []
quickSort (x:xs)  = quickSort menores ++ [x] ++ quickSort mayores
  where
    menores = [a | a <- xs, a <= x]
    mayores = [a | a <- xs, a > x]
