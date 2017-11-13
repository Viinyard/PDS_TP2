; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%tmp1 = mul i32 10, 10
	%tmp2 = udiv i32 %tmp1, 2
	%tmp3 = add i32 %tmp2, 22
	%tmp4 = mul i32 10, 2
	%tmp5 = sub i32 %tmp3, %tmp4
	%tmp6 = udiv i32 20, 4
	%tmp7 = mul i32 %tmp6, 2
	%tmp8 = sub i32 %tmp5, %tmp7
	store i32 12, i32* %tmp8
	ret i32 %tmp8
}


