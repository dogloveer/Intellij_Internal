``` 
WindowLogin -> WindowUserTable -> add New -> WindowFocus -> WindowChoose (trener) -> WindowSummary (focus+ trener)


logowanie - jak nie ma zwroc wyjatek -> wyskakuje popup z informacja -> OK


SELECT * FROM trener t, focus f, trenertofocus tf 
WHERE tf.trenertofocus_trener = t.trener_id AND tf.trenertofocus_focus = f.focus_id AND t.trener_id = 2;

SELECT * FROM trener t, focus f, trenertofocus tf, focustime ft 
WHERE tf.trenertofocus_trener = t.trener_id AND tf.trenertofocus_focus = f.focus_id AND ft.focustime_id = f.focus_time AND t.trener_id = 2;


SELECT * FROM trener t, focus f, trenertofocus tf, focustime ft, materialstofocus mf, materials m 
WHERE tf.trenertofocus_trener = t.trener_id AND tf.trenertofocus_focus = f.focus_id AND ft.focustime_id = f.focus_ti


SELECT t.trener_name, t.trener_surname, t.trener_id, f.focus_name, f.focus_id, ft.focustime_time, m.materials_name FROM trener t, focus f, trenertofocus tf, focustime ft, materialstofocus mf, materials m 
WHERE tf.trenertofocus_trener = t.trener_id AND tf.trenertofocus_focus = f.focus_id AND ft.focustime_id = f.focus_time and mf.materialstofocus_focus = f.focus_id and mf.materialstofocus_materials = m.materials_id 
AND t.trener_id = 1 AND f.focus_id = 4;

==========
SELECT * from materials m, materialstofocus mf, focus f
WHERE mf.materialstofocus_materials = m.materials_id and mf.materialstofocus_focus = f.focus_id and f.focus_name = "stretching";

SELECT m.materials_name from materials m, materialstofocus mf, focus f
WHERE mf.materialstofocus_materials = m.materials_id and mf.materialstofocus_focus = f.focus_id and f.focus_name = "stretching";

rejestracja nowego uzytkownika / walidacja danyuch w UI
admin -> haslo i login zahardkodowane?

trenerzy i ich zajecia predefiniowani w bazie danych -> pomyslec nad wprowadzaniem z UI
[opcja] - na razie hardkodujemy

slajd 5 purseue number/code - o co biega? -> [administrator, na razie hardkodujemy]

wybor typu zajec -> to bedzie wizard ?
[focus -> typ zajec]

trener ma miec info o nim tzn co wymaga na zajecia [atrybuty na zajcia]

wybranie trenera? -> sam trener dla + powiazanie z zajeciami (bez godzin uproszczenie, taki szkielet podstawowy logiki) [opcja ] 

previous choices -> co to jest ?
ostattni slajd - co ma robic add new ?



cos dopisze

```