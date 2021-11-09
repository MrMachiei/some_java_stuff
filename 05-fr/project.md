# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))([UC2](#uc2))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))([UC3](#uc3))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.([UC5](#uc5))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.([UC2](#uc2))
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))([UC4](#uc4))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.

<a id="ac3"></a>
### AC3: System płatności

Zewnętrzny system dokonywania płatności.

## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
 

[Kupujący](#ac2)
* [UC2](#uc2): Licytowanie produktu
* [UC3](#uc3): Wygranie aukcji
* [UC4](#uc4): Przegranie aukcji
* [UC5](#uc5): Przekazanie należności za produkt
---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Licytowanie

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**

1. [Kupujący](#ac2) wybiera aukcję, którą chce licytować.
2. System wyświetla formularz.
3. [Kupujący](#ac2) podaje do systemu proponowaną kwotę.
4. System akceptuje kwotę.
5. System aktualizuje informację o najwyższej ofercie.
6. System informuje o poprawnym zakończeniu licytowania.

**Scenariusze alternatywne:** 

4.A. Podana kwota jest niepoprawna.([BR1](#br1))
* 4.A.1. System informuje o problemie.
* 4.A.2. Przejdź do kroku 1.

<a id="uc4"></a>
### UC3: Wygranie aukcji

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. System zamyka możliwość dalszego licytowania.
2. System informuje kupującego o wygranej aukcji.([BR2](#br2))
3. System inormuje sprzedającego o zakończeniu aukcji.

<a id="uc5"></a>
### UC5: Przekazanie należności za produkt

**Aktorzy:** [Kupujący](#ac2), [System płatności](#ac3)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu wykonanie płatności.
2. System uruchamia system płatności.
3. [Kupujący](#ac2) dokonuje płatności za produkt.
4. [System płatności](#ac3) przekazuje do systemu informacje o płatności.
5. System informuje kupującego o autoryzacji płatności.([BR3](#br3))
6. System informuje sprzedającego o dokonaniu przez kupującego płatności. 
7. System przenosi prawa własności do produktu ze sprzedającego na kupującego.

**Scenariusze alternatywne:** 

5.A. Płatność zakończona niepowodzeniem. 
* 5.A.1. System informuje o problemie.
* 5.A.2. Przejdź do kroku 2.
---
## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informacyjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: Płatność

Cyfrowa transakcja finansowa wykonana za produkt wygrany w ramach aukcji.

### BO4: Prawa własności

Prawa notarialne do produktu podlegającego aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

<a id="br3"></a>
### BR3: Autoryzacja płatności

Płatność zostaje autoryzowana w momencie otrzymania potwierdzenia jej wykonania.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |


