;Dada la subrutina:

;ES_NEGATIVO(int x)

;que recibe un entero de 32 bits por pila y retorna:

;EAX = 1  si x es negativo
;EAX = 0  si x no es negativo

;implemente un programa que recorra un arreglo de enteros de 32 bits y cuente cuántos números negativos contiene.

;El resultado debe quedar en EBX.


; el resultado esperado es EBX = 3

section .data
    A1 dd 4, -7, 2, -9, 8, -1, 3

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    xor esi, esi
    xor ebx, ebx
    
    .for:
        push [A1+4*esi]
        
        call ES_NEGATIVO
        
        cmp eax, 1
        jne .skip
        
        inc ebx
        
        .skip:
            inc esi
            cmp esi, 7
            jl .for
    
    
    ret
    
; ES_NEGATIVO(int x)
;
; Recibe:
;   [ebp+8] = x
;
; Retorna:
;   eax = 1 -> negativo
;   eax = 0 -> no negativo

ES_NEGATIVO:
    push ebp
    mov ebp, esp

    mov eax, [ebp+8]

    test eax, eax
    js .negativo

    mov eax, 0
    jmp .fin

.negativo:
    mov eax, 1

.fin:
    mov esp, ebp
    pop ebp
    ret 4