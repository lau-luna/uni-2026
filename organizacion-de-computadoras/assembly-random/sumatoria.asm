segment .data
    A2 dw 35,1,17,123,98
    
segment .text
global main
main:
    mov ebp, esp; for correct debugging
    xor EDX, EDX; inicializo el acumulador con 0
    mov ECX, 5; muevo al ECX el tamaño del arreglo
    mov EAX, A2; muevo al EAX la dirección del comienzo del arreglo
    mov EBX, 0; inicializo el registro índice con 0

for1:
    add DX, [EAX + 2 * EBX]; sumo el acumulador con el elemento
    inc EBX ; incremento el índice
    loop for1;