%   Tarea de Programación Lógica
%   CI3661 - Laboratorio de Lenguajes de Programación I 

%   Carlos Chitty  07-41896
%   Martin Freytes 06-39553

%-------------%
% Ejercicio 2 %
%-------------%

permutacion([X|Xs], L) :-
  permutacion(Xs, Ls),
  delete(X, L, Ls).
permutacion([], []).

delete(X, [X|R], R).
delete(X, [Y|Ys], [Y|Zs]) :- delete(X, Ys, Zs).

combinacion(_, 0, []).
combinacion([X|Lista], M, [X|Res]) :-
  M>0,
  M1 is M-1,
  combinacion(Lista, M1, Res).
combinacion([_|Lista], M, Res) :-
  M>0,
  combinacion(Lista, M, Res).

variacion(_, 0, []).
variacion(Lista, M, [X|Res]) :-
  M>0,
  M1 is M-1,
  delete(X, Lista, Resto),
  variacion(Resto, M1, Res).

%-------------%
% Ejercicio 3 %
%-------------%

%

%-------------%
% Ejercicio 4 %
%-------------%

ordenadoRecorrido(hoja).
ordenadoRecorrido(nodo(Izq, Valor, Der)) :-
  inorder(nodo(Izq, Valor, Der), Lista),
  ordenada(Lista).

ordenadoPre(hoja).
ordenadoPre(nodo(Izq, Valor, Der)) :-
  preorder(nodo(Izq, Valor, Der), Lista),
  ordenada(Lista).

ordenadoPost(hoja).
ordenadoPost(nodo(Izq, Valor, Der)) :-
  postorder(nodo(Izq, Valor, Der), Lista),
  ordenada(Lista).

inorder(hoja, []).
inorder(nodo(Izq, Valor, Der), Lista) :-
  inorder(Izq, Lizq),
  inorder(Der, Lder),
  append(Lizq, [Valor|Lder], Lista).

preorder(hoja, []).
preorder(nodo(Izq, Valor, Der), Lista) :-
  preorder(Izq, Lizq),
  preorder(Der, Lder),
  append([Valor|Lizq], Lder, Lista).

postorder(hoja, []).
postorder(nodo(Izq, Valor, Der), Lista) :-
  postorder(Izq, Lizq),
  postorder(Der, Lder),
  append(Lder, [Valor], Aux),
  append(Lizq, Aux, Lista).

ordenada([]).
ordenada([_]) :- !.
ordenada([X1,X2|Xs]) :-
  X1 =< X2,
  ordenada([X2|Xs]).

sumaArbol(hoja, 0).
sumaArbol(nodo(Izq, Valor, Der), Suma) :-
  sumaArbol(Izq, SumIzq),
  sumaArbol(Der, SumDer),
  number(Valor),
  Suma is SumIzq + SumDer + Valor.

%-------------%
% Ejercicio 5 %
%-------------%

%...

%-------------%
% Ejercicio 6 %
%-------------%

hay_repetido([X|Xs]) :-
  member(X, Xs).
hay_repetido([_|Xs]) :-
  hay_repetido(Xs).

hay_repetido2([X|Xs]) :-
  member(X, Xs), !.
hay_repetido2([_|Xs]) :-
  hay_repetido2(Xs).

es_conjunto([]).
es_conjunto([X|Xs]) :-
  not(member(X, Xs)),
  es_conjunto(Xs).

%-------------%
% Ejercicio 7 %
%-------------%

sub_conj([],[]).
sub_conj([X|L1],[X|L2]) :-
  sub_conj(L1,L2).
sub_conj(L1,[_|L2]) :-
  sub_conj(L1,L2). 

subset_sum([],_):- !.
subset_sum(Conjunto,Res ):-
  sub_conj(Res,Conjunto),
  suma_ele(Res,Sumar),
  Sumar is 0.
  
suma_ele([],0).
suma_ele([X|L],Res):-
  suma_ele(L,Res1),
  Res is X + Res1.
