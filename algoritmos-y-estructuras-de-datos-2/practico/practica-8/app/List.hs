module List where
-- Listas 

data List a = Nil | Add a (List a) deriving (Show, Eq)

listToString :: Show a => List a ->String
listToString Nil = "[]"
listToString xs = "[" ++ listInterior xs ++ "]"

listInterior :: Show a => List a ->String
listInterior Nil = ""
listInterior (Add x Nil) = show x
listInterior (Add x xs) = show x ++ ", " ++ listInterior xs

toList :: [a] ->List a
toList []     = Nil
toList [x]    = Add x Nil
toList (x:xs) = Add x (toList xs)

addFirst :: a ->List a ->List a
addFirst e Nil = Add e Nil
addFirst e (Add x xs) = Add e (Add x xs) 

addLast :: a ->List a ->List a
addLast e Nil = Add e Nil
addLast e (Add x xs) = Add x (addLast e xs)

rmFirst :: List a ->List a
rmFirst Nil = Nil
rmFirst (Add _ xs) = xs 

rmLast :: List a -> List a
rmLast Nil         = Nil
rmLast (Add _ Nil) = Nil
rmLast (Add x xs)  = Add x (rmLast xs)

concatenar :: List a ->List a ->List a
concatenar Nil ys = ys
concatenar (Add x xs) ys = Add x (concatenar xs ys)
