section .data
    L1 db 11101111b

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor eax, eax
    
    push [L1]
    
    call MAX_UNOS
    
    ; deberia ser 4 en eax
    
    ret
    
    
MAX_UNOS:
    push ebp
    mov ebp, esp
    
    xor eax, eax
    xor ebx, ebx
    xor edx, edx
    
    mov eax, [ebp+8]; numero a comparar
    mov ebx, eax
    
    .loop:
        shl ebx, 1     ; << 1
        and ebx, eax   ; ebx = ebx & eax
        
        inc edx
        
        cmp ebx, 0
        jne .loop
    
    mov eax, edx
    
    mov esp, ebp
    pop ebp
    ret 4