# Progetto di programmazione 2020
Progetto d’esame per il corso di programmazione ad oggetti.
## Indice:
* [Introduzione](#Introduzione)
* [Struttura](#Struttura)
* [Funzionamento](#Funzionamento)
* [Classi](#Classi)
* [Chiamate](#Chiamate)
* [Tecnologie](#Tecnologie)
* [Autore](#Autore)
## Introduzione
L’applicazione progettata ha lo scopo di mostrare le funzionalità di ricerca basata su parametri geografici e delle statistiche sulle location ottenute in base all’area di richiesta in termini di query geografica. L’utente attraverso un’interfaccia può inserire delle coordinate per effettuare una ricerca.

## Struttura 
Il diagramma del caso d’uso mostra come l’utente può interagire con il sistema.
![tekst img1](./UML/UseCaseDiagram.jpg)

## Funzionamento
All’avvio dell’applicazione vengono scaricate tutte le informazioni con un download di JSONArray e salvataggio in un ArrayList il quale estrae tutte le informazioni necessarie e successivamente scarica le statistiche per poi mettersi in attesa di una chiamata.
![tekst img2](./UML/SequenceDiagram.jpg)

## Classi
L’applicazione all’interno è composta da molteplici classi.

![tekst img3](./UML/ClassDiagram.jpg)

### Controller
E’ la classe che gestisce le chiamate dell’interfaccia, che si trova in nell’omonimo package;
### Funzionidelcontroller 
Ovvero un’estensione di controller;
### Definizione 
Avviene il download e il salvataggio di informazioni in un ArrayList;
### Informazioni
Al suo interno ci sono tutti i nomi e le coordinate;
### Coordinate 
All’interno troviamo le variabili latitudine e longitudine;
### Stats
La classe che crea una query geografica;
### StatsInterfaccia
E’ l’interfaccia che definisce le fuonzioni poi usate nella classe Stats.

## Chiamate
Per effettuare delle richieste l’utente può consultare la tabella che mostra le varie istruzioni per visualizzare i dati:
| ROTTA | METODO | DESCRIZIONE | BODY |
|---------- | ------------ | ------------------ | --------------------------------------------- |
| /dati | GET | L’utente ha la possibilità di visualizzare una lista di località |  |
| /statistica | POST | L’utente ha la possibilità di ottenere una lista di località nell’area di ricerca da lui desiderata| coppie di coordinate in formato JSON |

Il formato JSON utilizzato dall’utente, con le coppie di coordinate, deve essere inserito in questa forma : 
 
{
 
“Angolo_alto_sinistra”:

                               [

                                        Num1

                                        Num2

                                                    ]

“Angolo_basso_destra”:

                                   [

                                           Num3

                                           Num4

                                                        ]

}

Se l’utente non scrive bene la richiesta viene restituito un messaggio di errore.

## Tecnologie
Eclipse,
SpringBoot,
Maven.

## Autore
Bandello Antonio