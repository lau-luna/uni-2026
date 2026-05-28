section .data
    X db 10
    Y db 4

section .text
global main
main:
    ;write your code here
    xor eax, eax
    
    mov EBX, X
    mov AL, [EBX]
    sub AL, [Y]
    
    ret