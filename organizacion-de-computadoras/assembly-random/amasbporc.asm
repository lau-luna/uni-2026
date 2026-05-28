; Implementar la funcion de C
; int operar(int a, int b, int c)
;que calcule:
;(a + b) * c

section .data
    L1 dd 4
    L2 dd 6
    L3 dd 2

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    xor ebx, ebx
    
    push dword [L3]
    push dword [L2]
    push dword [L1]
    
    call operar
    
    ret
    
operar:
    push ebp
    mov ebp, esp
    
    mov ebx, [ebp+8]
    add ebx, [ebp+12]
    imul ebx, [ebp+16]
    
    mov esp, ebp
    pop ebp
    ret 12
    