Odpowiedzialności podział na pakiety:
- pl.pawel.linkshell.view.*:
	- Tutaj znajdują się tylko i wyłącznie pliki z tzw."Widokiem"
			czyli tutaj znajdują się wszelkiego rodzaju informacje do komunikacji z końcowym użytkownikiem za pomocą konsoli
	- Zauważ że ten pakiet zależy tylko i wyłącznie od modelu, czyli każda klasa widoku ma `import pl.pawel.linkshell.model.*`
			to oznacza tylko tyle, żeby coś pokazać korzystamy z gotowych istniejących struktur, nie zmieniamy logiki biznesowej
- pl.pawel.linkshell.view.impl:
	- Tutaj znajdują się implementacje widoków
		
- pl.pawel.linkshell.model.*:
	- Tutaj znajdują się tylko i wyłącznie model danych w kontekście struktur danych
	- Pakiet jest całkowicie niezależny, co to oznacza? Oznacza to tyle, iż jesteśmy w stanie stworzyć biblioteke typu *.jar i jej używać,
			nie martwiąć się, że coś się stanie.
	- pl.pawel.linkshell.model.cards.*:
		- Tutaj znajdują się tylko i wyłącznie definicja kart i tali.
		* Wyróżniamy tutaj talie
		* Dla każdego z ludzkich graczy i krupiera
		* Dla stołu
- pl.pawel.linkshell.model.enums.*:
	- Tutaj znajdują się wszelkie klasy enumeryczne dla:
	- Karty
	- Status decyzji gracza do sterowania TURĄ gracza
	- Status gry do sterowania RUNDĄ gry
	- Typ strategi gracza na bazie której gracz będzie podejmował decyzje, dorzucając nową strategię dla krupiera trzeba będzie dodać nowy typ np.: PLAYER_AI_HARD
- pl.pawel.linkshell.model.player.*:
	- Tutaj znajdują się tylko i wyłącznie model graczy,
	- zwróć uwagę, że gracz Dealer ma specjalnę zachowanie, które zależy czy ma ukrytą kartę czy nie (zasady wynikająca z europejskiego BlackJack'a ENHC (european no hole card))
- pl.pawel.linkshell.model.states.*:
	- Tutaj znajdują się rzeczy do przechowywania stanu rozgrywki
- pl.pawel.linkshell.model.strategy.*:
	- Tutaj znajdują się strategie gry dla każdego gracza
	- Każda strategia (wzorzec Strategy) została zaimplementowana jako singleton (wzorzec Singleton).
	- Każdy singletion został zaimplementowany w inny sposób, by pokazać różnicę  w singletonach
	- Każda strategia jako singletion jest pobierana za pomocą fabryki (wzorzec fabryka abstrakycjna),
		by zrzucić odpowiedzialność i powoływać strategie tylko i wyłącznie za pomocą fabryki, która gwarantuje stabilność procesu tworzenia.
	
- pl.pawel.linkshell.controller.*:
	- Tutaj znajduje się "logika biznesowa aplikacji"
	- Klasa `Game` jest odpowiedzialna tutaj tylko i wyłącznie za:
		- zarządza się logiką biznesową za pomocą kontrolera
		- wyświetla się wynik za pomocą widoku dla gry
	- Klasa "GameController` jest odpowiedzialna za przebieg rundy z grą, zawiera w sobie tzw. serwisy które (wzorzec Fasada),
		za pomocą których łatwiej jest organizować sobie kod.
		Zauważ, że kontroller sam w sobie mało robi, praktycznie strzela do serwisów i mówi im co chce od nich.
		I właśnie to robi kontroler, kontroluje to co chce !
	- Zwróć uwagę, że znajdują się tam moje ciekawe TODO ;), nie zawsze idzie gładko z dzieleniem zależności ;)

- pl.pawel.linkshell.controller.manager*:
	- Tutaj znajdują się lub powinny być menedżery do zarządzania stanami gry, rundy, decyzji itp
		
- pl.pawel.linkshell.controller.resolver*:
	- Tutaj znajduje się logika która rozwiąże (ang. resolve) sytuację i wskaże nam co się ma wydarzyć,
		tak byśmy mogli w łatwy sposób wyciągnąć wyniki w postaci np.: modelu
			
- pl.pawel.linkshell.controller.service*:
	- Tutaj znajdują się nasze serwisy, dzięki którym zarządzami każdym tematem osobno i segregujemy zagadnienia
			
Odpowiedzialności podział na klasy:
- BlackJackApplication:
	- Tutaj i tylko tutaj uruchamia się całą aplikację;
	- Tutaj ustalam liczbę uczestników (bez limitu) i liczbę talii kart (max: 8)
	- Tutaj znajduje się workflow aplikacji:
		- przygotowanie gry
		- uruchomienie gry
		- zakończenie gry
	- Jeśli coś zostanie źle skonfigurowane dla gry np.: za dużo talii wsadzonych, brak uczestników gry to aplikacja się wyłączy,
		odpowiedzialna za to jest metoda prepare()