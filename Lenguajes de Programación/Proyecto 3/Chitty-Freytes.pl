%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   Proyecto de Programación Lógica Jugando Damas
%   CI3661 - Laboratorio de Lenguajes de Programación I 
%
%   Carlos Chitty  07-41896
%   Martin Freytes 06-39553
%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%    Manejo de Estado
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Un estado del juego se representa: estado(Tablero, Tamano, Turno)

% fichas del juego
ficha_valida(ficha(rojo, normal)).
ficha_valida(ficha(rojo, corona)).
ficha_valida(ficha(blanco, normal)).
ficha_valida(ficha(blanco, corona)).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% tablero_inicial(+Tamano, -Estado)
tablero_inicial(Tam, estado(Tab,Tam,blanco)) :-
  tamano_valido(Tam),
  Ini is Tam/2 - 1,
  Fin is Tam - Ini,
  tablero(Tam,0,Ini,Fin,Tab).

% creacion del tablero
tablero(T,T,_,_,[]).
tablero(Tam,C,Ini,Fin,[Fila|Resto]) :-
  C < Ini,
  M is C+1,
  Par is mod(C,2),
  fila(Tam,0,Par,ficha(blanco,normal),Fila),
  tablero(Tam,M,Ini,Fin,Resto).
tablero(Tam,C,Ini,Fin,[Fila|Resto]) :-
  C < Tam,
  C >= Fin,
  M is C+1,
  Par is mod(C,2),
  fila(Tam,0,Par,ficha(rojo,normal),Fila),
  tablero(Tam,M,Ini,Fin,Resto).
tablero(Tam,C,Ini,Fin,[Fila|Resto]) :-
  C >= Ini,
  C < Fin,
  M is C+1,
  fila(Tam,0,0,vacio,Fila),
  tablero(Tam,M,Ini,Fin,Resto).

% creacion de filas iniciales del tablero
fila(T,T,_,_,[]).
fila(T,C,0,Valor,[Valor,vacio|R]) :-
  C < T,
  M is C+2,
  fila(T,M,0,Valor,R).
fila(T,C,1,Valor,[vacio,Valor|R]) :-
  C < T,
  M is C+2,
  fila(T,M,1,Valor,R).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% estado_valido(+Estado)
estado_valido(estado(Tab,Tam,Tur)) :-
  turno_valido(Tur),
  tamano_valido(Tam),
  tablero_valido(Tam,0,Tab).

tamano_valido(Tam) :-
  Tam >= 4,
  0 =:= mod(Tam,2).

turno_valido(rojo).
turno_valido(blanco).

tablero_valido(T,T,[]).
tablero_valido(Tam,C,[Fila|Resto]) :-
  M is C+1,
  Par is mod(C,2),
  fila_valida(Tam,0,Par,Fila),
  tablero_valido(Tam,M,Resto).

fila_valida(T,T,_,[]).
fila_valida(T,C,_,[vacio,vacio|R]) :-
  M is C+2,
  fila_valida(T,M,1,R).
fila_valida(T,C,0,[FV,vacio|R]) :-
  M is C+2,
  ficha_valida(FV),
  fila_valida(T,M,0,R).
fila_valida(T,C,1,[vacio,FV|R]) :-
  M is C+2,
  ficha_valida(FV),
  fila_valida(T,M,1,R).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% indica el final de la partida para Color
% final(+Estado, +Color)
final(Edo,Color) :-
  fichas_color(Edo,Color,Fichas),
  length(Fichas,0).
final(estado(Tab,Tam,_),Color) :-
  movimientos_posibles(estado(Tab,Tam,Color),Movs),
  length(Movs,0).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% fichas_color(+Estado, +Color, -Fichas)
fichas_color(estado(Tab,_,_), Color, Fichas) :-
  fichas_c(Tab,Color,0,0,Fichas).

fichas_c([],_,_,_,[]).
fichas_c([Fila|Resto],Color,F,C,Fichas) :-
  Fn is F+1,
  fichas_fila(Fila,Color,F,C,FichasF),
  fichas_c(Resto,Color,Fn,C,FichasR),
  append(FichasF,FichasR,Fichas).

fichas_fila([],_,_,_,[]).
fichas_fila([ficha(Color,_)|R],Color,F,C,[pos(F,C)|Fichas]) :-
  Cn is C+1,
  fichas_fila(R,Color,F,Cn,Fichas).
