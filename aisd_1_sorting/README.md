Zadanie 1

A.) Proszę zaimplementować interfejs Sorting w klasach InsertionSort, SelectionSort, QuickSort.


B.) Proszę uzupełnić klasy testów jednostkowych (projekt dostępny jest jako załącznik). W testach proszę uwzględnić:

sytuacje wyjątkowe;

sortowanie zbioru danych optymistycznych;

sortowanie zbioru danych pesymistycznych;

sortowanie zbioru danych nieuporządkowanych;

sortowanie pseudolosowo wygenerowanego (ze stałą, indywidualnie wybraną, wartością ziarna seed, aby testy były deterministyczne) dużego zbioru danych. Uwaga! Wielkość zbioru powinna być odpowiednio dobrana do konkretnego algorytmu, aby poszczególne testy nie trwały dłużej niż ok. 1 minuty na maszynach dostępnych w laboratorium.

C.) Proszę poprawić implementację QuickSort w taki sposób, aby kompilowała się i działała prawidłowo. Należy ograniczyć się tylko do niezbędnej liczby poprawek. Warto odnotować sobie, co (i dlaczego) zostało zmienione.

D.) Wykonaną pracę należy przesłać do repozytorium. A ostatni commit z zajęć należy oznaczyć tagiem LAB_1_1. Tag również należy wysłać do repozytorium.

Zadanie 2

A.) Proszę zaimplementować algorytm sortowania z wykorzystaniem kopca (implementujący Sorting). W tym celu należy zaimplementować własną klasę (Heap) realizującą kopiec (HeapInterface).

B.) Proszę napisać osobne klasy testujące kopiec (HeapTest) jak i algorytm sortowania (HeapSortTest).

C.) Proszę założyć, że próba wyjęcia elementu z pustego kopca powinna zgłaszać (przez nas zaplanowany) wyjątek np.: ArrayIndexOutOfBoundsException.

D.) Klasa HeapSort powinna implementować interfejs Sorting. Klasa Heap powinna realizować interfejsy: HeapInterface, HeapExtension. Kod do uzupełnienia znajduje się w załączniku aisd_lab_1_2_sorting.7z.

E.) W klasie Heap należy uzupełnić implementację metod: put(...), pop(), heapify(...).
Dwie pierwsze służą wkładaniu elementów do kopca i ich wyjmowaniu (Uwaga na punkt: C.)). Trzecia metoda ma przywracać strukturę kopca zaczynając od indeksu startId (to jest rodzic, od którego porównujemy dzieci) i idąc w dół (jeżeli musieliśmy zrobić zamianę) nie osiągając indeksu endId.

F.) Implementacja klasy HeapSort jest w zasadzie dana. Należy napisać testy i nanieść poprawki, jeżeli uznają Państwo, że są one konieczne. Proszę się upewnić, że implementacja działa prawidłowo.

G.) Metoda build() z klasy Heap (z interfejsu HeapExtension) służy do budowania kopca. Gdy wywołamy konstruktor przyjmujący dane jako listę (ArrayList), dane te nie spełniają same z siebie własności kopca. Musimy je tak zmienić, aby otrzymać kopiec. Do tego służy metoda build(). Proszę się zastanowić (i podjąć ewentualne kroki w wyniku tego zastanowienia), czy nie należy rozważyć sprawdzania "czy kopiec jest kopcem" przed użyciem metod: pop(), put(...). Co mogłoby się stać, gdybyśmy wykorzystali konstruktor Heap(...), a później wywołali pop() bez wcześniejszego wywołania build()? Czy z kopca zostanie zdjęta największa wartość?

H.) Do zbioru czterech klas implementujących algorytmy należy dołożyć kolejną o nazwie: RefAlgorithm. Ta klasa powinna implementować interfejs Sorting, a jej działanie powinno sprowadzać się do wykorzystania metody sort(...) z klasy Arrays (java.util.Arrays.sort(...)).

I.) Proszę pamiętać o czytelności wykonanych implementacji.

J.) Proszę przygotować kod do testowania wydajności algorytmów (do porównania czasu działania algorytmów sortowania). Kod ma mieć możliwość uruchomienia jako testy jednostkowe. Zalecane jest stworzenie kolejnych, osobnych klas testowych dla wszystkich pięciu algorytmów sortowania (np. InsertionSortPerformanceTest.java).
