; Hacer un programa que:
;reciba dos parámetros
;los multiplique
;deje el resultado en ebx

section .data
    L1 dd 5
    L2 dd 2

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    
    push dword [L2]
    push dword [L1]
    
    call multiplicar
    
    ret
    
multiplicar:
    push ebp
    mov ebp, esp
    ;---- prolog
    
    mov ebx, [ebp+8]
    imul ebx, [ebp+12]
    
    ;---- epilog
    mov esp, ebp
    pop ebp
    ret 8z