fichas_fila([_|R],Color,F,C,Fichas) :-
  Cn is C+1,
  fichas_fila(R,Color,F,Cn,Fichas).

% fichas normales, fichas coronadas.
fichas_tipo([],_,_,_,[],[]).
fichas_tipo([Fila|Resto],Color,F,C,FichasN,FichasC) :-
  Fn is F+1,
  fichas_tf(Fila,Color,F,C,FichasNF,FichasCF),
  fichas_tipo(Resto,Color,Fn,C,FichasNR,FichasCR),
  append(FichasNF,FichasNR,FichasN),
  append(FichasCF,FichasCR,FichasC).

fichas_tf([],_,_,_,[],[]).
fichas_tf([ficha(Color,normal)|R],Color,F,C,[pos(F,C)|FichasN],FichasC) :-
  Cn is C+1,
  fichas_tf(R,Color,F,Cn,FichasN,FichasC).
fichas_tf([ficha(Color,corona)|R],Color,F,C,FichasN,[pos(F,C)|FichasC]) :-
  Cn is C+1,
  fichas_tf(R,Color,F,Cn,FichasN,FichasC).
fichas_tf([_|R],Color,F,C,FichasN,FichasC) :-
  Cn is C+1,
  fichas_tf(R,Color,F,Cn,FichasN,FichasC).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% movimientos_posibles(+Estado, -Movimientos)
movimientos_posibles(estado(Tab,Tam,Tur),MovsPosibles) :-
  fichas_tipo(Tab,Tur,0,0,FichasN,FichasC),
  movs_ataque(estado(Tab,Tam,Tur),normal,FichasN,MovsNAtaque),
  movs_ataque(estado(Tab,Tam,Tur),corona,FichasC,MovsCAtaque),
  append(MovsNAtaque,MovsCAtaque,MovsAtaque),
  append(MovsAtaque,MovsA),
  movs_simple(MovsA,estado(Tab,Tam,Tur),normal,FichasN,MovsNSimple),
  movs_simple(MovsA,estado(Tab,Tam,Tur),corona,FichasC,MovsCSimple),
  append(MovsNSimple,MovsCSimple,MovsSimple),
  append(MovsSimple,MovsS),
  append(MovsA,MovsS,MovsPosibles).

% movimientos de ataque (comer fichas del contrincante)
movs_ataque(_,_,[],[]).
movs_ataque(Edo,corona,[pos(X,Y)|Fs],[M|Ms]) :-
  findall(MovA,mov_corona_comer(Edo,pos(X,Y),MovA),M),
  movs_ataque(Edo,corona,Fs,Ms).
movs_ataque(estado(Tab,Tam,blanco),normal,[Pos|Fs],[M|Ms]) :-
  findall(MovA,mov_bn_comer(Tab,Tam,Pos,MovA),M),
  movs_ataque(estado(Tab,Tam,blanco),normal,Fs,Ms).
movs_ataque(estado(Tab,Tam,rojo),normal,[Pos|Fs],[M|Ms]) :-
  findall(MovA,mov_rn_comer(Tab,Tam,Pos,MovA),M),
  movs_ataque(estado(Tab,Tam,rojo),normal,Fs,Ms).

% los movimientos simples (sin comer) son validos 
% solo cuando no hay movimientos de ataque.
movs_simple([_|_],_,_,_,[]).
movs_simple([],_,_,[],[]).
movs_simple([],Edo,corona,[Pos|Fs],[M|Ms]) :-
  findall(Mov,mov_corona(Edo,Pos,Mov),Mc),
  append(Mc,M),
  movs_simple([],Edo,corona,Fs,Ms).
movs_simple([],estado(Tab,Tam,blanco),normal,[Pos|Fs],[M|Ms]) :-
  findall(Mov,mov_bn(Tab,Tam,Pos,Mov),M),
  movs_simple([],estado(Tab,Tam,blanco),normal,Fs,Ms).
movs_simple([],estado(Tab,Tam,rojo),normal,[Pos|Fs],[M|Ms]) :-
  findall(Mov,mov_rn(Tab,Tam,Pos,Mov),M),
  movs_simple([],estado(Tab,Tam,rojo),normal,Fs,Ms).

