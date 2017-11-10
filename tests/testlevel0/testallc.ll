; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = mul i32 10, 2
%tmp2 = sdiv i32 %tmp1, 4
%tmp3 = mul i32 %tmp2, 1
%tmp4 = mul i32 3, 2
%tmp5 = sdiv i32 %tmp4, 2
%tmp6 = mul i32 %tmp5, 7
%tmp7 = add i32 %tmp3, %tmp6
%tmp8 = sub i32 %tmp7, 1
%tmp9 = sdiv i32 8, 4
%tmp10 = add i32 %tmp8, %tmp9
%tmp11 = add i32 %tmp10, 3
%tmp12 = add i32 %tmp11, 5
%tmp13 = sub i32 %tmp12, 1
ret i32 %tmp13
}

