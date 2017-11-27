; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = sub i32 100, 4
	%3 = sub i32 %2, 6
	%4 = sub i32 %3, 18
	%5 = sub i32 %4, 22
	%6 = sub i32 %5, 8
	store i32 %6, i32* %1
	%7 = load i32, i32* %1
	ret i32 %7
}


