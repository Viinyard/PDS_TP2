; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
; <label>:0
	%1 = alloca i32
	%2 = mul i32 10, 10
	%3 = udiv i32 %2, 2
	%4 = add i32 %3, 22
	%5 = mul i32 10, 2
	%6 = sub i32 %4, %5
	%7 = udiv i32 20, 4
	%8 = mul i32 %7, 2
	%9 = sub i32 %6, %8
	store i32 %9, i32* %1
	%10 = load i32, i32* %1
	ret i32 %10
}


