; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%tmp1 = add i32 3, 1
	%tmp2 = sub i32 %tmp1, 12
	%tmp3 = add i32 %tmp2, 50
	ret i32 %tmp3
}

