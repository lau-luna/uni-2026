module Natural where

data Nat = Zero | Succ Nat deriving Show

toInt :: Nat ->Integer
toInt Zero = 0
toInt (Succ n) = 1 + toInt n

suma :: Nat ->Nat ->Nat
suma Zero m     = m
suma (Succ n) m = Succ (suma n m)

resta :: Nat ->Nat ->Maybe Nat
resta Zero Zero = Just Zero
resta Zero _    = Nothing
resta n Zero    = Just n
resta (Succ n) (Succ m) = resta n m

producto :: Nat ->Nat ->Nat
producto Zero _     = Zero
producto (Succ n) m = suma m (producto n m)

restarDosVeces :: Nat -> Nat -> Nat -> Maybe Nat
restarDosVeces x y z = resta x y >>= \r ->resta r z
