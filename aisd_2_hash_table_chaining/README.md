Zadanie 1

a.) Wykorzystując załącznik do tej sekcji, proszę zaimplementować tablicę mieszającą.

b.) Klasa HashListChaining powinna implementować interfejs HashTable (początkowo tylko z dwoma metodami: add(...), get(...)).

c.) Interfejs HashTable proszę rozbudować o dodatkową metodę do usuwania elementów z tablicy mieszającej: void delete(Object value).

W przypadku, gdy usuwanego elementu nie ma w tablicy mieszającej, można zignorować tę sytuację lub zgłosić wyjątek (rozsądnej klasy). Każde (działające) rozwiązanie będzie prawidłowe.

d.) Proszę spróbować zmienić implementację w taki sposób, aby HashTable wykorzystywał typy generyczne (<T extends Comparable<T>>).

e.) Proszę napisać testy jednostkowe (w klasie HashListChainingTest) potwierdzające prawidłowość wykonanej implementacji. Jeżeli to konieczne, to proszę do klasy HashListChaining dopisać dodatkowe pomocnicze metody (tylko na potrzeby testów), które pozwolą Państwu zweryfikować prawidłowość implementacji.

f.) Proszę przygotować zestawienie czasu wyszukiwania 100_000 elementów w zależności od rozmiaru tablicy mieszającej. Uwaga! Zmiana! Proszę przyjąć 7 rozmiarów tablicy mieszającej: {1 * 4096, 2 * 4096, 4 * 4096, 8 * 4096, 16 * 4096, 32 * 4096, 64 * 4096}. Kod potrzebny do wykonania zestawienia należy załączyć w repozytorium (w strukturze projektu).
