;Defina cómo se puede determinar si un número es par utilizando operadores a nivel
;de bits. Luego, construya un programa assembler que dado un arreglo de 10 enteros
;de 16 bits (words), definido en el segmento .data, sume los números pares y
;muestre el resultado por pantalla.

; el resultado queda en edx

extern printf

section .data
    A1 dw 1,2,3,4,5,6,7,8,9,10

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    xor ebx, ebx
    xor edx, edx
    
    mov ecx, 10
    
    .for:
        mov ax, [A1+2*ebx]
        
        test ax, 1
        jnz .skip
        
        add dx, ax
        
        .skip:
        inc ebx
        loop .for
        
    ret
    