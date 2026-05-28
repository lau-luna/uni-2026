section .data
    A db 10
    B db 3

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    
    mov EBX, A
    mov AL, [EBX]  ; AL = 10
    add AL, [B]
    inc EAX
    mov EBX, B
    sub AL, [EBX]
    
    ret