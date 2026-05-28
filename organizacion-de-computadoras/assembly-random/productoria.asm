; Programa que hace la productoria de un arreglo de 5 elementos

section .data
    A1 dw 1, 2, 3, 4, 5

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    mov edx, 1; acumulador de la productoria con neutro de la multiplicacion
    ; mov eax, A1; direccion del arreglo no es necesario
    mov ecx, 5; tamaño del arreglo
    xor ebx, ebx; indice del for

for1:
    imul dx, [A1+2*ebx]
    
    inc ebx
    loop for1