section .data
    L1 db 10010b;

section .text
global main
main:
    mov ebp, esp; for correct debugging
    xor ebx, ebx
    mov ebx, [L1]
    ret