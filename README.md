# Aplikacja łącząca dane z różnych źródeł

## Uruchomienie:
Z głównego katalogu należy wykonać komende
``mvn spring-boot:run``

## Działanie aplikacji
Domyślnie aplikacja wykonuje 5 iteracji łączenia danych, określone właciwością:
``config.executor.rounds``

W przypadku niedostępności zewnętrznego API aplikacja przerwie działanie.