% movimiento simple (fichas blancas)
mov_bn(Tab,Tam,pos(X,Y),[pos(X,Y),pos(Xm,Ym)]) :-
  Xm is X+1,
  Xm < Tam,
  Ym is Y-1,
  Ym >= 0,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,vacio).
mov_bn(Tab,Tam,pos(X,Y),[pos(X,Y),pos(Xm,Ym)]) :-
  Xm is X+1,
  Xm < Tam,
  Ym is Y+1,
  Ym < Tam,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,vacio).

% movimiento ataque (fichas blancas)
mov_bn_comer(Tab,Tam,pos(X,Y),[pos(X,Y)|Cadena]) :-
  Xm is X+1,
  Xm < Tam,
  Ym is Y-1,
  Ym >= 0,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,ficha(rojo,_)),
  Xc is Xm+1,
  Xc < Tam,
  Yc is Ym-1,
  Yc >=0,
  nth0(Xc,Tab,Fc),
  nth0(Yc,Fc,vacio),
  mov_bn_cadena(Tab,Tam,pos(Xc,Yc),Cadena).
mov_bn_comer(Tab,Tam,pos(X,Y),[pos(X,Y)|Cadena]) :-
  Xm is X+1,
  Xm < Tam,
  Ym is Y+1,
  Ym < Tam,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,ficha(rojo,_)),
  Xc is Xm+1,
  Xc < Tam,
  Yc is Ym+1,
  Yc < Tam,
  nth0(Xc,Tab,Fc),
  nth0(Yc,Fc,vacio),
  mov_bn_cadena(Tab,Tam,pos(Xc,Yc),Cadena).

% encadenamiento de ataques (fichas blancas)
mov_bn_cadena(Tab,Tam,pos(X,Y),P) :-
  mov_bn_comer(Tab,Tam,pos(X,Y),P).
mov_bn_cadena(Tab,Tam,pos(X,Y),[pos(X,Y)]) :-
  \+mov_bn_comer(Tab,Tam,pos(X,Y),_).

% movimiento simple (fichas rojas)
mov_rn(Tab,_,pos(X,Y),[pos(X,Y),pos(Xm,Ym)]) :-
  Xm is X-1,
  Xm >= 0,
  Ym is Y-1,
  Ym >= 0,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,vacio).
mov_rn(Tab,Tam,pos(X,Y),[pos(X,Y),pos(Xm,Ym)]) :-
  Xm is X-1,
  Xm >= 0,
  Ym is Y+1,
  Ym < Tam,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,vacio).

% movimiento ataque (fichas rojas)
mov_rn_comer(Tab,Tam,pos(X,Y),[pos(X,Y)|Cadena]) :-
  Xm is X-1,
  Xm >= 0,
  Ym is Y-1,
  Ym >= 0,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,ficha(blanco,_)),
  Xc is Xm-1,
  Xc >= 0,
  Yc is Ym-1,
  Yc >=0,
  nth0(Xc,Tab,Fc),
  nth0(Yc,Fc,vacio),
  mov_rn_cadena(Tab,Tam,pos(Xc,Yc),Cadena).
mov_rn_comer(Tab,Tam,pos(X,Y),[pos(X,Y)|Cadena]) :-
  Xm is X-1,
  Xm >= 0,
  Ym is Y+1,
  Ym < Tam,
  nth0(Xm,Tab,Fx),
  nth0(Ym,Fx,ficha(blanco,_)),
  Xc is Xm-1,
  Xc >= 0,
  Yc is Ym+1,
  Yc < Tam,
  nth0(Xc,Tab,Fc),
  nth0(Yc,Fc,vacio),
  mov_rn_cadena(Tab,Tam,pos(Xc,Yc),Cadena).

% encadenamiento de ataques (fichas rojas)
mov_rn_cadena(Tab,Tam,pos(X,Y),P) :-
  mov_rn_comer(Tab,Tam,pos(X,Y),P).
mov_rn_cadena(Tab,Tam,pos(X,Y),[pos(X,Y)]) :-
  \+mov_rn_comer(Tab,Tam,pos(X,Y),_).

% movimiento simple (corona)
mov_corona(Edo,Pos,Movs) :-
  mov_sc(Edo,Pos,1,1,Destinos),
  combinar(Pos,Destinos,Movs).
