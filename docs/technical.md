# Technische Dokumentation
  
  ## Entwicklungumgebung
  
  
  ### Setup
Dieses Projekt wurde auf Windows 7 Enterprise Service Pack 1 mit Visual Studio 2015 Professional (Version 14.0.25431.01 Update 3) programmiert. 
  
  Folgende Gadgets werden verwendet:
  Kinect v1
  
  
  ### Code Style
Wir haben uns dazu entschieden, nach jeder Methode eine Zeile Abstand zu lassen. Die Einrückungen werden nach C-Sharp Standard geregelt.

![image](https://cloud.githubusercontent.com/assets/25527030/26235717/1503a76c-3c6d-11e7-972e-2745ae7e1ea1.png)
  
Zwischen den Kommentaren und der Funktion dürfen keine Zeilen Abstand erfolgen. 
  
![image](https://cloud.githubusercontent.com/assets/25527030/26236187/52d6b2c6-3c6f-11e7-96a5-65b45e35730e.png)

Im WPF schliessen alle Elemente sich selber. (< />)

![image](https://cloud.githubusercontent.com/assets/25527030/26236514/fab300d4-3c70-11e7-8a1d-bd3ebe3196bf.png)

Für den Hintergrund wurde ein Style definiert. 

![image](https://cloud.githubusercontent.com/assets/25527030/26236565/468b7162-3c71-11e7-9f01-92b61820a3f0.png)

Die Button grösse und Textbox grösse haben wir auch vordefiniert.

![image](https://cloud.githubusercontent.com/assets/25527030/26237284/caec0676-3c74-11e7-819d-1108ca2811ec.png)

![image](https://cloud.githubusercontent.com/assets/25527030/26237297/dac9be1c-3c74-11e7-846e-a69fe5edddc3.png)



  ## Architektur
  
  ### Sequenzdiagramm
  * [1.Sequenzdiagramm](img/1.Sequenzdiagramm.png)
  * [2.Sequenzdiagramm](img/2.Sequenzdiagramm.png)
      
  ### Genereller Aufbau der Applikation
  ...
  
  ### Klassendiagramm
  
  ### Trainyourself
  
 * In diesem Projekt ist das ganze GUI vorhanden.
* Jede GUI-Seite hat einen Code behind.
* Wir haben hier sehr viel mit Events gearbeitet. 
* in den Klassen Livesitup/Livepushups werden die ganzen Messungen durchgeführt um zu schauen, ob ein Situp/Pushup gemacht wurde.
* In der Klasse Kalibartion wird die höhe von Hand zu Schulter gemessen, mit dieser werden dann die Situps berechnet. 

  ![image](https://cloud.githubusercontent.com/assets/25527030/26237733/a3dad57e-3c76-11e7-86cd-cbe44b3a8e14.png)

  ### Model
  
* Die Klassen Score, User und Exercice sind gleichzeitig auch Tabellen in unserer Datenbank mit den jeweiligen Attributen. 
* Diese Klassen wurden uns bei der Verbindung zur Datenbank von C-Sharp erstellt.

  ![image](https://cloud.githubusercontent.com/assets/25527030/26237942/5cb13278-3c77-11e7-8466-df4b71c08b84.png)
  
  ### KinectConnection 
  
  * Hier stellen wir die Verbindung zur Kineckt her.
  * Es wir auch die Kamera aktiviert.
  * Die Sensoren um die einzelnen Punkte zu tracken werden hier eingeschaltet.
  
  ![image](https://cloud.githubusercontent.com/assets/25527030/26237986/80a2c386-3c77-11e7-88bf-041c18ba9679.png)

  ### DataAcces
  
 * Die von uns am meisten gebrauchte Klasse hier ist das UserRepository, hier haben wir alle Sql "Querys" geschrieben.(alle Querys wurden mit Linq geschrieben)
* Die Klasse UserRepository erbt von der abstakten Klassen AbstractRepository, welche einige wichtige Funktion beinhaltet( Add, Delete, GetById etc.) 

  ![image](https://cloud.githubusercontent.com/assets/25527030/26238027/a8261a8e-3c77-11e7-81e1-fde3f1c946cc.png)
  
  
  
  
  ## Design
    
  ### Mockups
  Wir haben für unser Projekt folgendes GUI Layout vorgesehen:
  * [Startscreen und Anmelden](img/start.png)
  * [Registrierungsscreen 1](img/register.png)
  * [Registrierungsscreen 2](img/register2.png)
  * [Hauptmenu](img/mainmenu.png)
  * [Liveview Push-Ups](img/liveview.png)
  * [Liveview Sit-Ups](img/liveview2.png)
  * [Profil](img/profile.png)
  
  ## Datenbank und Entity Framework
  In unserem Projekt haben wir auch eine Datenbank integriert. Um Userdaten sowie auch Trainingsfortschritte zu speichern.
  Wir brauchen in unserem Projekt Entity Framework (Verison: 6.1.3) mit Code first.
  
  In unserem Projekt haben wir folgende zwei Tabellen: User und Score. 
  In der User Tabelle werden Daten gespeichert welche jeder User nur ein Mal hat, zum Bespiel: Highscore, Name, Email usw... 
  Hingegen bei der Score Tabelle werden alle Scores vom User gespeichert, dass heisst, jeder User hat mehrere Scores.
  
  Das aktuelle ERM von unserer Datenbank sehen sie [hier](img/erm_tys.PNG).
  
  
  ## Handling der Kinect
  Wie vorher in der Dokumentation erwähnt, haben wir in unserem Projekt eine Kinect eingebaut. In diesem Teil der Doku werden wir alles   was in unserem Projekt mit der Kinect zu tun hat, dokumentieren und festhalten.
  
  ### Die Kamera in der Liveview
  In der Live View sieht man ein Livebild von sich selber. So kann man sich beim Übungen machen selber zuschauen.
  
 ##### Wie haben wir es gemacht?
 Beispiel mit dem Skellet, welches getrackt wird(funktioniert beim Livebild genau gleich einfach mit bilder): 
  
  ![trainyourself1](https://cloud.githubusercontent.com/assets/25528700/26634868/34a267e8-4618-11e7-9933-908f06531720.jpg)
  
  Klicke [hier](https://msdn.microsoft.com/en-us/library/17sde2xt(v=vs.90).aspx) um zur Dokumentation von Events und Delegates zu geraten. 
  
  
  #### [Zurück](../README.md)
