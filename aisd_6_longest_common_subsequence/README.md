Zadanie 1

Proszę zaimplementować algorytm wyznaczania najdłuższego współnego podciągu (NWP).

Do tego celu należy wykorzystać strukturę projektu (w załączniku) z klasą LongestCommonSubsequence.

Proszę uzupełnić implementację klasy LongestCommonSubsequence o:

konstruktor przyjmujący dwa parametry (String topStr, String leftStr) -- napis "z górnej" części macierzy algorytmu, napis "z lewej" części macierzy algorytmu; są to dwa teksty (łańcuchy), dla których wyznaczany będzie NWP;

metodę (findLCS()) wyznaczającą najdłuższy wspólny podciąg -- metoda ma zwracać znaleziony NWP jako obiekt klasy String;

metodę (display()) zwracającą na standardowe wyjście "graficzną" (tekstową) wersję macierzy z algorytmu wyznaczającego NWP -- wykorzystując znaki ASCII (^, <, \) proszę zaprezentować ścieżkę prowadzącą przez kolejne komórki macierzy algorytmu.

Proszę pamiętać o zaimplementowaniu testów jednostkowych stwierdzających poprawność wykonanej przez siebie implementacji.

Założenia dodatkowe:

w przypadku występowania kilku NWP dla danego zestawu słów, powinniśmy zwrócić tylko jeden (dowolny) z wariantów;
nie korzystamy z żadnych gotowych abstrakcyjnych typów danych i struktur danych bardziej zaawansowanych niż implementacje interfejsu List;
nie trzeba uwzględniać różnicy w wielkości znaków (np. a oraz A mogą być traktowane jako te same znaki), ale można też uwzględniać tę różnicę -- jest dowolność wyboru.
