section .data
    M db 6
    N db 7

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    
    mov AL, [M]
    mul byte [N]
    
    ret