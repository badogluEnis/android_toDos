# Testkonzept

#### Positiv Tests

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-1
Getestete User Story | [#1](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/1)
Vorbedingungen       | Das Programm kann gestartet werden
Ablauf               | 1. Der Benutzer klickt auf "sign in now". 2. Der Benutzer Registriert sich.
Erwartetes Resultat  | Die Registrierung ist erfolgreich (Das Programm gibt keine Fehlermeldung aus und der User wird in der Datenbank erfasst)
Testperson           | Enis Badoglu
Getestet am          | 10. Mai 2017
Resultat             | Der Test war erfolgreich, dass erwartete Resultat trifft zu.
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-2
Getestete User Story | [#2](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/2)
Vorbedingungen       | Der Benutzer ist registriert
Ablauf               | 1. Der Benutzer Meldet sich mit den zuvor registrierten Accountdaten an.
Erwartetes Resultat  | Die Anmeldung ist erfolgreich, weil ihm keine Fehlermeldung angezeigt wird.
Testperson           | Altin Hani 
Getestet am          | 10.Mai.2017
Resultat             | Ich konnte mich problemlos anmelden
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-3
Getestete User Story | [#26](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/26)
Vorbedingungen       | Der Benutzer hat das Programm offen, hat sich registriert und ist angemeldet.
Ablauf               | 1. Der Benutzer geht im Hauptmenu auf My Profile und drückt dort auf den edit button, gibt seine neuen Daten ein und drückt dann auf den Speichern button.
Erwartetes Resultat  | Die neu eingegebenen Daten werden in der Datebank aktualisiert. 
Testperson           | Flavio Lang
Getestet am          | 10. Mai 2017
Resultat             | Der Test war erfolgreich.
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-4
Getestete User Story | [#34](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/34)
Vorbedingungen       | Der Benutzer hat sich angemeldet und befindet sich im Hauptmenu.
Ablauf               | 1. Der Benutzer klickt Hauptmenu auf Sit-Ups
Erwartetes Resultat  | Das Programm öffnet die Sit-Up page und es wird die [Liveview](img/liveview.png) dargestellt.
Testperson           | Enis Badoglu
Getestet am          | 31.Mai 2017
Resultat             | Die Liveview wurde erfolgreich geöffnet und ich konnte mich selber sehen.
Kommentar (Optional) |

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-5
Getestete User Story | [#38](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/38)
Vorbedingungen       | Der Benutzer hat das Programm gestartet
Ablauf               | 1. Der Benutzer fängt an sich zu registrieren. Sobald er auf die Zweite Seite der Registrierung kommt probiert er in den eingabefelder Kommazahlen zu benutzen. 
Erwartetes Resultat  | Die Registrierung verläuft erfolgreich und der User ist wieder auf dem Startscreen.
Testperson           | Enis Badoglu
Getestet am          | 31. Mai 2017
Resultat             | Der Test war erfolgreich.
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-6
Getestete User Story | [#16](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/16)
Vorbedingungen       | Der Benutzer hat das Programm gestartet und sich eingeloggt.
Ablauf               | 1. Der Benutzer geht auf die Liegestüzen. Er lässt das Programm klaibireren und macht danach Liegestützen. 
Erwartetes Resultat  | Der Counter geht hoch, sobald der User eine Liegestütze gemacht hat.
Testperson           | Enis Badoglu
Getestet am          | 31. Mai 2017
Resultat             | Der Test war erfolgreich.
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-7
Getestete User Story | [#15](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/15) [#18](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/15) 
Vorbedingungen       | Der Benutzer hat das Programm gestartet und sich eingeloggt.
Ablauf               | 1. Der Benutzer geht auf die Liegestüzen. Er lässt das Programm klaibireren und macht danach Liegestützen. 
Erwartetes Resultat  | Der erreichte Wert wird in der Datenbank mit dem richtigen Datum gespeichert.
Testperson           | Enis Badoglu
Getestet am          | 31. Mai 2017
Resultat             | Der Test war erfolgreich.
Kommentar (Optional) | Da der Durchschnitt der bisher gemachten Pushups/Situps in my profile erhöht/gesenkt wurde kann ich davon ausgehen(ohne in die Datenbank zu schauen), dass der Test funktioniert hat.




#### Negativ Tests

Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-1
Getestete User Story | [#1](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/1)
Vorbedingungen       | Der Benutzer hat das Programm offen und hat auf den Button "Sign in now" gedrückt 
Ablauf               | 1. Der Benutzer versucht sich ein 2. mal mit der selben Email zu registrieren 
Erwartetes Resultat  | Es wird eine Fehlermeldung kommen die sagt, dass diese Email schon existiert.
Testperson           | Enis Badoglu
Getestet am          | 10. Mai 2017
Resultat             | Der Test ist erfolgreich ausgefallen. Das erwartete Resultat hat zugetroffen
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-2
Getestete User Story | [#2](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/2)
Vorbedingungen       | Der Benutzer hat das Programm offen und hat auf den Button "Sign in now" gedrückt 
Ablauf               | 1. Der Benutzer gibt bei "Password repeat" nicht das selbe ein wie bei "Password"
Erwartetes Resultat  | Es wird eine Fehlermeldung ausgegeben, welche aussagt dass die beiden Passwort boxen identisch sein müssen. 
Testperson           | Flavio Lang
Getestet am          | 10.Mai 2017
Resultat             | Der Test war erfolgreich.
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-3
Getestete User Story | [#2](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/2)
Vorbedingungen       | Der Benutzer hat das Programm offen.
Ablauf               | 1. Der Benutzer versucht sich anzumelden ohne sich vorher registriert zu haben.
Erwartetes Resultat  | Es wird eine Fehlermeldung ausgegeben, welche aussagt dass entweder das Passwort oder die Email-Adresse welche der User angegeben hat falsch ist. 
Testperson           | Altin Hani
Getestet am          | 10.Mai.2017
Resultat             | Als ich mich anmleden wollte ohne mich vorher registriert zu haen kam eine Fehlermeldung.
Kommentar (Optional) | -
Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-4
Getestete User Story | [#14](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/14)
Vorbedingungen       | Der Benutzer hat das Programm gestartet
Ablauf               | 1. Der Benutzer klickt im startscreen auf den "Quit" Button
Erwartetes Resultat  | Das Programm schliesst sich ohne eine Fehlermeldung auszugeben.
Testperson           | Flavio Lang
Getestet am          | 10. Mai 2017
Resultat             | Der Test war erfolgreich.
Kommentar (Optional) | -
Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-5
Getestete User Story | [#26](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/26)
Vorbedingungen       | Der Benutzer hat das Programm gestartet
Ablauf               | Der Benutzer hat das Programm gestartet und hat einen Account
Ablauf               | 1. Der Benutzer meldet sich an. 2. Der Benutzer geht auf sein Profil. Der Benutzer drückt auf den Button, welcher wie ein stift aussieht. Der Benutzer lässt das Eingabefeld leer. Der Benutzer drückt auf den Speichern Button. 
Erwartetes Resultat  | Es erscheint eine Fehlermeldung welche den User hinweist, dass die Eingafelder nicht leer sein dürfen.
Testperson           | Altin Hani
Getestet am          | 19. Mai 2017
Resultat             | Der Test war erfolgreich.
Kommentar (Optional) | -

Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-8
Getestete User Story | [#32](https://github.com/ICT-BBC/stu-inf-2016-be-trainyourself/issues/32)
Vorbedingungen       | Der Benutzer hat das Programm gestartet, hat das erste Formular für die Registrierung ausgefüllt und hat auf Continue gedrückt. 
Ablauf               | 1. Der Benutzer gibt bei der Grösse/Gewicht anstelle einer Zahl einen Buchstaben ein und drückt auf register.
Erwartetes Resultat  | Es erscheint eine Fehlermeldung welche besagt, dass die Eingaben nur Zahlen sein dürfen.
Testperson           | Altin Hani
Getestet am          | 31. Mai 2017
Resultat             | Der Test war erfolgreich. Ich konnte die Registrierung nicht abschliessen, solange ich nicht Zahlen verwendet habe.

  #### [Zuück](../README.md)
