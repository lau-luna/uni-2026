;int contar(int* arr, int n, int valor)
;que:
;cuente cuántas veces aparece "valor"
;y deje el resultado en ebx

section .data
    A1 dd 4, 7, 4, 2, 9, 4, 1

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    
    push 4
    push 7
    push A1
    
    call contar
    
    ret
    
contar:
    push ebp
    mov ebp, esp
    
    xor ebx, ebx
    xor edx, edx
    mov eax, [ebp+8]; direccion del arreglo
    mov ecx, [ebp+12]; tamaño
    mov esi, [ebp+16]; valor
    
    .for:
        cmp esi, [eax+4*ebx] 
        jne .skip
        
        inc edx
        
        .skip:
        inc ebx
        loop .for
    
    mov ebx, edx
    
    mov esp, ebp
    pop ebp
    ret 12