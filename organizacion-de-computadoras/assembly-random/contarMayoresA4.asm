section .data
    A1 dw 3, 8, 2, 9, 1

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor ebx, ebx; indice
    mov ecx, 5; tamaño arr
    xor edx, edx; acc 
    
for1:
    mov ax, [A1+2*ebx]
    
    cmp ax, 4
    jle seguir
    
    inc dx
   
seguir:
    inc ebx
    loop for1