mov_corona(Edo,Pos,Movs) :-
  mov_sc(Edo,Pos,1,-1,Destinos),
  combinar(Pos,Destinos,Movs).
mov_corona(Edo,Pos,Movs) :-
  mov_sc(Edo,Pos,-1,1,Destinos),
  combinar(Pos,Destinos,Movs).
mov_corona(Edo,Pos,Movs) :-
  mov_sc(Edo,Pos,-1,-1,Destinos),
  combinar(Pos,Destinos,Movs).

mov_sc(estado(_,Tam,_),Pos,Xd,Yd,[]) :-
  \+sig_pos_valida(Tam,Pos,Xd,Yd,_,_).
mov_sc(estado(Tab,Tam,_),Pos,Xd,Yd,[]) :-
  sig_pos_valida(Tam,Pos,Xd,Yd,Xm,Ym),
  nth0(Xm,Tab,Fo),
  nth0(Ym,Fo,FV),
  ficha_valida(FV).
mov_sc(estado(Tab,Tam,Tur),Pos,Xd,Yd,[pos(Xm,Ym)|Destinos]) :-
  sig_pos_valida(Tam,Pos,Xd,Yd,Xm,Ym),
  nth0(Xm,Tab,Fo),
  nth0(Ym,Fo,vacio),
  mov_sc(estado(Tab,Tam,Tur),pos(Xm,Ym),Xd,Yd,Destinos).

sig_pos_valida(Tam,pos(X,Y),Xd,Yd,Xm,Ym) :-
  Xm is X+Xd,
  Xm >= 0,
  Xm < Tam,
  Ym is Y+Yd,
  Ym >= 0,
  Ym < Tam.
 
combinar(_,[],[]).
combinar(Pos,[D|Ds],[[Pos,D]|C]) :-
  combinar(Pos,Ds,C).

% movimiento ataque (corona)
mov_corona_comer(estado(Tab,Tam,Tur),Pos,[Pos|Cadena]) :-
  encuentra_oponente(estado(Tab,Tam,Tur),Pos,Pos,1,1,NTab,Psig),
  mov_corona_cadena(estado(NTab,Tam,Tur),Psig,Cadena).
mov_corona_comer(estado(Tab,Tam,Tur),Pos,[Pos|Cadena]) :-
  encuentra_oponente(estado(Tab,Tam,Tur),Pos,Pos,1,-1,NTab,Psig),
  mov_corona_cadena(estado(NTab,Tam,Tur),Psig,Cadena).
mov_corona_comer(estado(Tab,Tam,Tur),Pos,[Pos|Cadena]) :-
  encuentra_oponente(estado(Tab,Tam,Tur),Pos,Pos,-1,1,NTab,Psig),
  mov_corona_cadena(estado(NTab,Tam,Tur),Psig,Cadena).
mov_corona_comer(estado(Tab,Tam,Tur),Pos,[Pos|Cadena]) :-
  encuentra_oponente(estado(Tab,Tam,Tur),Pos,Pos,-1,-1,NTab,Psig),
  mov_corona_cadena(estado(NTab,Tam,Tur),Psig,Cadena).

encuentra_oponente(estado(Tab,Tam,Tur),Pini,pos(X,Y),Xd,Yd,NTab,Psig) :-
  Xm is X+Xd,
  Xm >= 0,
  Xm < Tam,
  Ym is Y+Yd,
  Ym >= 0,
  Ym < Tam,
  nth0(Xm,Tab,Fo),
  nth0(Ym,Fo,vacio),
  encuentra_oponente(estado(Tab,Tam,Tur),Pini,pos(Xm,Ym),Xd,Yd,NTab,Psig).
encuentra_oponente(estado(Tab,Tam,Tur),pos(Xi,Yi),pos(X,Y),Xd,Yd,NTab,pos(Xc,Yc)) :-
  Xm is X+Xd,
  Xm >= 0,
  Xm < Tam,
  Ym is Y+Yd,
  Ym >= 0,
  Ym < Tam,
  cambio_turno(Tur,Oponente),
  nth0(Xm,Tab,Fo),
  nth0(Ym,Fo,ficha(Oponente,_)),
  Xc is Xm+Xd,
  Xc >= 0,
  Xc < Tam,
  Yc is Ym+Yd,
  Yc >= 0,
  Yc < Tam,
  nth0(Xc,Tab,Fc),
  nth0(Yc,Fc,vacio),
  modificar_casilla(Tab,Xi,Yi,vacio,Tab0),
  modificar_casilla(Tab0,Xm,Ym,vacio,Tab1),
  modificar_casilla(Tab1,Xc,Yc,ficha(Tur,corona),NTab).
  
