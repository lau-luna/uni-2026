section .data
    A1 dw 5, 8, 3, 12, 7, 2

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    xor edx, edx
    xor ebx, ebx
    
    mov ecx, 6
    
for1:
    mov ax, [A1+2*ebx]
    
    test ax, 1
    jnz seguir
    
    inc dx

seguir:
    inc ebx
    loop for1