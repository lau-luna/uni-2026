; 4. Realice una subrutina en assembler que calcule el mayor de dos números enteros.
;Utilice la misma para calcular el mayor valor de un arreglo de 10 elementos
;declarado en el segmento .data.

section .data
    A1 dd 2,30,2,45,1,0,20,21,9,10

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    xor edx, edx
    
    mov ebx, 1
    mov ecx, 10
    
    .for:
        push [A1 + 4*ebx ]
        push [A1 + 4*ebx -4]
        
        call max
        
        inc ebx
        loop .for
    
    ret
    
; toma dos parametros y deja el mayor en eax
max:
    push ebp
    mov ebp, esp
    
    mov eax, [ebp+8]
    
    cmp eax, [ebp+12]
    jge .skip
    
    mov eax, [ebp+12]
    
    .skip:
    mov esp, ebp
    pop ebp
    ret 8