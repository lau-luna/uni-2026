main :: IO ()
main = do
  print (accumulate [1, 0, 0, 0, 6])


isSorted :: Ord a => [a] -> Bool
isSorted []  = True
isSorted [x] = True
isSorted (x:y:ys)
  | x <= y    = isSorted (y:ys)
  | otherwise = False
  
  
incAt :: Int -> [Int] -> [Int]
incAt _ []     = []
incAt 0 (y:ys) = (y+1) : ys
incAt n (y:ys) = y : incAt (n-1) ys

decAt :: Int -> [Int] -> [Int]
decAt _ []     = []
decAt 0 (y:ys) = (y-1) : ys
decAt n (y:ys) = y : decAt (n-1) ys

counter :: Int -> [Int]
counter k = take k (repeat 0)

count :: [Int] -> [Int] -> [Int]
count [] ys     = ys
count (x:xs) ys =  count xs (incAt x ys)

accumulate :: [Int] -> [Int]
accumulate = scanl1 (+)

countingSort :: Ord a => [a] -> Int -> [a]
countingSort [] _  = []
countingSort [x] _ = [x]
countingSort xs k  = fuck haskell
  
example = [1, 0 , 3, 4, 5, -3, 20, 45, 2]
