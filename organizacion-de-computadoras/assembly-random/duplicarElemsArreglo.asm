; Programa que duplica todos los elementos del arreglo

section .data
    A1 dw 3, 8, 1, 10, 5

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    xor ebx, ebx
    mov ecx, 5
    
    .for:
        shl word [A1+2*ebx], 1
        mov ax, [A1+2*ebx]; esto era para mostrar nomas
    
        inc ebx
        loop .for
    
    ret
    
