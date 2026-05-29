; int sumaArray(int* arr, int n)
;que:
;suma todos los elementos del arreglo
; y deja el resultado en ebx

section .data
    A1 dd 4, 7, 2, 9
    N dd 4

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    push A1
    push [N]
    
    call sum
    
    ret
    
sum:
    push ebp
    mov ebp, esp
    
    xor ebx, ebx
    xor edx, edx
    mov ecx, [ebp+8]; n
    mov eax, [ebp+12]; A1 (dir)
    
    .for:
        add edx, [eax+4*ebx]
    
        inc ebx
        loop .for
    
    mov ebx, edx
    
    mov esp, ebp
    pop ebp
    ret 8