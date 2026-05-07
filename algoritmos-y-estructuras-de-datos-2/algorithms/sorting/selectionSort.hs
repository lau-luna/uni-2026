main :: IO ()
main = do
  print (mergeSort example)


isSorted :: Ord a => [a] -> Bool
isSorted []  = True
isSorted [x] = True
isSorted (x:y:ys)
  | x <= y    = isSorted (y:ys)
  | otherwise = False
  
removeFirst :: Eq a => a -> [a] -> [a]
removeFirst _ [] = []
removeFirst x (y:ys)
  | x == y    = ys
  | otherwise = y : (removeFirst x ys)

mergeSort :: Ord a => [a] -> [a]
mergeSort []     = []
mergeSort [x]    = [x]
mergeSort (x:xs) = m : mergeSort (removeFirst m (x:xs))
  where m = minimum (x:xs)
  

example = [1, 0, 2, 24, -1]
