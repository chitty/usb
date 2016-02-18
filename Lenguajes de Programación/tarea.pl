% aproximacion pregunta 1)
% These are intended to be used for goals where the first two variables already have a list value. Sometimes this intention is indicated by writing something like 'union(+,+,-)' to indicate the intended variable profile. For example,

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

takeout(X, [X|R], R).
takeout(X, [Y|Ys], [Y|Zs]) :- takeout(X, Ys, Zs).
