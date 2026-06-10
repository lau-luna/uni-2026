module BinTree where

data BinTree a = Nil | Node (BinTree a) a (BinTree a) deriving (Show, Eq)

size :: BinTree a ->Int
size Nil = 0
size (Node hi _ hd) = 1 + size hi + size hd

height :: BinTree a ->Int
height Nil = 0
height (Node hi _ hd) = 1 + max (height hi) (height hd)

contains :: Eq a => BinTree a ->a ->Bool
contains Nil _ = False
contains (Node hi r hr) e = r == e || contains hi e || contains hr e 

inOrder :: BinTree a ->[a]
inOrder Nil = []
inOrder (Node hi r hd) = inOrder hi ++ [r] ++ inOrder hd

preOrder :: BinTree a ->[a]
preOrder Nil = []
preOrder (Node hi r hd) = [r] ++ preOrder hi ++ preOrder hd

posOrder :: BinTree a ->[a]
posOrder Nil = []
posOrder (Node hi r hd) = posOrder hi ++ posOrder hd ++ [r]

minElem :: Ord a => BinTree a ->a
minElem Nil = error "arbol vacio"
minElem (Node Nil r Nil) = r
minElem (Node Nil r hd)  = min r (minElem hd)
minElem (Node hi r Nil)  = min r (minElem hi)
minElem (Node hi r hd)   = min r (min (minElem hi) (minElem hd))

espejo :: BinTree a ->BinTree a
espejo Nil = Nil
espejo (Node hi r hd) = Node (espejo hd) r (espejo hi)

mapTree :: (a ->a) ->BinTree a -> BinTree a
mapTree _ Nil = Nil
mapTree f (Node hi r hd) = Node (mapTree f hi) (f r) (mapTree f hd) 

arbol1 :: BinTree Int
arbol1 = Node (Node (Node Nil 1 Nil) 3 (Node (Node Nil 4 Nil) 6 (Node Nil 7 Nil))) 8 (Node Nil 10 (Node (Node Nil 13 Nil) 14 Nil))

arbol2 :: BinTree [Char]
arbol2 = Node (Node Nil "C" Nil) "G" (Node (Node (Node Nil "H" Nil) "I" (Node Nil "J" Nil)) "K" (Node (Node Nil "L" Nil) "M" (Node Nil "N" Nil )))


arbol3 :: BinTree [Char]
arbol3 = Node (Node (Node (Node Nil "A" Nil) "B" (Node Nil "C" Nil)) "D" (Node Nil "F" (Node Nil "G" Nil))) "H" (Node (Node (Node Nil "I" Nil) "J" (Node Nil "K" Nil)) "L" (Node (Node Nil "M" Nil) "N" Nil))
