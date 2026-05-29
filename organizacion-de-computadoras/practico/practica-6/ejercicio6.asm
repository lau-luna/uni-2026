; 6. Construya un programa assembler que calcule de manera iterativa el factorial de un
; número dado.
; de manera iterativa significa con bucle, no con recursion

section .data
    L1 dw 5

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor ecx, ecx
    
    mov eax, 1
    mov ebx, 1
    mov cx, [L1]
    
    .for:
        imul eax, ebx
        
        inc ebx
        loop .for
    
    ret