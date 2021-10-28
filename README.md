[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=447290&assignment_repo_type=GroupAssignmentRepo)
# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Minh Tien Tran, s351909, S351909@oslomet.no
* Charlie Vo, s188910, s188910@oslomet.no
* Rami Maroun, s351882, s351882@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Minh har hatt hovedansvar for oppgave 2. 4, 8 
* Rami har hatt hovedansvar for oppgave 3, 5, og 6. 
* Charlie har hatt hovedansvar for oppgave 7, 9 og 10. 
* Vi har i fellesskap løst oppgave 1. 

EKSTRA KOMMENTAR: På grunn av parprogrammering ble noen oppgaver pushet fra ulike brukere.

# Oppgavebeskrivelse

## Minh


**Oppgave 2** 
Det sjekkes det om er ett tomt array. Hvis dette er sant så returneres 0. Deretter brukes en for-løkke for å gå igjennom arrayet som blit gitt. I for-løkken er det en if-condition som sammenligner to verdier i stigende rekke følge. Dersom verdiene er ulike og stigende, dvs at tallet før er mindre en tallet etter, øker telleren med +1. En annen if-condition er dersom tallet før er større enn tallet etter, da har vi at arrayet ikke er sortert. Tilslutt returneres hjelpevariabelen teller som gir antall ulike verdier.

**Oppgave4**
Først utføres partisjonering for å separere mellom odde tall og partall.Ved bruk av While-løkken går systemet systematisk gjennom og sjekker venstre for oddetall og høyre for partall. Når de finner et kort på hver side som ikke stemmer, bytter disse plass.  Deretter blir det brukt en quicksort for å sorte odde tall og partall. 


**Oppgave 8**
Det lages en klone av arrayet vi får inn og to hjelpe variabler. En for å holde verdien til min indeksen og den andre posisjonen vi befinner oss i indeks-arrayet. Ved bruk av en While-løkke kan vi kjøre en for-loop fram til vi har fylt index-arrayet. Det som skjer i while-loopen er at for-løkken går igjennom og henter ut indeksen til minste verdi i klone arrayet. Endrer verdien til minste verdi til å bli størst tilatt verdi og lagrer indeksen i indeks-arrayet før den hopper videre for å finne neste indeks. 

## Charlie

**Oppgave 7**
Hver tekststreng konverteres til array, så flettes de samme annenhver index i et tredje array. Arrayet blir etter det gjort om til en streng som returneres.


**Oppgave 9**
Første håndteringen i denne oppgaven er å passe på at verdiene står på riktig plass. Så er det bare å sammenlikne om referansetallet er mindre enn verdiene i tabellen for å så forskyve plassene og poppe ut den største av de fire.

**Oppgave 10**
Det opprettes to tomme tabeller hvor hver index tilsvarer bokstaven sin posisjon i alfabetet. Det loggføres antall tilfeller av hvert bokstav. Til slutt sjekkes det om det er flere bokstaver i tabell b i forhold til tabell a. 

KOMMENTAR - Oppgave 10 gir passed når testet på intellij, men failed når testet på github. Usikker på årsak.

## Rami
**Oppgave 3**
Jeg har brukt samme måte som det står i kompediet "Programkode 1.1.7 b".
Jeg brukker to for løkker for å sammenligne elementene med hverander.
Programkodet skjekkes om tallene finnes flere ganger så det  stopper den ander for løkke. til slutt  ser det  om indeksen er like, legger til 1 til count.

**Oppgave 5**
Programkode har bestilte tre arrays.
first: for å legge til det siste elementet i .
last: Den andre for å legge til det første elementet i.
ress: for å legge til restene elementene av array.
Om array har to elementer, bytter dem ved å reserver midlertidig variable "temp".
Hvis array er større en to, brukes tre for-løkke for å bytte rekkefølgen på array.
 
** Oppgave 6 **
I denne oppgaven brukkes temp arrays for å legge k elementer 
som. 
Når k er negativt, plaseres k elementer fra [0 , k-1] i tømt array.
Hvis k er positivt, plaserers a-length -k elementer fra [0, k].
For å hinder array med negativt length, skriveres jeg if-setning for å skifte fra negativt til
positivt. 

**Oppgave 1**
I denne oppgaven er det blitt tatt i bruk bubble sort for å finne fram til den største verdien.
Fungerer slik at vi looper gjennom et array ved hjelp av en for løkke. Underveis sammenligner vi 
verdien mellom to-og-to elementer. Dersom verdien til første element (element med index nærmest 0) 
er større enn det neste leddet bytter disse plass. På denne måten tar vi med elementet med størst verdi 
til slutten.


