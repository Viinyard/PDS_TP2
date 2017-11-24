; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = sub i32 100, 4
	%2 = sub i32 %1, 6
	%3 = sub i32 %2, 18
	%4 = sub i32 %3, 22
	%5 = sub i32 %4, 8
	store i32 %5, i32* %0
	%6 = load i32, i32* %0
	ret i32 %6
	ret i32 0
}


