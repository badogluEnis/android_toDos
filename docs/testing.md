# Testkonzept

#### Positiv Tests

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-1
Anforderungen        | Alle ToDos werden in einer Liste angezeigt
Vorbedingungen       | Mindestens 1 ToDo muss erfasst werden
Ablauf               | 1.	Starten des Apps oder wechseln auf das StartActivity. 2.	Drücken auf den Button offene ToDos(wird automatisch am Anfang angewählt) oder erledigte ToDos.
Erwartetes Resultat  | Man wechselt ins StartActivity und man sieht sein ToDo in der Liste mit dem Titel und dem Ablaufdatum, es sind auch zwei Buttons zu sehen (ToDo erledigt, ToDo bearbeiten)
Testperson           |
Getestet am          |
Resultat             | 
Kommentar (Optional) |

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-2
Anforderungen        | Details über das ToDo in eigenem Activity ersichtlich
Vorbedingungen       | Mindestens 1 ToDo muss erfasste werden
Ablauf               | 1.	Drücken auf das ToDo in der Liste mit den ToDos
Erwartetes Resultat  | Man wechselt auf das DetailsActivity und sieht dort alle anderen Angaben zum ToDo(Titel, Beschreibung, Ablaufdatum)
Testperson           |
Getestet am          | 
Resultat             | 
Kommentar (Optional) | 

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-3
Anforderungen        | Erstellen eines ToDos
Vorbedingungen       | Drücken des Plus und die Daten korrekt eingefügt
Ablauf               | 1.	Dann auf erstellen klicken
Erwartetes Resultat  | Man wechselt ins StartActivity und man sieht sein ToDo in der Liste mit dem Titel und dem Ablaufdatum
Testperson           |
Getestet am          | 
Resultat             | 
Kommentar (Optional) |

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-4
Anforderungen        | Löschen eines ToDos
Vorbedingungen       | Mindestens ein ToDo ist korrekt eingefügt worden
Ablauf               | 1.	Klicken auf das ToDo in der ListView
2.	Bei den Details auf löschen klicken
Erwartetes Resultat  | Man wechselt ins StartActivity und das ToDo ist unauffindbar, in der Datenbank wurde es gelöscht
Testperson           |
Getestet am          | 
Resultat             | 
Kommentar (Optional) |

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-5
Anforderungen       | ToDo als erledigt markieren
Vorbedingungen       | Mindestens ein ToDo ist korrekt eingefügt worden
Ablauf               | 1 Option: 1.	In der Liste auf erledigt Button klicken 2 Option: 1.	In der Liste auf das ToDo klicken 2.	In der Detailsansicht auf erledigt klicken
Erwartetes Resultat  | Man wechselt zum StartActivity und man findet das ToDo nicht, jedoch nach dem Klick auf Erledigte ToDos sollte es ersichtlich sein
Testperson           |
Getestet am          | 
Resultat             | 
Kommentar (Optional) | 

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-6
Anforderungen        | ToDo kann bearbeitet werden
Vorbedingungen       | Mindestens 1 ToDo muss erstellt werden
Ablauf               | 1 Option: 1.	Klick auf das ToDo in der Liste 2.	Klick auf ToDo bearbeiten 3.	ToDo bearbeiten und dann speichern 2 Option: 1.	Klick auf das bearbeiten Icon in der Liste 2.	ToDo bearbeiten und dann speichern
Erwartetes Resultat  | Die neuen Angaben werden übernommen
Testperson           | 
Getestet am          | 
Resultat             | 
Kommentar (Optional) | 

Abschnitt            | Inhalt
---------------------|--------
ID                   | T-7
Anforderungen        | Erstellen eines ToDos
Vorbedingungen       | Drücken des Plus und die Daten korrekt eingefügt
Ablauf               | 1.	Dann auf erstellen klicken 
Erwartetes Resultat  | Man wechselt ins StartAcivity und man sieht sein ToDo in der Liste mit dem Titel und dem Ablaufdatum
Testperson           | 
Getestet am          | 
Resultat             |
Kommentar (Optional) | 




#### Negativ Tests

Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-1
Anforderungen        | 
Vorbedingungen       | 
Ablauf               | 
Erwartetes Resultat  |
Testperson           | 
Getestet am          | 
Resultat             | 
Kommentar (Optional) |

Abschnitt            | Inhalt
---------------------|--------
ID                   | NT-2
Anforderungen        | 
Vorbedingungen       | 
Ablauf               | 
Erwartetes Resultat  |
Testperson           | 
Getestet am          |
Resultat             | 
Kommentar (Optional) |



  #### [Zuück](../README.md)
