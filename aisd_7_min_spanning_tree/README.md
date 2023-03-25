Zadanie 1

Proszę zaimplementować zachłanny algorytm (Kruskala) wyznaczający minimalne drzewo rozpinające (MDR) działający na danych wczytywanych z pliku. W tym celu należy w klasie PrimAlgorithm zaimplementować interfejs MinSpanningTree z metodą findMST(...).
Metoda findMST(...) przyjmuje, jako argument wywołania, ścieżkę do pliku z zapisanym grafem, a zwraca ciąg (łańcuch znaków; String) reprezentujący MDR.

Należy wykonać własną implementację bez wykorzystywania gotowych (dostępnych w bibliotekach Javy) abstrakcyjnych typów danych i struktur danych bardziej zaawansowanych niż dowolne implementacje interfejsu List.

Plik wejściowy powinien być zapisany w formie zgodnej z poniższym przykładem:

nazwaWęzła1 nazwaWęzła2 wagaKrawędzi_1_2

nazwaWęzła1 nazwaWęzła3 wagaKrawędzi_1_3

nazwaWęzła3 nazwaWęzła4 wagaKrawędzi_3_4

W każdym wierszu jest zapisana informacja tylko o jednej krawędzi (nazwy dwóch węzłów i waga krawędzi łączącej te węzły).

Dla uproszczenia implementacji można przyjąć, że:

nazwa węzła jest ciągiem składającym się tylko z liter A-Za-z (bez białych znaków, bez cyfr, bez znaków specjalnych);
waga krawędzi jest liczbą całkowitą nie mniejszą niż 0 (zero);
występowanie pętli (ale nie cykli!) w grafie oznacza nieprawidłowy zestaw wejściowy.
Przykładem pliku wejściowego może być tekst:

A B 3

A C 5

A D 7

B C 1

C D 1

D E 7


Zwracanym ciągiem (wynikiem działania meteody findMST(...)) ma być łańcuch zbudowany zgodnie ze schematem:

nazwaWęzła1<znak podkreślenia>wagaKrawędzi_1_2<znak podkreślenia>nazwaWęzła2<znak potoku>nazwaWęzła1<znak podkreślenia>wagaKrawędzi_1_3<znak podkreślenia>nazwaWęzła3<znak potoku>nazwaWęzła3<znak podkreślenia>wagaKrawędzi_3_4<znak podkreślenia>nazwaWęzła4

Innymi słowy zwracany ciąg ma być zbudowany z bloków w1_k12_w2, gdzie w1 jest nazwą węzła początkowego krawędzi, w2 jest drugim węzłem łączonym krawędzią, a k12 jest wartością wagi (krawędzi) pomiędzy w1 a w2. Jeżeli dołączamy kolejny blok do łańcucha, to miejsce połączenia zaznaczamy znakiem potoku |.

Kolejność występowania bloków w zwracanym ciągu nie ma znaczenia. Kolejność występowania węzłów w danym bloku (w1 przed w2 albo odwrotnie) też nie ma znaczenia.

Przykładowy zwracany ciąg może wyglądać następująco:

A_3_B|B_1_C|C_1_D|D_7_E
  
Poniższe (przykładowe) ciągi, ze względu na korespondencję z powyższym, również są prawidłowe.

B_3_A|C_1_B|D_1_C|E_7_D;
  
C_1_D|D_7_E|A_3_B|B_1_C;
  
D_1_C|E_7_D|B_3_A|C_1_B;
  
B_3_A|E_7_D|C_1_B|D_1_C.

Zaimplementowany algorytm ma uwzględniać sytuację występowania błędów (niezgodności z założeniami) w pliku wejściowym. W każdej sytuacji, gdy występuje odstępstwo od ustalonych założeń, można przerwać działanie algorytmu zgłaszając wyjątek. Proszę pamiętać, że do wyznaczenia MDR potrzebny jest graf spójny.