% encadenamiento de ataques (corona)
mov_corona_cadena(Edo,Pos,P) :-
  mov_corona_comer(Edo,Pos,P).
mov_corona_cadena(Edo,Pos,[Pos]) :-
  \+mov_corona_comer(Edo,Pos,_).
  
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% realizar una jugada (entre los movimientos posibles)
% jugada(+Estado, +Posicion, +Movimiento, -Resultado)
jugada(estado(Tab,Tam,Tur),Pos,Mov,estado(NTab,Tam,NTur)) :-
  posicion_valida(estado(Tab,Tam,Tur),Pos,Ficha),
  movimiento_valido(estado(Tab,Tam,Tur),Pos,Mov),
  realizar_jugada(Tab,Tam,Ficha,Mov,NTab),
  cambio_turno(Tur,NTur).

posicion_valida(estado(Tab,Tam,Tur),pos(X,Y),ficha(Tur,R)) :-
  X >= 0,
  X < Tam,
  Y >= 0,
  Y < Tam,
  nth0(X,Tab,Fila),
  nth0(Y,Fila,ficha(Tur,R)).

movimiento_valido(Edo,Pos,[Pos|Mov]) :-
  movimientos_posibles(Edo,Movs),
  member([Pos|Mov],Movs).
  
realizar_jugada(Tab,Tam,ficha(blanco,normal),[pos(X,Y)],NTab) :-
  Xc is Tam-1,
  X =:= Xc,
  modificar_casilla(Tab,X,Y,ficha(blanco,corona),NTab).
realizar_jugada(Tab,_,ficha(rojo,normal),[pos(X,Y)],NTab) :-
  X =:= 0,
  modificar_casilla(Tab,X,Y,ficha(rojo,corona),NTab).
realizar_jugada(Tab,_,_,[_|[]],Tab).
realizar_jugada(Tab,Tam,Ficha,[pos(X0,Y0),pos(X1,Y1)],NTab) :-
  X is X1-X0,
  abs(X,1),
  modificar_casilla(Tab,X0,Y0,vacio,Tab0),
  modificar_casilla(Tab0,X1,Y1,Ficha,Tab1),
  realizar_jugada(Tab1,Tam,Ficha,[pos(X1,Y1)],NTab).
realizar_jugada(Tab,Tam,Ficha,[pos(X0,Y0),pos(X1,Y1)|Ps],NTab) :-
  X1 > X0,
  Y1 > Y0,
  X is X1-X0,
  X > 1,
  Xc is X1-1,
  Yc is Y1-1,
  modificar_casilla(Tab,X0,Y0,vacio,Tab0),
  modificar_casilla(Tab0,Xc,Yc,vacio,Tab1),
  modificar_casilla(Tab1,X1,Y1,Ficha,TTab),
  realizar_jugada(TTab,Tam,Ficha,[pos(X1,Y1)|Ps],NTab).
realizar_jugada(Tab,Tam,Ficha,[pos(X0,Y0),pos(X1,Y1)|Ps],NTab) :-
  X1 > X0,
  Y1 < Y0,
  X is X1-X0,
  X > 1,
  Xc is X1-1,
  Yc is Y1+1,
  modificar_casilla(Tab,X0,Y0,vacio,Tab0),
  modificar_casilla(Tab0,Xc,Yc,vacio,Tab1),
  modificar_casilla(Tab1,X1,Y1,Ficha,TTab),
  realizar_jugada(TTab,Tam,Ficha,[pos(X1,Y1)|Ps],NTab).
realizar_jugada(Tab,Tam,Ficha,[pos(X0,Y0),pos(X1,Y1)|Ps],NTab) :-
  X1 < X0,
  Y1 > Y0,
  X is X0-X1,
  X > 1,
  Xc is X1+1,
  Yc is Y1-1,
  modificar_casilla(Tab,X0,Y0,vacio,Tab0),
  modificar_casilla(Tab0,Xc,Yc,vacio,Tab1),
  modificar_casilla(Tab1,X1,Y1,Ficha,TTab),
  realizar_jugada(TTab,Tam,Ficha,[pos(X1,Y1)|Ps],NTab).
