; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%x =  alloca i32
	store i32 1, i32* %x
	%tmp1 = load i32, i32* %x
	ret i32 %tmp1
}


