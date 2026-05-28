module Set where

-- CONJUNTOS
data Set a = Empty | Ins a (Set a) deriving (Show, Eq)

toString :: Show a => Set a -> String
toString s = "{" ++ interior s ++ "}"

toSet :: [a] ->Set a
toSet = foldr Ins Empty

interior :: Show a => Set a -> String
interior Empty = ""
interior (Ins x Empty) = show x
interior (Ins x s)     = show x  ++ ", " ++ interior s

insert :: Eq a => a ->Set a ->Set a
insert e Empty = Ins e Empty
insert y (Ins x xs)
  | x == y = Ins x xs
  | x /= y = Ins x (insert y xs)

contains :: Eq a => a ->Set a ->Bool
contains _ Empty = False 
contains e (Ins x s) = e == x || contains e s

union :: Eq a => Set a ->Set a -> Set a
union Empty t     = t
union (Ins x xs) t = union xs (insert x t)

difference :: Eq a => Set a -> Set a -> Set a
difference Empty _ = Empty
difference (Ins x s) t
 | contains x t = difference s t
 | otherwise    = Ins x (difference s t)

a = toSet [1..5]
b = toSet [4..10]
