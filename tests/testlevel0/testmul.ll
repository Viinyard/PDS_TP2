; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = mul i32 3, 2
%tmp2 = mul i32 7, %tmp1
ret i32 %tmp2
}

