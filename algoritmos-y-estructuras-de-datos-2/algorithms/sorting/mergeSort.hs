main :: IO ()
main = do
  let res = mergeSort example
  print res
  print ("Is sorted? " ++ show (isSorted res))
    

split :: [a] -> ([a], [a])
split xs = (take mid xs, drop mid xs)
    where mid = div (length xs) 2

merge :: Ord a => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys)
  | x <= y    = x : merge xs (y:ys)
  | otherwise = y : merge (x:xs) ys

mergeSort :: Ord a => [a] -> [a]
mergeSort []  = []
mergeSort [x] = [x]
mergeSort xs  = merge (mergeSort left) (mergeSort right)
  where (left, right) = split xs
  
isSorted :: Ord a => [a] -> Bool
isSorted []  = True
isSorted [x] = True
isSorted (x:y:ys)
  | x <= y    = isSorted (y:ys)
  | otherwise = False
  
example = [1, 0 , 3, 4, 5, -3, 20, 45, 2]
