``` 
WindowLogin -> WindowUserTable -> add New -> WindowFocus -> WindowChoose (trener) -> WindowSummary (focus+ trener)
logowanie - jak nie ma zwroc wyjatek -> wyskakuje popup z informacja -> OK


rejestracja nowego uzytkownika / walidacja danyuch w UI
admin -> haslo i login zahardkodowane?
trenerzy i ich zajecia predefiniowani w bazie danych -> pomyslec nad wprowadzaniem z UI
[opcja] - na razie hardkodujemy
slajd 5 purseue number/code - o co biega? -> [administrator, na razie hardkodujemy]
wybor typu zajec -> to bedzie wizard ?
[focus -> typ zajec]
previous choices -> co to jest ?
ostattni slajd - co ma robic add new ?

cos dopisze

SELECT
    f.focus_name,
    t.trener_name,
    t.trener_surname,
    ft.focustime_time
FROM
    gym g,
    trener t,
    focus f,
    focustime ft,
    trenertofocus tf
WHERE
    g.gym_trener_id = t.trener_id AND 
    g.gym_focus_id = f.focus_id AND 
	ft.focustime_id = f.focus_time AND
    g.gym_user_id = 1


```