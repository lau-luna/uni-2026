; hacer una funcion int maximo(int a, int b, int c)
;que devuelva el mayor de los tres números en ebx.

section .data
    L1 dd 4
    L2 dd 25
    L3 dd -2

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor ebx, ebx
    
    push dword [L3]
    push dword [L2]
    push dword [L1]
    
    call maximo
    
    ret
    
maximo:
    push ebp
    mov ebp, esp
    
    mov ebx, [ebp+8]
    
    cmp ebx, [ebp+12]
    cmovl ebx, [ebp+12]
    
    cmp ebx, [ebp+16]
    cmovl ebx, [ebp+16]
    
    mov esp, ebp
    pop ebp
    ret 12