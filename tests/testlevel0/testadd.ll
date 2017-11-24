; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = add i32 2, 8
	%2 = add i32 %1, 10
	%3 = add i32 %2, 20
	%4 = add i32 %3, 2
	store i32 %4, i32* %0
	%5 = load i32, i32* %0
	ret i32 %5
	ret i32 0
}


