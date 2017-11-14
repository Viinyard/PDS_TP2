; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%tmp1 = add i32 2, 8
	%tmp2 = add i32 %tmp1, 10
	%tmp3 = add i32 %tmp2, 20
	%tmp4 = add i32 %tmp3, 2
	ret i32 %tmp4
}


