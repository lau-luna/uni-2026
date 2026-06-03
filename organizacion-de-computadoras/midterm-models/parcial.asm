section .data
     L1 dd 5
     L2 dd 4

section .text
global main
main:
    mov ebp, esp; for correct debugging
    
    push L2
    push L1

    call swap

    ; aca indique que usaba ret 8 y por eso no hacia add sp, 8

   mov eax, [L1];       eax = 4
   mov ebx, [L2];       ebx = 5

   ret

swap:
    push ebp
    mov ebp, esp

    mov eax, [ebp+8]; 1ra direccion
    mov ebx, [eax];  1er valor
    mov ecx, [ebp+12]; 2da direccion
    mov edx, [ecx]; 2do valor

    mov [eax], edx
    mov [ecx], ebx

    mov esp, ebp
    pop ebp
    ret 8