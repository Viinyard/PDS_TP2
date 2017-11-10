; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = sdiv i32 10, 2
%tmp2 = sdiv i32 5, %tmp1
%tmp3 = sdiv i32 4200, %tmp2
ret i32 %tmp3
}

