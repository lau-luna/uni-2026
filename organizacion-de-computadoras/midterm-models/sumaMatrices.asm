; esto es para testing, nada mas
section .data
    A1 dd 1,2,3,4,5,6,7,8,9
    B1 dd 1,1,1,1,1,1,1,1,1
    C1 dd 0,0,0,0,0,0,0,0,0
    
    n dd 3

section .text
; usar main como global para testing dentro de nasm
; luego usar sumar_matrices como global a la hora de linkear
global main
;global sumar_matrices


; TEST
; supongamos las matrices A1, B1, C1 , de tamaño 3x3
; 
;      |1|2|3|
; A1 = |4|5|6|
;      |7|8|9|
;
;      |1|1|1|
; B1 = |1|1|1|
;      |1|1|1|
;
; el resultado deberia ser
;      |2|3|4 |
; C1 = |5|6|7 |
;      |8|9|10|
main:
    mov ebp, esp; for correct debugging
    
    push [n]
    push C1
    push B1
    push A1
    
    call sumar_matrices
    
    push [n]
    push C1
    
    call sumatoria_matriz
    
    ret



; metodo que recibe en orden
;   A: direccion matriz 1
;   B: direccion matriz 2
;   C: direccion matriz 3
;   n: tamaño de las matrices
;
; Devuelve el resultado de sumar la matriz 1 con la matriz 2, dejando
; los resultados en la matriz 3.
;   A + B = C
;
; Suma matrices cuadradas n*n
;
; Para acceder a una posición de la matriz M[i][j]
;   M + n * i * d + j * d
; Siendo:
;   M: dir. matriz
;   n: tam. matriz
;   i: fila
;   j: columna
;   d: tamaño de numero
sumar_matrices:
    push ebp
    mov ebp, esp
    
    xor esi, esi;          i: indice filas
    
    .for:
        mov ecx, [ebp+20]; tam matriz
        imul ecx, 4;       porque son dd
        imul ecx, esi;     ecx = n * i * d
        
        xor ebx, ebx;      j: indice columna
        
        .for2:
            mov edx, [ebp + 8];     dir A
            add edx, ecx;           edx = M + n * i * d
            mov eax, [edx + 4*ebx]; eax = A[i][j]
            
            mov edx, [ebp + 12];    dir B
            add edx, ecx;           edx = M + n * i * d
            add eax, [edx + 4*ebx]; eax = A[i][j] + B[i][j]
            
            mov edx, [ebp + 16];    dir C
            add edx, ecx;           edx = M + n * i * d
            mov [edx + 4*ebx], eax
            
            inc ebx
            cmp ebx, [ebp+20]; tam matriz
            jl .for2
        
        inc esi
        cmp esi, 3
        jl .for
    
    mov esp, ebp
    pop ebp
    ret 16
    
    

; Metodo solo para testing
; va dejando cada elemento en eax de la matriz pasada como parametro (dir)
; toma en orden:
; direccion de matriz
; tamaño de matriz
;
; recorre desde M[0][0] hasta M[n][m]
sumatoria_matriz:
    push ebp
    mov ebp, esp
    
    xor esi, esi
    xor eax, eax
    
    .for:
        mov ecx, [ebp+12]; tam matriz
        imul ecx, 4;       porque son dd
        imul ecx, esi;     ecx = n * i * d
        
        xor ebx, ebx;      j: indice columna
        
        .for2:
            mov edx, [ebp + 8];     dir A
            add edx, ecx;           edx = M + n * i * d
            add eax, [edx + 4*ebx]; eax = A[i][j]
            
            inc ebx
            cmp ebx, 3
            jl .for2
        
        inc esi
        cmp esi, 3
        jl .for
    
    mov esp, ebp
    pop ebp
    ret 8