;5. (Take Home) Construya una subrutina en assembler que dado un número
;(representado en un byte) determine si su representación binaria es palındromo o no.
;Utilice la subrutina para determinar la cantidad de palındromos (representación) de
;un arreglo de números.
;palindromo = capicua

section .data
    A1 dd 00011001b, 10000001b, 11000000b, 11000011b
    L1 dd 0

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    
   
    
    xor esi, esi
    
    .loop:
        push [A1+4*esi]
        
        call palindrome
        
        cmp eax, 1
        jne .skip
        
        add [L1], 1
        
        .skip:
            inc esi
            cmp esi, 4
            jl .loop
         
    mov eax, [L1]; deja en eax la cantidad de palindromos
    
    ret
    
    
; toma un numero en al y dice si es palindromo
palindrome:
    push ebp
    mov ebp, esp
    
    xor eax, eax
    xor ecx, ecx
    xor ebx, ebx
    xor edx, edx
 
    mov al, [ebp+8]; numero original
    
    .for:
        ; bits de la mitad derecha
        mov cl, dl; a cl le doy el valor del contador dl
        mov bl, al; bl para bits de la mitad derecha
        shr bl, cl; shiftear la posicion del contador: 0 -> 3
        and bl, 1; extrae el bit deseado
        
        ; bits de la mitad izquierda
        mov cl, 7
        sub cl, dl; cl va de 7 -> 4
        mov bh, al; bh para bits de la mitad izquierda
        shr bh, cl
        and bh, 1
        
        cmp bl, bh
        jne .noEsCapicua
        
        inc edx
        cmp edx, 4
        jl .for
        
    
    .esCapicua:
    mov eax, 1
    jmp .end
    
    .noEsCapicua:
    mov eax, 0
    
    .end:
        mov esp, ebp
        pop ebp
        ret 4