section .data
    L1 db 10010b; 18 dec
    L2 db 34h; 52 dec
    
    

section .text
global main
main:
    mov ebp, esp; for correct debugging
    
    xor eax, eax
    inc eax;        incremento eax en 1
    
    xor ebx, ebx
    mov bl, [L1];    muevo el 18 a ebx
    
    add EAX, 200;   sumo 200 a lo que esta e eax (queda 201)d
    
    mov ebx, L1
    mov ax, [ebx]
    
    mov al, [L2];     pongo el 52 en el AL
    mul byte [ebx]
    
    ret