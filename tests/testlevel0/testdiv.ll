; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%tmp1 = udiv i32 4200, 5
	%tmp2 = udiv i32 %tmp1, 10
	%tmp3 = udiv i32 %tmp2, 2
	ret i32 %tmp3
}


