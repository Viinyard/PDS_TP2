; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = add i32 3, 1
	%2 = sub i32 %1, 12
	%3 = add i32 %2, 50
	store i32 %3, i32* %0
	%4 = load i32, i32* %0
	ret i32 %4
	ret i32 0
}


