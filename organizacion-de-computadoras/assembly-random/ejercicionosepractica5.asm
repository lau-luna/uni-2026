section .data
    A1 dw 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

section .text
global main
main:
    mov ebp, esp; for correct debugging
    ;write your code here
    xor ebx, ebx
    xor edx, edx
    
    mov ecx, 10; cantidad de elementos
    
for1:
    mov ax, [A1+2*ebx]
    
    test ax, 1
    jnz impar; (si el bit menos significativo es 0, es par: sumar)
    
    ;par
    add dx, ax
    
impar:
    inc ebx
    loop for1

    ret