subsets :: [a] -> [[a]]
subsets [] = [[]]
subsets (x:xs) = map (x:) subs ++ subs
  where subs = subsets xs

containsSubsetSum :: [Int] -> Int -> Bool
containsSubsetSum xs s = s `elem` map sum (subsets xs)