realizar_jugada(Tab,Tam,Ficha,[pos(X0,Y0),pos(X1,Y1)|Ps],NTab) :-
  X1 < X0,
  Y1 < Y0,
  X is X0-X1,
  X > 1,
  Xc is X1+1,
  Yc is Y1+1,
  modificar_casilla(Tab,X0,Y0,vacio,Tab0),
  modificar_casilla(Tab0,Xc,Yc,vacio,Tab1),
  modificar_casilla(Tab1,X1,Y1,Ficha,TTab),
  realizar_jugada(TTab,Tam,Ficha,[pos(X1,Y1)|Ps],NTab).

modificar_casilla([F|Fs],0,Y,Valor,[Fn|Fs]) :-
  modificar_fila(F,Y,Valor,Fn).
modificar_casilla([F|Fs],X,Y,Valor,[F|Fn]) :-
  X > 0,
  Xn is X-1,
  modificar_casilla(Fs,Xn,Y,Valor,Fn).

modificar_fila([_|Cs],0,Valor,[Valor|Cs]).
modificar_fila([C|Cs],Y,Valor,[C|Cn]) :-
  Y > 0,
  Yn is Y-1,
  modificar_fila(Cs,Yn,Valor,Cn).

cambio_turno(blanco,rojo).
cambio_turno(rojo,blanco).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%    Interaccion con el Usuario
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% mostrar_estado(+Estado)
mostrar_estado(estado(Tab,Tam,_)) :-
  reverse(Tab,RTab),
  write('  -'),
  imprime_linea(0,Tam),
  nl,
  Cd is Tam-1,
  imprime_tablero(RTab,1,Cd,Tam),
  nl,
  write('   '),
  imprime_numeros(0,Tam),
  nl.

imprime_linea(Tam,Tam).
imprime_linea(C,Tam) :-
  C < Tam,
  write('------------'),
  Cn is C+2,
  imprime_linea(Cn,Tam).

imprime_numeros(Tam,Tam).
imprime_numeros(C,Tam) :-
  C < Tam,
  write('  '),
  write(C),
  espacio(C),
  write('  '),
  Cn is C+1,
  imprime_numeros(Cn,Tam).
  
imprime_tablero([],_,_,_).
imprime_tablero([Fila|R],Par,Cd,Tam) :-
  write('  |'),
  imprime_f(Par,0,Tam),
  nl,
  write(Cd),
  espacio(Cd),
  write('|'),
  imprime_fila(Fila,Par,Tam),
  nl,
  write('  |'),
  imprime_f(Par,0,Tam),
  nl,
  write('  -'),
  imprime_linea(0,Tam),
  Cn is Cd-1,
  Parn is mod(Cn,2),
  nl,
  imprime_tablero(R,Parn,Cn,Tam).

espacio(N) :-
  N < 10,
  write(' ').
espacio(N) :-
  N >= 10.

imprime_f(_,Tam,Tam).
imprime_f(1,C,Tam) :-
  C < Tam,
  write('     |/////|'),
  Cn is C+2,
  imprime_f(1,Cn,Tam).
imprime_f(0,C,Tam) :-
  C < Tam,
  write('/////|     |'),
  Cn is C+2,
  imprime_f(0,Cn,Tam).

imprime_fila([],_,_).
imprime_fila([Cas0,Cas1|Resto],0,Tam) :-
  write('/'),
  imprime_casilla(Cas0,'///'),
  write('/| '),
  imprime_casilla(Cas1,'   '),
  write(' |'),
  imprime_fila(Resto,0,Tam).
imprime_fila([Cas0,Cas1|Resto],1,Tam) :-
  write(' '),
  imprime_casilla(Cas0,'   '),
  write(' |/'),
  imprime_casilla(Cas1,'///'),
  write('/|'),
  imprime_fila(Resto,1,Tam).

imprime_casilla(vacio,C) :-
  write(C).
imprime_casilla(ficha(blanco,normal),_) :-
  write('(B)').
imprime_casilla(ficha(rojo,normal),_) :-
  write('(R)').
imprime_casilla(ficha(blanco,corona),_) :-
  write('<B>').
imprime_casilla(ficha(rojo,corona),_) :-
  write('<R>').
  

