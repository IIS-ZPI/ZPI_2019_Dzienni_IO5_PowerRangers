DOKUMENTACJA RELEASE NOTES: 

- v.2.0.0 - https://github.com/IIS-ZPI/ZPI_2019_Dzienni_IO5_PowerRangers/wiki/Release-Note-2.0.0
- v.2.1.0 - https://github.com/IIS-ZPI/ZPI_2019_Dzienni_IO5_PowerRangers/wiki/Release-Note-2.1.0
- v.2.2.0 - https://github.com/IIS-ZPI/ZPI_2019_Dzienni_IO5_PowerRangers/wiki/Release-Note-2.2.0


INSTRUKCJA URUCHOMIENIA APLIKACJI :


Sklonuj z githuba projekt frontendu i backendu do lokalnego folderu u siebie na komputerze. (przed tym krokiem warto skonfigurować ssh key)


Przejdź do projektu backendowego i otwórz go np. w IntelliJ


Klikamy w Add configuration


Następnie klikamy w plusik znajdujący się w lewym górnym rogu okienka


Z rozwijanej listy wybieramy Application


Naciskamy na przycisk koło Main class  z trzema kropkami …


Teraz wybieramy plik, w którym jest nasza metoda main “CaishenApplication”
11. Następnie klikamy apply, potem ok


Aby uruchomić backend klikamy w zielony trójkąt, bądź wciskamy (shift+f10)
13.(koniec konfiguracji backendu)
14.Otwórz konsole i sprawdź wersje Node.js
Aby sprawdzić wersję node w terminalu, lub konsoli wpisz:
		node -v


Jeśli nie masz node to wejdź na: https://nodejs.org/en/ i pobierz wersje 10.15.3 LTS, ponieważ na
wersji 12.2.0 jest problem z konfiguracją.


Po zainstalowaniu node wpisz:
	npm install -g @angular/cli


Otwórz projekt frontendowy w Visual Studio Code i otwórz konsole w tym     projekcie
i wpisz:
		npm -i


Następnie wpisz:
		ng serve


Poczekaj aż projekt się skompiluje i otwórz przeglądarkę wpisując w niej adres:
http://localhost:4200/
Przy samym uruchamianiu projektu najpierw postaw backend, a potem frontend.
