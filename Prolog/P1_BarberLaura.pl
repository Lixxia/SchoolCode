%Laura Barber
%Prolog Program Assignment 1
%CSCI 320 McCauley
%11/22/13

%1. Define a prolog predicate/relationship that adds an element to the front of a given list.
add(H, T, [H|T]).

% 2. Define two predicate evenlength and oddlength.
len([], 0).
len([_ |T], N) :- len(T, N1), N is N1 + 1.

evenlength(L) :- len(L,X), 0 is X mod 2.
oddlength(L) :- len(L,X), 0 =\= X mod 2.

% 3. Member n things
concat([], L, L).
concat([H|T], L, [H|M]) :- concat(T,L,M).

member(X,[X|T]).
member(X,[H|T]) :- member(X,T).

member1(X, L) :- concat(L1, [X | L2], L).

% 4. Write a version of last that uses concat
last([X],X).
last([H|T], X) :- last(T,X).

last1(L,X) :- concat(_, [X], L).

% 5. Define the sublist relation
sublist(S,L) :- concat(L1,L2,L), concat(S,L3,L2).

