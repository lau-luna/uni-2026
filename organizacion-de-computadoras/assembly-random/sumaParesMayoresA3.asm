; Progama suma los numeros pares mayores a 3
; Deja el resultado en dx

section .data
    A1 dw 4, 7, 10, 3, 8, 1

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    xor ebx, ebx
    xor edx, edx
    
    mov ecx, 6
    
    call for
    
    ret
    
for:
    mov ax, [A1+2*ebx]
    test ax, 1
    jnz skip
    
    cmp ax, 5
    jle skip
    
    add dx, ax

skip:
    inc ebx
    loop for
    