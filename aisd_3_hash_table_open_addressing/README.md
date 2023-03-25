Zadanie 1

a.) Wykorzystując kod zamieszczony jako załącznik do tej sekcji, proszę zaimplementować tablicę mieszającą rozwiązującą kolizje za pomocą adresowania otwartego (w trzech wariantach: adresowaniu liniowym, adresowaniu kwadratowym, podwójnym haszowaniu).

b.) Proszę zwrócić uwagę, że bezpośrednio w pakiecie pl.edu.pw.ee znajdują się cztery pliki z kodem źródłowym (cztery klasy). Klasa HashOpenAdressing jest klasą abstrakcyjną, którą należy rozszerzyć w trzech pozostałych klasach (HashLinearProbing, HashDoubleHashing, HashQuadraticProbing).

c.) Interfejs HashTable w pakiecie services powinien być (bez modyfikacji) implementowany przez klasę abstrakcyjną HashOpenAdressing.

d.) Klasa HashOpenAdressing powinna implementować trzy metody interfejsu:

put(T elem) – dodaje kolejny element do tablicy mieszającej, jeśli jeszcze tego elementu nie ma; jeżeli jest, to zamienia stary element z nowym; jeżeli brakuje miejsca na dodanie nowego elementu, to zwiększa rozmiar tablicy, aby zrobić miejsce dla elementu;
get(T elem) – jeżeli element istnieje w tablicy, to zwraca znaleziony element. Jeżeli elementu nie ma w tablicy, to (mają Państwo wybór) zwraca null lub zgłasza wyjątek;
delete(T elem) – jeżeli element istnieje w tablicy, to usuwa ten element (pamiętając o tym, żeby nie zaburzyć przyszłego działania metody wyszukującej elementy). Jeżeli elementu nie ma, to (mają Państwo wybór) kończy się bez błędu lub zgłasza wyjątek.

e.) Proszę zastany kod poprawić w taki sposób, aby działał prawidłowo.

f.) Proszę nie zmieniać struktury danych (tablicy) przechowującej elementy (hashElems) na inny typ / rodzaj (m.in. implementacje interfejsu List (np. ArrayList)).

g.) Każda z trzech klas rozszerzających klasę abstrakcyjną (czyli każda z klas implementujących metodę abstrakcyjną z klasy HashOpenAdressing) powinna mieć dwa konstruktory: bezparametrowy i z jednym parametrem (początkowym rozmiarem tablicy mieszającej). Wyjątkiem jest klasa HashQuadraticProbing, której drugi konstruktor ma przyjmować trzy parametry (w kolejności: (int) rozmiar tablicy, (double) wartość stałej a, (double) wartość stałej b (gdzie a i b są stałymi we wzorze (patrz: kolejny punkt)).

h.) W klasie implementującej adresowanie kwadratowe, dla wzoru: f(k, i) = (f(k) + a*i + b*i*i) % m, dla konstruktora bezparametrowego, proszę przyjąć dowolne (acz rozsądne) stałe a, b różne od zera.
W klasie implementujacej podwójne haszowanie, dla wzoru: f(k, i) = (f(k) + i * g(k)) % m, proszę przyjąć: f(k)= k % m, g(k)= 1 + (k mod (m-3)), gdzie m jest rozmiarem tablicy mieszającej.

i.) Proszę pamiętać o zabezpieczeniu kodu przed sytuacjami szczególnymi / wyjątkowymi / niebezpiecznymi (zabezpieczamy wszystkie metody, które są dostępne z zewnątrz – te, które można wywołać, odwołując się do instancji klasy).

j.) Dla trzech różnych implementacji adresowania otwartego, proszę napisać testy jednostkowe (w klasach testowych: HashLinearProbingTest, HashQuadraticProbingTest, HashDoubleHashingTest). Testy muszą weryfikować wszystkie wymagania postawione w zadaniu i założenia dokonane przez Państwa (np. zgłaszanie wyjątku, gdy poszukiwany element nie występuje w tablicy).

k.) Proszę pamiętać o konsekwentnym sformatowaniu kodu; o usunięciu wszystkiego (kodu, komentarzy, plików), czego nie chcą Państwo oddawać do oceny (m.in.: nieużywanych zmiennych, metod, importów).
