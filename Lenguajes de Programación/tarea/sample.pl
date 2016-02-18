%   Predicados de practica

fact(0, 1).
fact(N, Res) :-
  Temp is N - 1,
  fact(Temp, X),
  Res is X * N.

% Tamaño de una lista
tam([], 0).
tam([X|Xs], L) :-
  tam(Xs, Ls),
  L is Ls + 1.

permutacion([], []).
permutacion([X|Xs], L) :-
  permutacion(Xs, Ls), % La permutacion de los restantes Xs guardarla en Ls
  takeout(X, L, Ls).   % pone X en cada una de las posiciones posibles de Ls

combinacion(Lista, M, Res) :-
  tam(Res,M),
  sublist(Res,Lista).

% X es sublista de Y
sublist(X, Y) :-
  conc(L1, L2, Y),
  conc(X, L3, L2).
  

% concatenación de listas
conc([], L, L).
conc([X|L1], L2, [X|L3]) :- conc(L1, L2, L3).

% insertar al principio de la lista
add(X, L, [X|L]).

takeout(X, [X|R], R).
takeout(X, [Y|Ys], [Y|Zs]) :- takeout(X, Ys, Zs).

Arbol = hoja | nodo(Arbol, _, Arbol).

% si un arbol es válido o no
arbolv(hoja).
arbolv(nodo(Izq, _, Der)) :-
  arbolv(Izq),
  arbolv(Der).
