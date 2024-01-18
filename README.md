# Panoramica

L'applicazione è un semplice programma in Java Swing che consente agli utenti di **visualizzare una parabola su un piano cartesiano**. I coefficienti a, b e c della parabola possono essere regolati dinamicamente utilizzando degli slider, aggiornando la rappresentazione grafica in tempo reale.

## Utilizzo

Per eseguire l'applicazione, eseguire la classe `MainApp`, che contiene il metodo principale. Comparirà l'interfaccia utente grafica (GUI), dotata di slider a sinistra per manipolare i coefficienti della parabola e di un display della formula corrente.

## Componenti

1. Classe `Application`
La classe `Application` rappresenta il frame principale dell'applicazione. Include funzionalità come il salvataggio e il caricamento della posizione del frame e inizializza i componenti della GUI.

2. Classe `SliderPanel`
La classe `SliderPanel` gestisce gli slider per regolare i coefficienti a, b e c. Comunica con il `CartesianPanel` per **aggiornare dinamicamente la formula visualizzata**.

3. Classe `CartesianPanel`
La classe `CartesianPanel` **estende** `JPanel` ed è responsabile del disegno del piano cartesiano, degli assi e della parabola basata sui coefficienti a, b e c.

4. Classe `DoubleJSlider`
La classe `DoubleJSlider` **estende** `JSlider` per consentire valori `Double` in output. Ridimensiona i valori in base a un fattore di scala specificato.

5. Classe `MainApp`
La classe `MainApp` funge da punto di ingresso per l'applicazione. Contiene il metodo principale per avviare la GUI.

## Personalizzazione

Sentiti libero di esplorare e modificare il codice in base alle tue esigenze. Puoi migliorare l'applicazione aggiungendo più funzionalità, personalizzando la GUI o migliorando la rappresentazione grafica della parabola.

## Dipendenze

L'applicazione si basa sulla libreria Java Swing per l'interfaccia utente grafica. Assicurati di avere installato un Java Development Kit (JDK) per compilare ed eseguire l'applicazione.

## Autore

L'applicazione è stata creata da:

- Pintescul Patric
- Xu Anqi
- Bel Ahmar Younes
- Santamaria Niccolò
- Barioni Lorenzo

Versione
Questa è la versione 1.1 dell'applicazione, testata sulla JDK 21.
