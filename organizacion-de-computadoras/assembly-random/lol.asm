section .data
    A db 5
    B db 3

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    
    mov AL, [A]
    add AL, [B]
    
    ret