% jugar_2
jugar_2 :-
  nl,
  write('Nueva Partida de Damas - 2 Jugadores'),
  nl,nl,
  write('Introduzca Tamaño de Tablero (Entero Par >= 4): '),
  read(Tam),
  nl,
  tablero_inicial(Tam,Edo),
  jugar_2(Edo).

jugar_2(estado(Tab,Tam,Tur)) :-
  movimientos_posibles(estado(Tab,Tam,Tur),Movs),
  \+length(Movs,0),
  nl,
  write('Tablero:'),
  nl,
  mostrar_estado(estado(Tab,Tam,Tur)),
  nl,nl,
  write('Turno: jugador '),
  write(Tur),
  nl,nl,
  write('Lista de Movimientos Posibles para jugador:'),
  nl,
  write('Simplemente indique el número del movimiento deseado seguido de un punto "." (ejemplo: 0.)'), nl,
  mostrar_movs(Movs, 0),
  nl,nl,
  write('Introduzca Movimiento: '),
  read(Numero),
  movimiento_deseado(Numero, Movs, Mov),
  verificar_movimiento(Mov,Movs,[Pos|M]),
  jugada(estado(Tab,Tam,Tur),Pos,[Pos|M],Resultado),
  jugar_2(Resultado).
jugar_2(estado(Tab,Tam,Tur)) :-
  final(estado(Tab,Tam,Tur),Tur),
  nl,
  write('Tablero:'),
  nl,
  mostrar_estado(estado(Tab,Tam,Tur)),
  nl,nl,
  write('Final de la Partida para jugador '),
  write(Tur),
  nl,nl,nl,
  cambio_turno(Tur,Ganador),
  write('Felicidades jugador '),
  write(Ganador),
  write(' Ha Ganado la Partida!!!'),
  nl,nl,
  abort.
  
verificar_movimiento(Mov,Movs,Mov) :-
  member(Mov,Movs).
verificar_movimiento(Mov,Movs,Mv) :-
  \+member(Mov,Movs),
  write('Movimiento Invalido'),
  nl,
  write('Introduzca Movimiento: '),
  read(Nuevo),
  verificar_movimiento(Nuevo,Movs,Mv).

mostrar_movs([], _).
mostrar_movs([M|Movimientos], N) :-
  nl, write(N), write('. '), write(M),
  N2 is N+1,
  mostrar_movs(Movimientos, N2).

movimiento_deseado(0, [Movimiento|_], Movimiento).
movimiento_deseado(N, [_|Movimientos], Movimiento) :-
  N > 0,
  N2 is N-1,
  movimiento_deseado(N2, Movimientos, Movimiento).

% ----------------------
% Jugando con la máquina
% ----------------------

% sucesor(+Estado, -Sucesor)
sucesor(Estado, Sucesor) :-
  movimientos_posibles(Estado, Movimientos),
  sucesores(Estado, Sucesor, Movimientos).

sucesores(_, [], []).
sucesores(Edo, [S|Sucesor], [M|Movimientos]) :-  
  head(M, Posicion),
  jugada(Edo, Posicion, M, S),
  sucesores(Edo, Sucesor, Movimientos).

head([H|_], H).

% heuristica(+Estado, -Valor)
heuristica(estado(Tab, Tam, _), Valor) :-
  calcular(Tab, Tam, 1, Valor).

calcular([], _, _, 0).
calcular([T|Tab], N, Fila, Valor) :-
  valorFila(T, ValorF, N, Fila, 1),
  Fila2 is Fila+1,
  calcular(Tab, N, Fila2, ValorResto),
  Valor is ValorF + ValorResto. 

% valorFila(+FilaDelTablero, -ValorFila, +Tamaño, +FilaNumero, +Columna) 
valorFila([], 0, _, _, _). 
valorFila([vacio|T], ValorF, N, Fila, C) :-
  C2 is C+1,
  valorFila(T, ValorF, N, Fila, C2).
valorFila([ficha(blanco, normal)|T], ValorF, N, Fila, C) :-
  ValorFicha is 100 + (Fila*Fila),
  C2 is C+1,
  valorFila(T, ValorFs, N, Fila, C2),
  ValorF is ValorFicha + ValorFs.
