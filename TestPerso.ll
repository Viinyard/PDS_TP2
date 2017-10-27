; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = add i32 3, 5
%tmp2 = add i32 %tmp1, 9
%tmp3 = sub i32 %tmp2, 12
%tmp4 = add i32 1, 6
%tmp5 = sub i32 %tmp3, %tmp4
ret i32 %tmp5
}

