; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = sub i32 100, 4
%tmp2 = sub i32 %tmp1, 6
%tmp3 = sub i32 %tmp2, 18
%tmp4 = sub i32 %tmp3, 22
%tmp5 = sub i32 %tmp4, 8
ret i32 %tmp5
}

