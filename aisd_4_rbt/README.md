Zadanie 1

(A) Proszę zaimplementować mapę (RbtMap.java) (słownik; tablicę asocjacyjną) pozwalającą na przechowywanie i wyszukiwanie wartości o dowolnym typie danych na podstawie klucza implementującego interfejs Comparable. Mapa powinna być zrealizowana na własnej (stanowiącej rozszerzenie do materiałów do ćwiczenia) implementacji drzewa czerwono-czarnego jednostronnie (lewostronnie) czerwonego (RedBlackTree.java) implementując interfejs MapInterface (MapInterface.java).

(B) Proszę poprawić załączony fragment kodu w taki sposób, aby mapa działała zgodnie z zasadami omawianymi w trakcie zajęć.

(C) Dodawanie do mapy pary o istniejącym już kluczu powinno powodować nadpisanie wartości przypisanej do tego klucza (inaczej: starą wartość zastępujemy nową wartością przy odpowiednim kluczu).

(D) Proszę nie zmieniać nazw klas i pakietów istniejących w projekcie. Można w razie potrzeby dodać dowolną liczbę innych klas i pakietów, które są Państwu potrzebne.

(E) Proszę wykonać implementację testów potwierdzających zgodność istniejącego kodu z założeniami dla mapy realizującej interfejs generyczny (przechowującej klucze dowolnego typu rozszerzającego Comparable). W tym celu należy uzupełnić implementację klasy z testami (RbtMapTest.java) dla klasy implementującej interfejs MapInterface (RbtMap) oraz wykonać implementację testów drzewa czerwono-czarnego (RedBlackTreeTest.java) dla klasy RedBlackTree.

Część II

Zadanie 1
Do klasy drzewa RBT (RedBlackTree.java), proszę dopisać metody:

    public void deleteMax() { 
    }

    public String getPreOrder() { 
    // klucz1:wartość1 klucz2:wartość2 klucz3:wartość3 ... 
    } 

    public String getInOrder() { 
    // klucz1:wartość1 klucz2:wartość2 klucz3:wartość3 ... 
    } 

    public String getPostOrder() { 
    // klucz1:wartość1 klucz2:wartość2 klucz3:wartość3 ... 
    } 
Metoda deleteMax() powinna usuwać element o największym kluczu (jeżeli nie ma czego usunąć, po prostu nic nie robi lub zgłasza "dowolny" wyjątek).

Metoda getPredOrder() powinna zwracać elementy drzewa w porządku pre-order. Zwracany jest łańcuch (string) składający się z par (klucza i wartości połączonych dwukropkiem) odseparowanych od siebie pojedynczą spacją.

Metody getInOrder() oraz getPostOrder() działają analogicznie do metody getPreOrder(), czyli zwracają napisy (string) zbudowane z elementów drzewa (klucz1:wartość1 klucz2:wartość2).
