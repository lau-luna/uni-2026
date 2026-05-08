main :: IO ()
main = do
  print (selectionSort example)


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

selectionSort :: Ord a => [a] -> [a]
selectionSort []     = []
selectionSort [x]    = [x]
selectionSort (x:xs) = m : selectionSort (removeFirst m (x:xs))
  where m = minimum (x:xs)
  

example = [1, 0, 2, 24, -1]
