; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%tmp1 = mul i32 7, 3
	%tmp2 = mul i32 %tmp1, 2
	ret i32 %tmp2
}


