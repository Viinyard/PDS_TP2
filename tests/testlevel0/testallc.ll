; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = mul i32 10, 2
	%2 = udiv i32 %1, 4
	%3 = mul i32 %2, 1
	%4 = mul i32 3, 2
	%5 = udiv i32 %4, 2
	%6 = mul i32 %5, 7
	%7 = add i32 %3, %6
	%8 = sub i32 %7, 1
	%9 = udiv i32 8, 4
	%10 = add i32 %8, %9
	%11 = add i32 %10, 3
	%12 = add i32 %11, 5
	%13 = sub i32 %12, 1
	store i32 %13, i32* %0
	%14 = load i32, i32* %0
	ret i32 %14
	ret i32 0
}


