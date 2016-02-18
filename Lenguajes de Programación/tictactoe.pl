%
% Juego de la vieja (Tic-tac-toe)
%
:- dynamic x/1, o/1.

% Saber si hay 3 en linea
ordered_line(1, 2, 3). ordered_line(4, 5, 6). ordered_line(7, 8, 9).
ordered_line(1, 4, 7). ordered_line(2, 5, 8). ordered_line(3, 6, 9).
ordered_line(1, 5, 9). ordered_line(3, 5, 7).

line(A, B, C) :- ordered_line(A, B, C).
line(A, B, C) :- ordered_line(A, C, B).
line(A, B, C) :- ordered_line(B, A, C).
line(A, B, C) :- ordered_line(B, C, A).
line(A, B, C) :- ordered_line(C, A, B).
line(A, B, C) :- ordered_line(C, B, A).

% Movidas
move(A) :- good(A), empty(A), !.

full(A) :- x(A). full(A) :- o(A).

empty(A) :- not(full(A)).

% Estrategia
good(A) :- win(A).
good(A) :- block_win(A).
good(A) :- split(A).
good(A) :- strong_build(A).
good(A) :- weak_build(A).
good(5).
good(1). good(3). good(7). good(9).
good(2). good(4). good(6). good(8).

win(A) :- x(B), x(C), line(A, B, C).

block_win(A) :- o(B), o(C), line(A, B, C).

split(A) :- x(B), x(C), different(B, C),
    line(A, B, D), line(A, C, E), empty(D), empty(E).

same(A, A).
different(A, B) :- not(same(A, B)).

strong_build(A) :- x(B), line(A, B, C), empty(C), not(risky(C)).

risky(C) :- o(D), line(C, D, E), empty(E).

weak_build(A) :- x(B), line(A, B, C), empty(C), not(double_risky(C)).

double_risky(C) :- o(D), o(E), different(D, E), line(C, D, F),
    line(C, E, G), empty(F), empty(G).

%% parte nueva...
all_full :-  full(1), full(2), full(3), full(4),
    full(5), full(6), full(7), full(8), full(9).

done :- ordered_line(A, B, C), x(A), x(B), x(C), write('La pc te violó sapo!'), nl.
done :- all_full, write('Empate.').

getmove :- repeat, write('Enter a move: '), read(X), empty(X), assert(o(X)).

makemove :- move(X), !, assert(x(X)).
makemove :- all_full.

printsquare(N) :- o(N), write('_O_').
printsquare(N) :- x(N), write('_X_').
printsquare(N) :- empty(N), N < 7, write('___').
printsquare(N) :- empty(N), N > 6, write('   ').

printboard :- printsquare(1), display('|'), printsquare(2), display('|'), printsquare(3), nl,
              printsquare(4), display('|'), printsquare(5), display('|'), printsquare(6), nl,
              printsquare(7), display('|'), printsquare(8), display('|'), printsquare(9), nl.

clear :- x(A), retract(x(A)), fail.
clear :- o(A), retract(o(A)), fail.

%main goal:
play :- not(clear), tablero_vacio([a]), repeat, getmove, respond.

respond :- makemove, printboard, done.

tablero_vacio([_]) :-
  write_ln('___|___|___'),
  write_ln('___|___|___'),
  write_ln('   |   |   ').