valorFila([ficha(rojo, normal)|T], ValorF, N, Fila, C) :-
  ValorFicha is 0 - (100 + ((N-Fila+1)*(N-Fila+1))),
  C2 is C+1,
  valorFila(T, ValorFs, N, Fila, C2),
  ValorF is ValorFicha + ValorFs.
valorFila([ficha(blanco, corona), A|T], ValorF, N, Fila, Columna) :-
  Fila > 1,
  Fila < N,
  Columna > 1,
  valorFila([A|T], ValorFs, N, Fila),
  ValorF is 175 + ValorFs.
valorFila([ficha(blanco, corona)|T], ValorF, N, Fila, C) :-
  C2 is C+1,
  valorFila(T, ValorFs, N, Fila, C2),
  ValorF is 150 + ValorFs.
valorFila([ficha(rojo, corona), A|T], ValorF, N, Fila, Columna) :-
  Fila > 1,
  Fila < N,
  Columna > 1,
  valorFila([A|T], ValorFs, N, Fila),
  ValorF is ValorFs-175.
valorFila([ficha(rojo, corona)|T], ValorF, N, Fila, C) :-
  C2 is C+1,
  valorFila(T, ValorFs, N, Fila, C2),
  ValorF is ValorFs-150.


% alpha_beta(+Estado, +Profundidad, +Alfa, +Beta, -Valor, -Movimiento)
alpha_beta(estado(Tab, Tam, Turno), Depth, Alfa, Beta, Valor, Movimiento) :-
  ab(estado(Tab, Tam, Turno), Turno, Depth, Alfa, Beta, Valor, Movimiento).

ab(_, _, 0, _, _, 0, []).
ab(estado(Tab, Tam, Turno), Turno, D, Alfa, Beta, Valor, Movimiento) :-
  Alfa < Beta, !,
  sucesor(estado(Tab, Tam, Turno), [S|_]),
  heuristica(S, Valor),
  D2 is D-1,
  cambia_turno(Turno, T2),
  ab(Sucesor, T2, D2, Alfa, Beta, Valor2, _),
  max(Alfa, Valor2, Alfa),
  el_movimiento(estado(Tab, Tam, Turno), Sucesor, Movimiento).
ab(estado(Tab, Tam, Turno), Turno, D, Valor2, Beta, Valor, Movimiento) :-
  Alfa < Beta, !,
  sucesor(estado(Tab, Tam, Turno), [S|_]),
  heuristica(S, Valor),
  D2 is D-1,
  cambia_turno(Turno, T2),
  ab(S, T2, D2, Alfa, Beta, Valor2, Movimiento),
  max(Alfa, Valor2, Valor2).
ab(estado(Tab, Tam, Turno), T2, D, Alfa, Beta, Valor, Movimiento) :-
  Alfa < Beta, !,
  sucesor(estado(Tab, Tam, Turno), [S|_]),
  heuristica(S, Valor),
  D2 is D-1,
  cambia_turno(Turno, T2),
  ab(S, T2, D2, Alfa, Beta, Valor2, _),
  min(Beta, Valor2, Beta),
  el_movimiento(estado(Tab, Tam, Turno), S, Movimiento).
ab(estado(Tab, Tam, Turno), Turno, D, Alfa, Valor2, Valor, Movimiento) :-
  Alfa < Beta, !,
  sucesor(estado(Tab, Tam, Turno), [S|_]),
  heuristica(S, Valor),
  D2 is D-1,
  cambia_turno(Turno, T2),
  ab(S, T2, D2, Alfa, Beta, Valor2, Movimiento),
  min(Alfa, Valor2, Valor2).

el_movimiento(Edo, Edo2, [M|_]) :-
  head(M, Posicion),
  jugada(Edo, Posicion, M, Edo2), !.
el_movimiento(Edo, Edo2, [_|Ms]) :-
  el_movimiento(Edo, Edo2, Ms).

max(A, B, B) :-
  A < B, !.
max(A, _, A).

min(A, B, B) :-
  A > B, !.
min(A, _, A).

cambia_turno(blanco, rojo).
cambia_turno(rojo, blanco).

% obtener_jugada(+Estado, +Profundidad, -Movimiento)
obtener_jugada(Edo, Profundidad, Movimiento) :-
  alpha_beta(Edo, Profundidad, -999999, 999999, 0, Movimiento). 

% jugar_cpu(+Color)
