; Target
target triple = "x86_64-unknown-linux-gnu"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
%tmp1 = add i32 1, 1
%tmp2 = mul i32 %tmp1, 2
%tmp3 = mul i32 4, 20
%tmp4 = sdiv i32 60, 2
%tmp5 = sub i32 %tmp3, %tmp4
%tmp6 = mul i32 %tmp2, %tmp5
%tmp7 = add i32 2, 4
%tmp8 = mul i32 1, %tmp7
%tmp9 = sub i32 10, %tmp8
%tmp10 = add i32 %tmp6, %tmp9
%tmp11 = add i32 2, 2
%tmp12 = sdiv i32 %tmp10, %tmp11
%tmp13 = sub i32 9, 0
%tmp14 = mul i32 1, %tmp13
%tmp15 = sub i32 %tmp12, %tmp14
ret i32 %tmp15
}

