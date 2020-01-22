L’azienda UNTEN gestisce un servizio taxi. Ogni taxi è costituito da un veicolo
(con 4, 7, 14 posti liberi), a guida autonoma o con il suo guidatore. Giorno per
giorno si sa quale taxi è operativo, e per quelli operativi dove sono in ciascun
istante (luogo=latitudine+longitudine).
L’azienda gestisce prenotazioni di viaggi (immediati o nel futuro), e ciascuna
prenotazione è caratterizzata da un luogo di partenza, uno di arrivo, un momento
di partenza (momento=data+orario) richiesto, il numero di posti richiesti e il
passeggero che la chiede. Una prenotazione non è esaudibile se in quel momento
non c’è alcun taxi disponibile in un raggio di 5km (se immediata) o già il 70%
dei taxi sono allocati per altre prenotazioni in quel momento (se futura).
La sede dell’azienda necessita di un’API che consente di:
• richiedere una prenotazione e accettarla o rifiutarla, sulla base di disponibilità
di taxi. La prenotazione può essere immediata o futura.
• suggerire variazioni nella prenotazione in caso non sia possibile esaudirla:
variazioni nel momento o numero passeggeri.
• a fine giornata creare un report che mostri quali viaggi sono stati fatti da
quale taxi dalle 07:00 della mattina.


Cosa fare

Si progetti una o più gerarchie di tipo in Java in modo da supportare le operazioni
indicate sopra. Definire classi e interfacce, le segnature dei metodi, e gli stati
astratti, specificando il ruolo e protocollo delle classi/interfacce e i contratti dei
metodi più importanti; implementare lo stato concreto e i metodi.

Implementazioni richieste:

responsabilità, tipologie, contratti, ADT, parametrizzazione, qualità del body,
pattern di design, astrazioni, incapsulamento, . . .