;Dada la subrutina:

;CANT_UNOS(int x)

;que recibe un entero de 32 bits y retorna en EAX la cantidad de bits en 1.

;calcule la suma total de bits en 1 de todos los elementos.

;Dejar el resultado en EBX.

section .data
    A1 dd 7, 15, 8, 31

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor esi, esi
    xor ebx, ebx
    
    .for:
        push [A1+4*esi]
        
        call CANT_UNOS
        
        add ebx, eax
        
        inc esi
        cmp esi, 4
        jl .for
    ret
    
    
; CANT_UNOS(int x)
;
; retorna en eax la cantidad de bits en 1

CANT_UNOS:
    push ebp
    mov ebp, esp

    mov edx, [ebp+8]

    xor eax, eax
    mov ecx, 32

.loop:
    test edx, 1
    jz .skip

    inc eax

.skip:
    shr edx, 1
    loop .loop

    mov esp, ebp
    pop ebp
    ret 4