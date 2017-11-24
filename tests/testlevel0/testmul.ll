; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = mul i32 7, 3
	%2 = mul i32 %1, 2
	store i32 %2, i32* %0
	%3 = load i32, i32* %0
	ret i32 %3
	ret i32 0
}


