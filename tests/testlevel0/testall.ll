; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = mul i32 10, 10
	%2 = udiv i32 %1, 2
	%3 = add i32 %2, 22
	%4 = mul i32 10, 2
	%5 = sub i32 %3, %4
	%6 = udiv i32 20, 4
	%7 = mul i32 %6, 2
	%8 = sub i32 %5, %7
	store i32 %8, i32* %0
	%9 = load i32, i32* %0
	ret i32 %9
	ret i32 0
}


