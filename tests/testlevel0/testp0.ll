; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins


define i32 @main() {
entry:
	%0 = alloca i32
	%1 = add i32 1, 1
	%2 = mul i32 %1, 2
	%3 = mul i32 4, 20
	%4 = udiv i32 60, 2
	%5 = sub i32 %3, %4
	%6 = mul i32 %2, %5
	%7 = add i32 2, 4
	%8 = mul i32 1, %7
	%9 = sub i32 10, %8
	%10 = add i32 %6, %9
	%11 = add i32 2, 2
	%12 = udiv i32 %10, %11
	%13 = sub i32 9, 0
	%14 = mul i32 1, %13
	%15 = sub i32 %12, %14
	store i32 %15, i32* %0
	%16 = load i32, i32* %0
	ret i32 %16
	ret i32 0
}


